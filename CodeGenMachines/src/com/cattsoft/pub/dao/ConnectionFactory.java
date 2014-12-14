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
//		装载connection的配置
		InputStream is = null;
		LogUtil.debug(log, "开始装连接载配置文件:"+connFile);
		is = DAOFactory.class.getClassLoader().getResourceAsStream(connFile);
		config.readProperties(is);
		
		if(!StringUtil.isBlank(config.getDsName())){
			ds = getJNDIDataSource();
		}else{
			ds = getDBCPDataSource();
		}
		if( null == ds ){
			LogUtil.error(log,"系统获取连接的数据源失败！");
			throw new AppException("","系统获取连接的数据源失败！");
		}
		
		LogUtil.debug(log,"ds: "+ds);
		try {
			Connection conn = ds.getConnection();
			LogUtil.debug(log, "connection:"+conn);
			JdbcUtil.close(conn);
			
		} catch (SQLException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("","系统获取连接的数据源失败！",e);
		}
		LogUtil.debug(log,"成功装载连接配置文件："+connFile);
		
	}
	
	
	
	
	
	/**
	 * 获得DBCP连接池的数据源
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
	 * 获得JNDI的数据源
	 * @return
	 */
	private DataSource getJNDIDataSource(){
		DataSourceUtil.setJNDI(config.getDsName());
		return DataSourceUtil.getDataSource();
		
	}
	
	
	
	
	/**
	 * 初始化连接配置和数据源
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
	 * 初始化连接配置和数据源
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
	 * 创建连接
	 * @return
	 * @throws AppException 
	 * @throws SysException 
	 */
	public static Connection createConnection() throws AppException, SysException{
		if(null == instance){
			//throw new AppException("","系统未初始化ConnectionFactory！");
			initConnectionFactory();
		}
		if (connections.get() == null) {
			LogUtil.debug(log,"获取连接中 ...");
			Connection conn = null;
			try {
				conn = instance.ds.getConnection();
				LogUtil.debug(log,"成功创建连接:"+conn);
				connections.set(conn);
			} catch (SQLException e) {
				LogUtil.debug(log,"系统创建连接失败！");
				throw new SysException("","系统创建连接失败！",e);
			}
			
		}
		return (Connection) connections.get();
	}
	
	
	
	
	
	/**
	 * 获得当前线程对应的连接
	 * @return
	 * @throws SysException 
	 * @throws SQLException
	 */
	public static Connection getConnection() throws AppException, SysException {
		Connection conn = (Connection) connections.get();
		if( null == conn){
			throw new AppException("100001","系统当前无可用连接!");
		}
		return conn;
	}

	/**
	 * 释放当前连接
	 * @throws SysException 
	 *
	 */
	public static void closeConnection() throws SysException {
		Connection conn = (Connection)connections.get();
		if (conn != null) {
			JdbcUtil.close(conn);
			LogUtil.debug(log, "释放连接："+conn);
			connections.set(null);
		}
	}

	
	

}
