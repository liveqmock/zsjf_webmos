package com.cattsoft.pub.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;

/**
 * Factory method to get thread safe connection instances <br>
 * Apr 21, 2007 10:27:21 PM
 * 
 * @author liaoyh
 */
public class ConnectionFactory {
	private static Logger log = Logger.getLogger(ConnectionFactory.class);
	private static ThreadLocal connections = new ThreadLocal();
	private String connFile = "connection_config.properties";
	private ConnectionConfig config = new ConnectionConfig();
	private DataSource ds = null;

	private static ConnectionFactory instance;
	
	private ConnectionFactory(String path) throws SysException, AppException{
		if(path != null) connFile = path;
//		װ��connection������
		InputStream is = null;
		LogUtil.debug(log, "��ʼװ�����������ļ�:"+connFile);
		is = DAOFactory.class.getClassLoader().getResourceAsStream(connFile);
		config.readProperties(is);
		
		if(!StringUtil.isBlank(config.getDsName())){
			ds = getJNDIDataSource();
		}else{
			ds = getDBCPDataSource();
		}
		if( null == ds ){
			LogUtil.error(log,"ϵͳ��ȡ���ӵ�����Դʧ�ܣ�");
			throw new AppException("","ϵͳ��ȡ���ӵ�����Դʧ�ܣ�");
		}
		
		LogUtil.debug(log,"ds: "+ds);
		try {
			Connection conn = ds.getConnection();
			LogUtil.debug(log, "connection:"+conn);
			JdbcUtil.close(conn);
			
		} catch (SQLException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("","ϵͳ��ȡ���ӵ�����Դʧ�ܣ�",e);
		}
		LogUtil.debug(log,"�ɹ�װ�����������ļ���"+connFile);
		
	}
	
	
	
	
	
	/**
	 * ���DBCP���ӳص�����Դ
	 * @return
	 */
	private DataSource getDBCPDataSource(){
	
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(config.getConnDriver());
		ds.setUsername(config.getConnUser());
		ds.setPassword(config.getConnPw());
		ds.setUrl(config.getConnURL());
		ds.setMaxActive(config.getPoolMaxActive());
		ds.setMaxIdle(config.getPoolMaxIdle());
		ds.setMaxWait(config.getPoolMaxWait());
		return ds;
		
	}
	
	
	/**
	 * ���JNDI������Դ
	 * @return
	 */
	private DataSource getJNDIDataSource(){
		DataSourceUtil.setJNDI(config.getDsName());
		return DataSourceUtil.getDataSource();
		
	}
	
	
	
	
	/**
	 * ��ʼ���������ú�����Դ
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory(String path) throws SysException, AppException{
		if(null == instance){
			instance = new ConnectionFactory(path);
		}
	}
	
	/**
	 * ��ʼ���������ú�����Դ
	 * @param path
	 * @throws SysException
	 * @throws AppException
	 */
	synchronized public static void initConnectionFactory() throws SysException, AppException{
		if(null == instance){
			instance = new ConnectionFactory(null);
		}
	}
	
	/**
	 * ��������
	 * @return
	 * @throws AppException 
	 * @throws SysException 
	 */
	public static Connection createConnection() throws AppException, SysException{
		if(null == instance){
			//throw new AppException("","ϵͳδ��ʼ��ConnectionFactory��");
			initConnectionFactory();
		}
		if (connections.get() == null) {
			LogUtil.debug(log,"��ȡ������ ...");
			Connection conn = null;
			try {
				conn = instance.ds.getConnection();
				LogUtil.debug(log,"�ɹ���������:"+conn);
				connections.set(conn);
			} catch (SQLException e) {
				LogUtil.debug(log,"ϵͳ��������ʧ�ܣ�");
				throw new SysException("","ϵͳ��������ʧ�ܣ�",e);
			}
			
		}
		return (Connection) connections.get();
	}
	
	
	
	
	
	/**
	 * ��õ�ǰ�̶߳�Ӧ������
	 * @return
	 * @throws SysException 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws AppException, SysException {
		Connection conn = (Connection) connections.get();
		if( null == conn){
			throw new AppException("100001","ϵͳ��ǰ�޿�������!");
		}
		return conn;
	}

	/**
	 * �ͷŵ�ǰ����
	 * @throws SysException 
	 *
	 */
	public static void closeConnection() throws SysException {
		Connection conn = (Connection)connections.get();
		if (conn != null) {
			JdbcUtil.close(conn);
			LogUtil.debug(log, "�ͷ����ӣ�"+conn);
			connections.set(null);
		}
	}

	
	

}
