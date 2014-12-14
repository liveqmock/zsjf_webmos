package com.cattsoft.pub;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * Description: Jndi��������<br>
 * DesDetail: ����jndiName���Ҷ���λ��,���ж��ڱ��ع��������д治����Ҫʹ�õĶ�������. �����,���ò���,���û�����ʼ�����Ļ�����ʼ���ҡ�
 * 
 * @author wangyun
 * @version 1.0
 * @data 2007-5-25
 * @action ����
 */
public class AppJndiFactory {

	private static AppJndiFactory jndiFactory;

	private static Logger log = null;

	private static java.util.HashMap jndiHome = new java.util.HashMap();

	private Context ctx = null;

	/**
	 * JNDI��Ĭ������
	 */
	public static boolean DEPLOY_FULL_EAR = true;

	public static String INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";

	public static String PROVIDER_URL = "t3://127.0.0.1:7001";

	public static String SECURITY_PRINCIPAL = "weblogic";

	public static String SECURITY_CREDENTIALS = "weblogic";

	/**
	 * Description: Jndi����<br>
	 * DesDetail: �õ������ʵ�������õ����ṹ
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param ��
	 * @return JndiFactory
	 * @exception ��
	 */
	synchronized public static AppJndiFactory getInstance() {
		if (null == jndiFactory) {
			jndiFactory = new AppJndiFactory();
			log = Logger.getLogger(AppJndiFactory.class);
			if (log.isDebugEnabled()) {
				log.debug("JndiFacotry created");
			}
		}
		return jndiFactory;
	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: ����jndi���Ʋ���Զ��home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param jndi����jndiName
	 * @return Object
	 * @exception NamingException
	 */
	public Object getHome(String jndiName) throws NamingException {
		java.lang.Object home = null;

		try {
			home = getObject(jndiName);
			home = null;// �Ȳ��ӻ��浱��ȡ�����㿪��������Ҫȡ��������
			if (null == home) {
				home = this.getHomeInteface(jndiName);
			}
		} catch (NamingException e) {
			throw e;
		}
		Object realhome = null;

		try {
			realhome = javax.rmi.PortableRemoteObject.narrow(home, Object.class);
		} catch (ClassCastException ex) {
		}
		return realhome;
	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: ����jndi���Ʋ��ұ���home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param jndi����jndiName
	 * @return Object
	 * @exception NamingException
	 */
	public Object getLocalHome(String jndiName) throws NamingException {
		java.lang.Object home = null;

		try {
			// if(log.isDebugEnabled())log.info("find "+jndiName + " Home in hashtable");
			home = getObject(jndiName);
			// if(log.isDebugEnabled())log.info("--"+jndiName + "-- Home :"+ home);
			home = null;// �Ȳ��ӻ��浱��ȡ�����㿪��������Ҫȡ��������
			if (null == home) {
				// if(log.isDebugEnabled())log.info("Not in hashtable,looking up begin");
				home = getHomeInteface(jndiName);
				// if(log.isDebugEnabled())log.info("looking up -*>" + jndiName + "<*- sucess
				// :"+home);
				/** @todo��ʱע�� * */

			}
			if (log.isDebugEnabled()) {
				log.info("looking up -*>" + jndiName + "<*- sucess :" + home);
			}

		} catch (NamingException e) {
			throw e;
		}
		Object realhome = home;

		return realhome;
	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: ����õ�home�ĺ�������getObject�ò���home��ʱ�����
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param jndi����jndiName
	 * @return Object
	 * @exception NamingException
	 */
	private Object getHomeInteface(String jndiName) throws NamingException {
		Object o = null;

		try {
			o = ctx.lookup(jndiName);
			if (o != null) {
				putObject(jndiName, o);
			}
			if (log.isDebugEnabled()) {
				log.debug("look up sucess: found " + jndiName + ":" + o);
			}
		} catch (NamingException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			throw new NamingException(e.toString());
		} finally {

		}
		return o;
	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: �ڻ����в����Ƿ��Ѿ���ָ�����Ƶ�home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param jndi����jndiName
	 * @return Object
	 * @exception NamingException
	 */
	private Object getObject(String jndiName) {
		synchronized (jndiHome) {
			return this.jndiHome.get(jndiName);
		}
	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: ���Ѿ���λ�õ�home���뻺����
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param jndi����jndiName
	 * @return Object
	 * @exception NamingException
	 */
	private void putObject(String jndiName, Object ref) {
		synchronized (jndiHome) {
			this.jndiHome.put(jndiName, ref);
		}
	}

	/*
	 * jndi.properties java.naming.factory.initial=org.jnp.interfaces.NamingContextFactory
	 * java.naming.factory.url.pkgs=org.jboss.naming:org.jnp.interfaces # Do NOT uncomment this line
	 * as it causes in VM calls to go over # RMI! #java.naming.provider.url=localhost
	 */
	/**
	 * Description: Jndi����<br>
	 * DesDetail: Jndi��������
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param ��
	 * @return ��
	 * @exception ��
	 */
	private AppJndiFactory() {

		try {
			DEPLOY_FULL_EAR = false;
			if (DEPLOY_FULL_EAR) {
				ctx = new InitialContext();
			} else {
				Hashtable ht = new Hashtable();
				ht.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
				ht.put(Context.PROVIDER_URL, PROVIDER_URL);
				if (SECURITY_PRINCIPAL != null && !SECURITY_PRINCIPAL.trim().equals("")) {
					ht.put(Context.SECURITY_PRINCIPAL, SECURITY_PRINCIPAL);
					ht.put(Context.SECURITY_CREDENTIALS, SECURITY_CREDENTIALS);
				}
				ctx = new InitialContext(ht);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Description: Jndi����<br>
	 * DesDetail: �������ejb��home��ʹ��web�����ejb���ᷢ����ͻ
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action ����
	 * @param ��
	 * @return void
	 * @exception ��
	 */
	public static void clear() {
		jndiHome.clear();
	}
}
