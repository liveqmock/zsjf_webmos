package com.cattsoft.pub.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.LogUtil;

public class ConnectionConfig {
	private static final Logger log = Logger.getLogger(ConnectionConfig.class);
	
	// 连接配置
	private static final String DATA_SOURCE = "connection.datasource";
	private static final String CONNECTION_DRIVER = "connection.driver_class";
	private static final String CONNECTION_USER = "connection.username";
	private static final String CONNECTION_PASSWORD = "connection.password";
	private static final String CONNECTION_URL = "connection.url";
	
	
	// 连接池配置
	private static final String POOL_MAX_ACTIVE = "pool.maxActive";
	private static final String POOL_MAX_WAIT = "pool.maxWait";
	private static final String POOL_MAX_IDLE = "pool.maxIdle";
	
	
	private String dsName = null;
	private String connDriver = null;
	private String connUser = null;
	private String connPw = null;
	private String connURL = null;
	private int poolMaxActive = 0;
	private int poolMaxWait = 0;
	private int poolMaxIdle = 0;
	
	
	
	
	/**
	 * 读取配置文件配置
	 * 
	 * @param is
	 * @throws SysException 
	 */
	public void readProperties(InputStream is) throws SysException{
		Properties config = new Properties();
		try{
			config.load(is);
		} catch (IOException e) {
			LogUtil.error(log, e.getMessage());
			throw new SysException("","系统读取connection配置文件失败！",e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LogUtil.error(log, e.getMessage());
					throw new SysException("","系统读取connection配置文件失败！",e);
				}
			}
		}
		
		if(config.get(DATA_SOURCE)!=null)
			this.dsName = (String)config.get(DATA_SOURCE);
		else{
			try{
				this.connDriver = (String)config.get(CONNECTION_DRIVER);
				this.connUser = (String)config.get(CONNECTION_USER);
				this.connPw = (String)config.get(CONNECTION_PASSWORD);
				this.connURL = (String)config.get(CONNECTION_URL);
				String maxActiveStr = (String)config.get(POOL_MAX_ACTIVE);
				this.poolMaxActive = Integer.parseInt(maxActiveStr);
				String maxWait = (String)config.get(POOL_MAX_WAIT);
				this.poolMaxWait = Integer.parseInt(maxWait);
				String maxIdle = (String)config.get(POOL_MAX_IDLE);
				this.poolMaxIdle = Integer.parseInt(maxIdle);
			}catch(NullPointerException e){
				LogUtil.error(log, e.getMessage());
				throw new SysException("","请检查连接池配置！",e);
			}catch(ClassCastException e){
				LogUtil.error(log, e.getMessage());
				throw new SysException("","请检查连接池配置！",e);
			}catch(NumberFormatException e){
				LogUtil.error(log, e.getMessage());
				throw new SysException("","请检查连接池配置！",e);
			}
		}
		
		LogUtil.debug(log, DATA_SOURCE +":"+ dsName);
		LogUtil.debug(log, CONNECTION_DRIVER+":" + connDriver);
		
	}




	public String getConnDriver() {
		return connDriver;
	}




	public void setConnDriver(String connDriver) {
		this.connDriver = connDriver;
	}




	public String getConnPw() {
		return connPw;
	}




	public void setConnPw(String connPw) {
		this.connPw = connPw;
	}




	public String getConnURL() {
		return connURL;
	}




	public void setConnURL(String connURL) {
		this.connURL = connURL;
	}




	public String getConnUser() {
		return connUser;
	}




	public void setConnUser(String connUser) {
		this.connUser = connUser;
	}




	public String getDsName() {
		return dsName;
	}




	public void setDsName(String dsName) {
		this.dsName = dsName;
	}




	/**
	 * @return the poolMaxActive
	 */
	public int getPoolMaxActive() {
		return poolMaxActive;
	}




	/**
	 * @param poolMaxActive the poolMaxActive to set
	 */
	public void setPoolMaxActive(int poolMaxActive) {
		this.poolMaxActive = poolMaxActive;
	}




	/**
	 * @return the poolMaxIdle
	 */
	public int getPoolMaxIdle() {
		return poolMaxIdle;
	}




	/**
	 * @param poolMaxIdle the poolMaxIdle to set
	 */
	public void setPoolMaxIdle(int poolMaxIdle) {
		this.poolMaxIdle = poolMaxIdle;
	}




	/**
	 * @return the poolMaxWait
	 */
	public int getPoolMaxWait() {
		return poolMaxWait;
	}




	/**
	 * @param poolMaxWait the poolMaxWait to set
	 */
	public void setPoolMaxWait(int poolMaxWait) {
		this.poolMaxWait = poolMaxWait;
	}





}

	
