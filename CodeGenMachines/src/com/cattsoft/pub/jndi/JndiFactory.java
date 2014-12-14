package com.cattsoft.pub.jndi;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: �������ò��Ҷ�Ӧjndicontext<br>
 * Date: 2007-8-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class JndiFactory {

	private static JndiFactory jndiFactory;

	private static final String CONTEXTS_FILE = "context-config.xml"; 
	
	private static Logger log = Logger.getLogger(JndiFactory.class);

	// ���õĶ��context����
	private Map contexts = new HashMap();

	// Ĭ��context����
	private Context defaultCtx = null;

	private String defaultName = "";

	private Map jndiTreeMap = new HashMap();

	/**
	 * ��ȡJndi����ʵ��
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static JndiFactory getInstance() throws SysException, AppException {
		if (null == jndiFactory) {
			jndiFactory = new JndiFactory();
			LogUtil.debug(log, "JndiFacotry �����ɹ���");
		}
		return jndiFactory;
	}
	
	
	/**
	 * ����jndi���Ʋ���Ĭ��context��Զ��home
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	public Object getHome(String jndiName) throws NamingException, SysException, AppException {
		return getHome(defaultName,jndiName);
	}

	/**
	 * ����context���ƺ�jndi���Ʋ���Զ��home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws AppException
	 * @throws SysException
	 */
	public Object getHome(String ctxName,String jndiName) throws NamingException, SysException, AppException {
		java.lang.Object home = null;

		home = getObject(ctxName, jndiName);
		home = null;// �Ȳ��ӻ��浱��ȡ�����㿪��������Ҫȡ��������
		if (null == home) {
			home = this.getHomeInteface(ctxName, jndiName);
		}
		
		Object realhome = null;
		try {
			realhome = javax.rmi.PortableRemoteObject.narrow(home, Object.class);
		} catch (ClassCastException ex) {
			throw new SysException("", "EJBԶ�̽ӿ�narrow����jndi:" + jndiName, ex);
		}
		return realhome;
	}

	
	/**
	 * ����jndi���Ʋ���Ĭ��context�ı���home
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	public Object getLocalHome(String jndiName) throws NamingException, SysException, AppException {
		return getLocalHome(defaultName,jndiName);
	}
	
	
	/**
	 * ����context���ƺ�jndi���Ʋ��ұ���home
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws AppException
	 * @throws SysException
	 */
	public Object getLocalHome(String ctxName,String jndiName) throws NamingException, SysException, AppException {
		java.lang.Object home = null;

		// if(log.isDebugEnabled())log.info("find "+jndiName + " Home in hashtable");
		home = getObject(ctxName, jndiName);
		// if(log.isDebugEnabled())log.info("--"+jndiName + "-- Home :"+ home);
		home = null;// �Ȳ��ӻ��浱��ȡ�����㿪��������Ҫȡ��������
		if (null == home) {
			// if(log.isDebugEnabled())log.info("Not in hashtable,looking up begin");
			home = getHomeInteface(ctxName, jndiName);
			LogUtil.info(log,"looking up -*>" + jndiName + "<*- sucess:"+home);
		}
		
		LogUtil.info(log,"looking up -*>" + jndiName + "<*- sucess :" + home);
		Object realhome = home;

		return realhome;
	}

	/**
	 * ����õ�home�ĺ�������getObject�ò���home��ʱ�����
	 * 
	 * @param jndiName
	 * @return
	 * @throws NamingException
	 * @throws SysException
	 * @throws AppException
	 */
	private Object getHomeInteface(String ctxName, String jndiName) throws SysException,
			AppException {
		Object o = null;
		Object ctxObj = contexts.get(ctxName);
		if (ctxObj == null)
			throw new AppException("", "ϵͳ�Ҳ�����Ӧ��Context������" + ctxName);
		Context ctx = (Context) ctxObj;
		try {
			o = ctx.lookup(jndiName);
			if (o != null) {
				putObject(ctxName, jndiName, o);
			}
			LogUtil.debug(log, "look up sucess: found " + jndiName + ":" + o);
		} catch (NamingException e) {
			throw new SysException("", "ϵͳ�Ҳ�����Ӧ��JNDI��Դ��jndi:" + jndiName, e);
		}
		return o;
	}

	/**
	 * �ڻ����в����Ƿ��Ѿ���ָ�����Ƶ�home
	 * 
	 * @param jndiName
	 * @return
	 */
	synchronized private Object getObject(String ctxName, String jndiName) {
		Object jndiObj = jndiTreeMap.get(ctxName);
		if (jndiObj == null)
			return null;
		Map jndiMap = (Map) jndiObj;
		return jndiMap.get(jndiName);

	}

	/**
	 * ���Ѿ���λ�õ�home���뻺����
	 * 
	 * @param jndiName
	 * @param ref
	 */
	synchronized private void putObject(String ctxName, String jndiName, Object ref) {
		Map jndiMap = null;

		Object jndiObj = jndiTreeMap.get(ctxName);
		if (jndiObj == null) {
			jndiMap = new HashMap();
		} else {
			jndiMap = (Map) jndiObj;
		}

		jndiMap.put(jndiName, ref);

	}

	/**
	 * �������ļ�����ʼ��contexts
	 * 
	 * @throws SysException
	 * @throws AppException
	 */
	private JndiFactory() throws SysException, AppException {

		ContextConfigReader ctxReader = new ContextConfigReader();
		InputStream in;
		
			LogUtil.debug(log, "��ʼװ�������ļ�:"+CONTEXTS_FILE);
			in = JndiFactory.class.getClassLoader().getResourceAsStream(CONTEXTS_FILE);
			ctxReader.read(in);
			ContextConfigDef pro = ctxReader.getConfigDef();
			Iterator itor = pro.getContexts().keySet().iterator();
			String ctxName = null;
			while (itor.hasNext()) {
				ctxName = (String) itor.next();
				ContextDef ctxDef = (ContextDef) pro.getContexts().get(ctxName);
				Context ctx = null;
				String intialContext = ctxDef.getInitialContext();
				try {
					if (!StringUtil.isBlank(intialContext) && 
							intialContext.trim().toUpperCase().equals(ContextDef.INITIAL_CONTEXT_TRUE)) {
						ctx = new InitialContext();
					} else {
						Hashtable ht = new Hashtable();
						ht.put(Context.INITIAL_CONTEXT_FACTORY, ctxDef.getInitContextFactory().trim());
						ht.put(Context.PROVIDER_URL, ctxDef.getProviderUrl());
						if (!StringUtil.isBlank(ctxDef.getSecurityPrincipal())) {
							ht.put(Context.SECURITY_PRINCIPAL, ctxDef.getSecurityPrincipal());
							ht.put(Context.SECURITY_CREDENTIALS, ctxDef.getSecurityCredentials());
						}
						ctx = new InitialContext(ht);						
					}
				} catch (NamingException e) {
					LogUtil.debug(log,"��ʼ��contextʧ�ܣ�Context_Name:"+ctxDef.getName());
				}
				contexts.put(ctxName, ctx);
			}
			Object obj = contexts.get(pro.getDefaultName());
			if (obj == null)
				throw new AppException("", "ϵͳδ�ҵ�Ĭ��context������");
			this.defaultCtx = (Context) obj;
			this.defaultName = pro.getDefaultName();
			LogUtil.info(log, "Ĭ��context:"+defaultName+"/" + defaultCtx);
		

	}

	/**
	 * �������ejb��context��ejb��
	 * 
	 *
	 */
	public  void clear() {
		jndiTreeMap.clear();
	}
	
	public Map getContexts(){
		return contexts;
	}
	
	public String getDefaultName(){
		return defaultName;
	}
	
	
	public static void main(String[] args) throws SysException, AppException {
		Map map = JndiFactory.getInstance().getContexts(); 
		
		Iterator itor = map.keySet().iterator();
		while(itor.hasNext()){
			String key = (String)itor.next();
			LogUtil.debug(log, "key="+key+"/"+map.get(key));
		}
		
	}
	
	
}
