package com.cattsoft.webpub.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.cattsoft.pub.LogConfig;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.jndi.JndiFactory;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.SysDate;
public class InitConfig extends HttpServlet {
	private static final Logger log = Logger.getLogger(InitConfig.class);

	private ServletConfig config;

	private static final String DAO_CONFIG = "DAOConfig";
	private static final String CONNECTION_CONFIG = "ConnectionConfig";

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// 初始化dao配置
		config = this.getServletConfig();		
		LogConfig.init();
		System.out.print("complete log init .");
		String connConfigStr = config.getInitParameter(CONNECTION_CONFIG.trim());
		String DAOConfigStr = config.getInitParameter(DAO_CONFIG).trim();
		
		System.out.println("connConfigStrconnConfigStrconnConfigStr="+connConfigStr);

		try {
			LogUtil.debug(log, "开始装载Connection配置...");
			ConnectionFactory.initConnectionFactory(connConfigStr);
			JndiFactory.getInstance();
			
			LogUtil.debug(log, "开始装载DAO配置...");
			DAOFactory.initDAOFactory(DAOConfigStr);
			
			LogUtil.debug(log, "开始初始化缓存数据...");
			//DataCache.initial();
			/*/com.cattsoft.pub.util.DataCache.initHashMaps(null);
			com.cattsoft.pub.util.DataCache.initTreeHashMap(null);
			com.cattsoft.pub.util.DataCache.initStatusHashMap(null);
			com.cattsoft.pub.util.DataCache.initSysAreaConfigHashMap();
			com.cattsoft.pub.util.DataCache.initSysConfigHashMap();*/
			
			SysDate.getCurrentDate();
			
		} catch (SysException e) {
			LogUtil.error(log, e.getMessage());
			throw new RuntimeException(e);
		} catch (AppException e) {
			LogUtil.error(log, e.getMessage());
			throw new RuntimeException(e);
		} /*catch (DataCacheException e) {
			LogUtil.error(log, e.getMessage());
			throw new RuntimeException(e);
		}*/
		
	}

	

}
