package com.cattsoft.pub.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * 
 * Title: 服务开通系统<br>
 * Description: 通过配置的连接池、数据源获取连接<br>
 * Date: 2007-8-17 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class ConnectionFactory {
	private static Logger log = Logger.getLogger(ConnectionFactory.class);

	private static final String CONNECTIONS_FILE = "connection-config.xml";

	// 配置的多个connection的ThreadLocal
	private Map threadConns = new HashMap();

	private Map dataSourceMap = new HashMap();

	// 默认dataSource名称
	private DataSource defaultDataSource = null;

	private String defaultName = "";

	private static ConnectionFactory instance;

	private ConnectionFactory(String path) throws SysException, AppException {
		ConnectionConfigReader connReader = new ConnectionConfigReader();
		InputStream in;

		LogUtil.debug(log, "开始装载配置文件:" + CONNECTIONS_FILE);
		in = ConnectionFactory.class.getClassLoader().getResourceAsStream(CONNECTIONS_FILE);
		connReader.read(in);
		ConnectionConfigDef pro = connReader.getConfigDef();
		Iterator itor = pro.getConnections().keySet().iterator();
		String connName = null;
		DataSource ds = null;
		while (itor.hasNext()) {
			connName = (String) itor.next();
			ConnectionDef connDef = (ConnectionDef) pro.getConnections().get(connName);
			String datasource = connDef.getDatasource();
			if (!StringUtil.isBlank(datasource)) {
				ds = getJNDIDataSource(connDef);
			} else {
				ds = getDBCPDataSource(connDef);
			}
			if (null == ds) {
				LogUtil.error(log, "系统获取连接的数据源失败！" + connName);
			}
			LogUtil.debug(log, "ds: " + ds);
			dataSourceMap.put(connName, ds);
			threadConns.put(connName, new ThreadLocal());
		}
		Object obj = dataSourceMap.get(pro.getDefaultName());
		if (obj == null)
			throw new AppException("", "系统未找到默认数据源！");
		this.defaultDataSource = (DataSource) obj;
		this.defaultName = pro.getDefaultName();
		LogUtil.info(log, "默认数据源:" + defaultName + "/" + defaultDataSource);

		try {
			Connection conn = defaultDataSource.getConnection();
			LogUtil.debug(log, "connection:" + conn);
			JdbcUtil.close(conn);

		} catch (SQLException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("", "系统获取默认连接的数据源失败！", e);
		}
		LogUtil.debug(log, "成功装载连接配置文件：" + CONNECTIONS_FILE);

	}

	/**
	 * 获得DBCP连接池的数据源
	 * 
	 * @return
	 */
	private DataSource getDBCPDataSource(ConnectionDef connDef) {

		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(connDef.getDriverClass());
		ds.setUsername(connDef.getUserName());
		ds.setPassword(connDef.getPassword());
		ds.setUrl(connDef.getUrl());
		ds.setMaxActive(Integer.parseInt(connDef.getPoolMaxActive()));
		ds.setMaxIdle(Integer.parseInt(connDef.getPoolMaxIdle()));
		ds.setMaxWait(Integer.parseInt(connDef.getPoolMaxWait()));
		return ds;

	}

	/**
	 * 获得JNDI的数据源
	 * 
	 * @return
	 */
	private DataSource getJNDIDataSource(ConnectionDef connDef) {
		System.out.println("xxxxxxxxxxx");
		DataSourceUtil.setJNDI(connDef.getDatasource());
		return DataSourceUtil.getDataSource();

	}

	/**
	 * 初始化连接配置和数据源
	 * 
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory(String path) throws SysException,
			AppException {
		if (null == instance) {
			instance = new ConnectionFactory(path);
		}
	}

	/**
	 * 初始化连接配置和数据源
	 * 
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory() throws SysException, AppException {
		if (null == instance) {
			instance = new ConnectionFactory(null);
		}
	}

	/**
	 * 创建连接
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection() throws AppException, SysException {
		return createConnection(instance.defaultName);
	}

	/**
	 * 创建连接
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection(String name) throws AppException, SysException {
		if (null == instance) {
			// throw new AppException("","系统未初始化ConnectionFactory！");
			initConnectionFactory();
		}
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		
		if (threadConn.get() == null) {
			LogUtil.debug(log, "获取连接中 ...");
			Connection conn = null;
			try {
				conn = instance.defaultDataSource.getConnection();
				LogUtil.debug(log, "成功创建连接:" + conn);
				threadConn.set(conn);
			} catch (SQLException e) {
				LogUtil.debug(log, "系统创建连接失败！");
				throw new SysException("", "系统创建连接失败！", e);
			}

		}
		return (Connection) threadConn.get();
	}

	/**
	 * 获得当前线程对应的连接
	 * 
	 * @return
	 * @throws SysException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws AppException, SysException {
		return getConnection(instance.defaultName);
	}

	/**
	 * 获得当前线程对应的连接
	 * 
	 * @return
	 * @throws SysException
	 * @throws SQLException
	 */
	public static Connection getConnection(String name) throws AppException, SysException {
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		Connection conn = (Connection) threadConn.get();
		if (null == conn) {
			throw new AppException("100001", "系统当前无可用连接!");
		}
		return conn;
	}

	/**
	 * 释放当前连接
	 * 
	 * @throws SysException
	 * 
	 */
	public static void closeConnection() throws SysException {
		closeConnection(instance.defaultName);
	}

	/**
	 * 释放当前连接
	 * 
	 * @throws SysException
	 * 
	 */
	public static void closeConnection(String name) throws SysException {
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		Connection conn = (Connection) threadConn.get();
		if (conn != null) {
			JdbcUtil.close(conn);
			LogUtil.debug(log, "释放连接：" + conn);
			threadConn.set(null);
		}
	}
	
	public static void main(String[] args) throws SysException, AppException {
		ConnectionFactory.initConnectionFactory();
	}

}
