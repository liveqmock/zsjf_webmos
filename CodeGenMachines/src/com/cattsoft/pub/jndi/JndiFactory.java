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
 * Title: 服务开通系统<br>
 * Description: 根据配置查找对应jndicontext<br>
 * Date: 2007-8-15 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class JndiFactory {

	private static JndiFactory jndiFactory;

	private static final String CONTEXTS_FILE = "context-config.xml"; 
	
	private static Logger log = Logger.getLogger(JndiFactory.class);

	// 配置的多个context环境
	private Map contexts = new HashMap();

	// 默认context名称
	private Context defaultCtx = null;

	private String defaultName = "";

	private Map jndiTreeMap = new HashMap();

	/**
	 * 获取Jndi工厂实例
	 * 
	 * @return
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static JndiFactory getInstance() throws SysException, AppException {
		if (null == jndiFactory) {
			jndiFactory = new JndiFactory();
			LogUtil.debug(log, "JndiFacotry 创建成功。");
		}
		return jndiFactory;
	}
	
	
	/**
	 * 根据jndi名称查找默认context的远程home
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
	 * 根据context名称和jndi名称查找远程home
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
		home = null;// 先不从缓存当中取，方便开发。生产要取消该设置
		if (null == home) {
			home = this.getHomeInteface(ctxName, jndiName);
		}
		
		Object realhome = null;
		try {
			realhome = javax.rmi.PortableRemoteObject.narrow(home, Object.class);
		} catch (ClassCastException ex) {
			throw new SysException("", "EJB远程接口narrow错误！jndi:" + jndiName, ex);
		}
		return realhome;
	}

	
	/**
	 * 根据jndi名称查找默认context的本地home
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
	 * 根据context名称和jndi名称查找本地home
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
		home = null;// 先不从缓存当中取，方便开发。生产要取消该设置
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
	 * 具体得到home的函数，在getObject得不到home的时候调用
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
			throw new AppException("", "系统找不到对应的Context环境！" + ctxName);
		Context ctx = (Context) ctxObj;
		try {
			o = ctx.lookup(jndiName);
			if (o != null) {
				putObject(ctxName, jndiName, o);
			}
			LogUtil.debug(log, "look up sucess: found " + jndiName + ":" + o);
		} catch (NamingException e) {
			throw new SysException("", "系统找不到对应的JNDI资源！jndi:" + jndiName, e);
		}
		return o;
	}

	/**
	 * 在缓存中查找是否已经有指定名称的home
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
	 * 将已经定位好的home放入缓存中
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
	 * 读配置文件，初始化contexts
	 * 
	 * @throws SysException
	 * @throws AppException
	 */
	private JndiFactory() throws SysException, AppException {

		ContextConfigReader ctxReader = new ContextConfigReader();
		InputStream in;
		
			LogUtil.debug(log, "开始装载配置文件:"+CONTEXTS_FILE);
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
					LogUtil.debug(log,"初始化context失败！Context_Name:"+ctxDef.getName());
				}
				contexts.put(ctxName, ctx);
			}
			Object obj = contexts.get(pro.getDefaultName());
			if (obj == null)
				throw new AppException("", "系统未找到默认context环境！");
			this.defaultCtx = (Context) obj;
			this.defaultName = pro.getDefaultName();
			LogUtil.info(log, "默认context:"+defaultName+"/" + defaultCtx);
		

	}

	/**
	 * 清除已有ejb的context和ejb，
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
