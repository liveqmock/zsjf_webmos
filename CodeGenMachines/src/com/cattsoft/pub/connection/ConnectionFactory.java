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
 * Title: ����ͨϵͳ<br>
 * Description: ͨ�����õ����ӳء�����Դ��ȡ����<br>
 * Date: 2007-8-17 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class ConnectionFactory {
	private static Logger log = Logger.getLogger(ConnectionFactory.class);

	private static final String CONNECTIONS_FILE = "connection-config.xml";

	// ���õĶ��connection��ThreadLocal
	private Map threadConns = new HashMap();

	private Map dataSourceMap = new HashMap();

	// Ĭ��dataSource����
	private DataSource defaultDataSource = null;

	private String defaultName = "";

	private static ConnectionFactory instance;

	private ConnectionFactory(String path) throws SysException, AppException {
		ConnectionConfigReader connReader = new ConnectionConfigReader();
		InputStream in;

		LogUtil.debug(log, "��ʼװ�������ļ�:" + CONNECTIONS_FILE);
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
				LogUtil.error(log, "ϵͳ��ȡ���ӵ�����Դʧ�ܣ�" + connName);
			}
			LogUtil.debug(log, "ds: " + ds);
			dataSourceMap.put(connName, ds);
			threadConns.put(connName, new ThreadLocal());
		}
		Object obj = dataSourceMap.get(pro.getDefaultName());
		if (obj == null)
			throw new AppException("", "ϵͳδ�ҵ�Ĭ������Դ��");
		this.defaultDataSource = (DataSource) obj;
		this.defaultName = pro.getDefaultName();
		LogUtil.info(log, "Ĭ������Դ:" + defaultName + "/" + defaultDataSource);

		try {
			Connection conn = defaultDataSource.getConnection();
			LogUtil.debug(log, "connection:" + conn);
			JdbcUtil.close(conn);

		} catch (SQLException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("", "ϵͳ��ȡĬ�����ӵ�����Դʧ�ܣ�", e);
		}
		LogUtil.debug(log, "�ɹ�װ�����������ļ���" + CONNECTIONS_FILE);

	}

	/**
	 * ���DBCP���ӳص�����Դ
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
	 * ���JNDI������Դ
	 * 
	 * @return
	 */
	private DataSource getJNDIDataSource(ConnectionDef connDef) {
		System.out.println("xxxxxxxxxxx");
		DataSourceUtil.setJNDI(connDef.getDatasource());
		return DataSourceUtil.getDataSource();

	}

	/**
	 * ��ʼ���������ú�����Դ
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
	 * ��ʼ���������ú�����Դ
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
	 * ��������
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection() throws AppException, SysException {
		return createConnection(instance.defaultName);
	}

	/**
	 * ��������
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Connection createConnection(String name) throws AppException, SysException {
		if (null == instance) {
			// throw new AppException("","ϵͳδ��ʼ��ConnectionFactory��");
			initConnectionFactory();
		}
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		
		if (threadConn.get() == null) {
			LogUtil.debug(log, "��ȡ������ ...");
			Connection conn = null;
			try {
				conn = instance.defaultDataSource.getConnection();
				LogUtil.debug(log, "�ɹ���������:" + conn);
				threadConn.set(conn);
			} catch (SQLException e) {
				LogUtil.debug(log, "ϵͳ��������ʧ�ܣ�");
				throw new SysException("", "ϵͳ��������ʧ�ܣ�", e);
			}

		}
		return (Connection) threadConn.get();
	}

	/**
	 * ��õ�ǰ�̶߳�Ӧ������
	 * 
	 * @return
	 * @throws SysException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws AppException, SysException {
		return getConnection(instance.defaultName);
	}

	/**
	 * ��õ�ǰ�̶߳�Ӧ������
	 * 
	 * @return
	 * @throws SysException
	 * @throws SQLException
	 */
	public static Connection getConnection(String name) throws AppException, SysException {
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		Connection conn = (Connection) threadConn.get();
		if (null == conn) {
			throw new AppException("100001", "ϵͳ��ǰ�޿�������!");
		}
		return conn;
	}

	/**
	 * �ͷŵ�ǰ����
	 * 
	 * @throws SysException
	 * 
	 */
	public static void closeConnection() throws SysException {
		closeConnection(instance.defaultName);
	}

	/**
	 * �ͷŵ�ǰ����
	 * 
	 * @throws SysException
	 * 
	 */
	public static void closeConnection(String name) throws SysException {
		ThreadLocal threadConn = (ThreadLocal) instance.threadConns.get(name);
		Connection conn = (Connection) threadConn.get();
		if (conn != null) {
			JdbcUtil.close(conn);
			LogUtil.debug(log, "�ͷ����ӣ�" + conn);
			threadConn.set(null);
		}
	}
	
	public static void main(String[] args) throws SysException, AppException {
		ConnectionFactory.initConnectionFactory();
	}

}
