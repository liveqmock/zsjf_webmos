package com.cattsoft.pub;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * Description: Jndi工厂方法<br>
 * DesDetail: 根据jndiName查找对象位置,先判断在本地工厂缓存中存不存在要使用的对象引用. 如果有,则不用查找,如果没有则初始上下文环境开始查找。
 * 
 * @author wangyun
 * @version 1.0
 * @data 2007-5-25
 * @action 创建
 */
public class AppJndiFactory {

	private static AppJndiFactory jndiFactory;

	private static Logger log = null;

	private static java.util.HashMap jndiHome = new java.util.HashMap();

	private Context ctx = null;

	/**
	 * JNDI的默认设置
	 */
	public static boolean DEPLOY_FULL_EAR = true;

	public static String INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";

	public static String PROVIDER_URL = "t3://127.0.0.1:7001";

	public static String SECURITY_PRINCIPAL = "weblogic";

	public static String SECURITY_CREDENTIALS = "weblogic";

	/**
	 * Description: Jndi工厂<br>
	 * DesDetail: 得到本类的实例。利用单例结构
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param 无
	 * @return JndiFactory
	 * @exception 无
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
	 * Description: Jndi工厂<br>
	 * DesDetail: 根据jndi名称查找远程home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param jndi名称jndiName
	 * @return Object
	 * @exception NamingException
	 */
	public Object getHome(String jndiName) throws NamingException {
		java.lang.Object home = null;

		try {
			home = getObject(jndiName);
			home = null;// 先不从缓存当中取，方便开发。生产要取消该设置
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
	 * Description: Jndi工厂<br>
	 * DesDetail: 根据jndi名称查找本地home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param jndi名称jndiName
	 * @return Object
	 * @exception NamingException
	 */
	public Object getLocalHome(String jndiName) throws NamingException {
		java.lang.Object home = null;

		try {
			// if(log.isDebugEnabled())log.info("find "+jndiName + " Home in hashtable");
			home = getObject(jndiName);
			// if(log.isDebugEnabled())log.info("--"+jndiName + "-- Home :"+ home);
			home = null;// 先不从缓存当中取，方便开发。生产要取消该设置
			if (null == home) {
				// if(log.isDebugEnabled())log.info("Not in hashtable,looking up begin");
				home = getHomeInteface(jndiName);
				// if(log.isDebugEnabled())log.info("looking up -*>" + jndiName + "<*- sucess
				// :"+home);
				/** @todo临时注释 * */

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
	 * Description: Jndi工厂<br>
	 * DesDetail: 具体得到home的函数，在getObject得不到home的时候调用
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param jndi名称jndiName
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
	 * Description: Jndi工厂<br>
	 * DesDetail: 在缓存中查找是否已经有指定名称的home
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param jndi名称jndiName
	 * @return Object
	 * @exception NamingException
	 */
	private Object getObject(String jndiName) {
		synchronized (jndiHome) {
			return this.jndiHome.get(jndiName);
		}
	}

	/**
	 * Description: Jndi工厂<br>
	 * DesDetail: 将已经定位好的home放入缓存中
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param jndi名称jndiName
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
	 * Description: Jndi工厂<br>
	 * DesDetail: Jndi工厂构造
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param 无
	 * @return 无
	 * @exception 无
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
	 * Description: Jndi工厂<br>
	 * DesDetail: 清楚已有ejb的home，使得web层调用ejb不会发生冲突
	 * 
	 * @author wangyun
	 * @version 1.0
	 * @data 2007-5-25
	 * @action 创建
	 * @param 无
	 * @return void
	 * @exception 无
	 */
	public static void clear() {
		jndiHome.clear();
	}
}
