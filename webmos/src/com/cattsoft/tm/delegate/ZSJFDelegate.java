package com.cattsoft.tm.delegate;

import java.sql.Connection;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.tm.component.domain.ZSJFDOM;
import com.cattsoft.tm.vo.TRptJtbbQsfzrbSVO;


public class ZSJFDelegate {
	private static Log log = LogFactory.getLog(ZSJFDelegate.class);
	private static ZSJFDelegate delegate = null;
	private ZSJFDelegate() {

	}

	public static ZSJFDelegate getDelegate() {
		if (delegate == null) {
			delegate = new ZSJFDelegate();
		}
		return delegate;
	}	

	public String login(String reqParm) throws AppException,SysException{

		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.login(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	public String getLateVersion4MOS(String reqParm) throws AppException,SysException{

		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.getLateVersion4MOS(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	
	
	/**
	 * 重点关注之重点业务发展日报
	 * @param reqParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String zdgz4zdywrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.zdgz4zdywrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 呼市日报之重点业务发展日报
	 * @param reqParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsrb4zdywfzrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4zdywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = ret.toString();
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 呼市日报之3G业务日报
	 */
	public String hsrb43gyw(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb43gyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 呼市日报之2G业务日报
	 */
	public String hsrb42gyw(String reqParm ) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb42gyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	
	}
	
	/**
	 * 呼市日报之宽带业务日报
	 */
	public String hsrb4kdyw(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4kdyw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	

	/**
	 * 呼市日报之2G3G融合
	 */
	public String hsrb42g3grh(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb42g3grh(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	

	/**
	 * 呼市日报之重点业务揽装日报
	 */
	public String hsrb4zdywlz(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4zdywlz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * 呼市日报之客户经理揽装日报
	 */
	public String hsrb4khjllz(String reqParm) throws AppException, SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4khjllz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * 集团日报之区级、市级业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4qsjywfzrb(String reqParm) throws AppException,
			SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.jtrb4qsjywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String modifyPwd(String reqParm) throws AppException,
			SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.modifyPwd(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 集团日报之区级、市级业务发展日报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4hybywfzrb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.jtrb4hybywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	

	/**
	 * 渠道日报各网点业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String qdrb4gwdywfzrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.qdrb4gwdywfzrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 渠道日报 渠道网格重点业务日报
	 * @param m
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String qdrb4qdwgzdywrb(String reqParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.qdrb4qdwgzdywrb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	
	}
	
	/**
	 * 呼市月报4关键指标月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4gjzbyb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb4gjzbyb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * 呼市月报43G业务月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb43gywyb(String reqParm) throws AppException,
			SysException {
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb43gywyb(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	
	/**
	 * 呼市月报4宽带月发展情况
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4kdyfzqk(String reqParm)  throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsyb4kdyfzqk(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * 呼市日报4网格经理重点关注
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsrb4wgjlzdgz(String reqParm)  throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.hsrb4wgjlzdgz(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	/**
	 * 报表说明列表
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String getReportIntrouctionList(String reParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.getReportIntrouctionList(reParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	
	}
	
	
	/**
	 * 工程竣工信息统计
	 * @param reParm
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showGCJGTJReport(String reqParm) throws AppException,SysException{

		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.showGCJGTJReport(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	/**
	 * 月报，收入环比通报，按客户群
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showYB4Srhbtbkhq(String reqParm)  throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.showYB4Srhbtbkhq(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	
		
	}
	
	
	
	public String showGCZTTJReport(String reParm) throws AppException,SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.showGCZTTJReport(reParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	
	}
	
	
	/**
	 * 月报，收入环比通报，按业务
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String showYB4srhbtb4yw(String reqParm) throws AppException,
	SysException{
		Connection conn = null;
		String returnValue = null;
		try {
			conn = ConnectionFactory.createConnection();
			conn.setAutoCommit(false);
			ZSJFDOM dom=new ZSJFDOM();
			returnValue=dom.showYB4srhbtb4yw(reqParm);
			ConnectionFactory.commit();
		} catch (Exception e) { 
			e.printStackTrace();
			log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
			try {
				ConnectionFactory.rollback();
				JSONObject ret = new JSONObject();
				ret.put("resultCode", 0);
				ret.put("resultInfo", e.getMessage());
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		} finally {
			try {
				ConnectionFactory.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
				returnValue = StringUtil.getAppException4MOS(e.getMessage());
			}
		}
		return returnValue;
	}
	
	//月报，收入环比通报，按网格
		public String showYB4srhbtb4wg(String reqParm) throws AppException,
		SysException{
			Connection conn = null;
			String returnValue = null;
			try {
				conn = ConnectionFactory.createConnection();
				conn.setAutoCommit(false);
				ZSJFDOM dom=new ZSJFDOM();
				returnValue=dom.showYB4srhbtb4wg(reqParm);
				ConnectionFactory.commit();
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
				try {
					ConnectionFactory.rollback();
					JSONObject ret = new JSONObject();
					ret.put("resultCode", 0);
					ret.put("resultInfo", e.getMessage());
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				} catch (Exception e1) {
					e1.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			} finally {
				try {
					ConnectionFactory.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			}
			return returnValue;
		
		}
		
		/**
		 * 旗县收入环比通报
		 */
		public String showYB4srhbtb4qx(String reqParm) throws AppException,
		SysException{
			Connection conn = null;
			String returnValue = null;
			try {
				conn = ConnectionFactory.createConnection();
				conn.setAutoCommit(false);
				ZSJFDOM dom=new ZSJFDOM();
				returnValue=dom.showYB4srhbtb4qx(reqParm);
				ConnectionFactory.commit();
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
				try {
					ConnectionFactory.rollback();
					JSONObject ret = new JSONObject();
					ret.put("resultCode", 0);
					ret.put("resultInfo", e.getMessage());
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				} catch (Exception e1) {
					e1.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			} finally {
				try {
					ConnectionFactory.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			}
			return returnValue;
		
		
			
		}
		
		
		/**
		 * 校园日报 校园网格重点业务日报
		 * 
		 * @param m
		 * @return
		 * @throws AppException
		 * @throws SysException
		 */
		public String xyrb4xywgzdywrb(String reqParm) throws AppException, SysException{
			Connection conn = null;
			String returnValue = null;
			try {
				conn = ConnectionFactory.createConnection();
				conn.setAutoCommit(false);
				ZSJFDOM dom=new ZSJFDOM();
				returnValue=dom.xyrb4xywgzdywrb(reqParm);
				ConnectionFactory.commit();
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
				try {
					ConnectionFactory.rollback();
					JSONObject ret = new JSONObject();
					ret.put("resultCode", 0);
					ret.put("resultInfo", e.getMessage());
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				} catch (Exception e1) {
					e1.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			} finally {
				try {
					ConnectionFactory.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			}
			return returnValue;
		}
		
		
		/**
		 * 日通报-渠道客户经理日报
		 * 
		 * @param m
		 * @return
		 * @throws AppException
		 * @throws SysException
		 */
		public String rtb4qdkhjlrb(String reqm) throws AppException, SysException {
			Connection conn = null;
			String returnValue = null;
			try {
				conn = ConnectionFactory.createConnection();
				conn.setAutoCommit(false);
				ZSJFDOM dom=new ZSJFDOM();
				returnValue=dom.rtb4qdkhjlrb(reqm);
				ConnectionFactory.commit();
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
				try {
					ConnectionFactory.rollback();
					JSONObject ret = new JSONObject();
					ret.put("resultCode", 0);
					ret.put("resultInfo", e.getMessage());
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				} catch (Exception e1) {
					e1.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			} finally {
				try {
					ConnectionFactory.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			}
			return returnValue;
		
		}
		

		/**
		 * 网格日报-商企网格重点业务日报
		 */
		public String xyrb4sqwgzdywrb(String parm) throws AppException, SysException{
			Connection conn = null;
			String returnValue = null;
			try {
				conn = ConnectionFactory.createConnection();
				conn.setAutoCommit(false);
				ZSJFDOM dom=new ZSJFDOM();
				returnValue=dom.xyrb4sqwgzdywrb(parm);
				ConnectionFactory.commit();
			} catch (Exception e) { 
				e.printStackTrace();
				log.error("[IOM系统接口svcCallIOMByMosNative异常]" + e);
				try {
					ConnectionFactory.rollback();
					JSONObject ret = new JSONObject();
					ret.put("resultCode", 0);
					ret.put("resultInfo", e.getMessage());
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				} catch (Exception e1) {
					e1.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative事务回滚异常]" + e1);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			} finally {
				try {
					ConnectionFactory.closeConnection();
				} catch (Exception e) {
					e.printStackTrace();
					log.error("[IOM系统接口svcCallIOMByMosNative数据库连接关闭异常]" + e);
					returnValue = StringUtil.getAppException4MOS(e.getMessage());
				}
			}
			return returnValue;
		
		
		}
		
}

