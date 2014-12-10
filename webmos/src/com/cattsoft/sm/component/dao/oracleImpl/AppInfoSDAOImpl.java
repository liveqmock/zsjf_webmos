package com.cattsoft.sm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.List;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.util.CollectionFactory;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.util.StringUtil;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.sm.component.dao.IAppInfoSDAO;import com.cattsoft.sm.vo.AppInfoSVO;/** * 方法AppInfoSDAOImpl * <p> * Company: 大唐软件 * </p> *  * @author ：白小亮。 * @version 1.1 2007-9-23 */public class AppInfoSDAOImpl implements IAppInfoSDAO {	// private static Logger log = Logger.getLogger(AppInfoSDAOImpl.class);	// private static final String UNABLE_STS = "P";	/**	 * 增加。	 * 	 * @return String	 */	public void add(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		AppInfoSVO appInfo = (AppInfoSVO) vo;		if (StringUtil.isBlank(appInfo.getAppInfoId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql(				"INSERT INTO APP_INFO(APP_ID,APP_INFO_ID,APP_NAME,STS,STS_DATE,URL)");		sql.append(" VALUES (:appId,:appInfoId,:appName,:sts,:stsDate,:url)");		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			if (StringUtil.isBlank(appInfo.getAppId())) {				sql.setNullString("appId");			} else {				sql.setString("appId", appInfo.getAppId());			}			if (StringUtil.isBlank(appInfo.getAppInfoId())) {				sql.setNullLong("appInfoId");			} else {				sql.setLong("appInfoId", appInfo.getAppInfoId());			}			if (StringUtil.isBlank(appInfo.getAppName())) {				sql.setNullString("appName");			} else {				sql.setString("appName", appInfo.getAppName());			}			if (StringUtil.isBlank(appInfo.getSts())) {				sql.setNullString("sts");			} else {				sql.setString("sts", appInfo.getSts());			}			if (appInfo.getStsDate() == null) {				sql.setNullDate("stsDate");			} else {				sql.setTimestamp("stsDate", appInfo.getStsDate());			}			if (StringUtil.isBlank(appInfo.getUrl())) {				sql.setNullString("url");			} else {				sql.setString("url", appInfo.getUrl());			}			sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 主键查询的SQL。	 * 	 * @return String ： 主键查询的SQL。	 */	public GenericVO findByPK(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		AppInfoSVO appInfo = (AppInfoSVO) vo;		if (StringUtil.isBlank(appInfo.getAppInfoId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Sql sql = new Sql(				"SELECT APP_ID,APP_INFO_ID,APP_NAME,STS,STS_DATE,URL FROM APP_INFO WHERE 1=1  ");		sql.append(" and APP_INFO_ID=:appInfoId");		sql.setLong("appInfoId", appInfo.getAppInfoId());		Connection conn = null;		PreparedStatement ps = null;		ResultSet rs = null;		appInfo = null;		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			sql.fillParams(ps);			sql.log(this.getClass());			rs = ps.executeQuery();			while (rs.next()) {				appInfo = new AppInfoSVO();				appInfo.setAppId(rs.getString("APP_ID"));				appInfo.setAppInfoId(rs.getString("APP_INFO_ID"));				appInfo.setAppName(rs.getString("APP_NAME"));				appInfo.setSts(rs.getString("STS"));				appInfo.setStsDate(rs.getTimestamp("STS_DATE"));				appInfo.setUrl(rs.getString("URL"));			}		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(rs, ps);		}		return appInfo;	}	/**	 * 批量查询的SQL。	 * 	 * @return String ： 批量查询的SQL。	 */	public List findByVO(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		AppInfoSVO appInfo = (AppInfoSVO) vo;		List res = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);		Connection conn = null;		PreparedStatement ps = null;		ResultSet rs = null;		Sql sql = new Sql(				"SELECT APP_ID,APP_INFO_ID,APP_NAME,STS,STS_DATE,URL FROM APP_INFO WHERE 1=1 ");		try {			if (appInfo.getFlagAppId() == 1) {				if (StringUtil.isBlank(appInfo.getAppId())) {					sql.append(" and APP_ID is null ");				} else {					sql.append(" and APP_ID=:appId");					sql.setString("appId", appInfo.getAppId());				}			}			if (appInfo.getFlagAppInfoId() == 1) {				if (StringUtil.isBlank(appInfo.getAppInfoId())) {					sql.append(" and APP_INFO_ID is null ");				} else {					sql.append(" and APP_INFO_ID=:appInfoId");					sql.setLong("appInfoId", appInfo.getAppInfoId());				}			}			if (appInfo.getFlagAppName() == 1) {				if (StringUtil.isBlank(appInfo.getAppName())) {					sql.append(" and APP_NAME is null ");				} else {					sql.append(" and APP_NAME=:appName");					sql.setString("appName", appInfo.getAppName());				}			}			if (appInfo.getFlagSts() == 1) {				if (StringUtil.isBlank(appInfo.getSts())) {					sql.append(" and STS is null ");				} else {					sql.append(" and STS=:sts");					sql.setString("sts", appInfo.getSts());				}			}			if (appInfo.getFlagStsDate() == 1) {				if (appInfo.getStsDate() == null) {					sql.append(" and STS_DATE is null ");				} else {					sql.append(" and STS_DATE=:stsDate");					sql.setTimestamp("stsDate", appInfo.getStsDate());				}			}			if (appInfo.getFlagUrl() == 1) {				if (StringUtil.isBlank(appInfo.getUrl())) {					sql.append(" and URL is null ");				} else {					sql.append(" and URL=:url");					sql.setString("url", appInfo.getUrl());				}			}			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			ps = sql.fillParams(ps);			sql.log(this.getClass());			rs = ps.executeQuery();			while (rs.next()) {				appInfo = new AppInfoSVO();				appInfo.setAppId(rs.getString("APP_ID"));				appInfo.setAppInfoId(rs.getString("APP_INFO_ID"));				appInfo.setAppName(rs.getString("APP_NAME"));				appInfo.setSts(rs.getString("STS"));				appInfo.setStsDate(rs.getTimestamp("STS_DATE"));				appInfo.setUrl(rs.getString("URL"));				res.add(appInfo);			}		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(rs, ps);		}		if (0 == res.size())			res = null;		return res;	}	/**	 * 更新的SQL。	 * 	 * @return String ： 更新的SQL。	 */	public void update(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		AppInfoSVO appInfo = (AppInfoSVO) vo;		if (StringUtil.isBlank(appInfo.getAppInfoId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql("UPDATE APP_INFO SET ");		try {			if (appInfo.getFlagAppId() == 1) {				sql.append("APP_ID=:appId,");				sql.setString("appId", appInfo.getAppId());			}			if (appInfo.getFlagAppName() == 1) {				sql.append("APP_NAME=:appName,");				sql.setString("appName", appInfo.getAppName());			}			if (appInfo.getFlagSts() == 1) {				sql.append("STS=:sts,");				sql.setString("sts", appInfo.getSts());			}			if (appInfo.getFlagStsDate() == 1) {				sql.append("STS_DATE=:stsDate,");				sql.setTimestamp("stsDate", appInfo.getStsDate());			}			if (appInfo.getFlagUrl() == 1) {				sql.append("URL=:url,");				sql.setString("url", appInfo.getUrl());			}			sql.removeSuffix(1);			sql.append(" WHERE 1=1 ");			sql.append(" and APP_INFO_ID=:appInfoId");			sql.setLong("appInfoId", appInfo.getAppInfoId());			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			ps = sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 批量增加记录。	 * 	 * @return String ： 批量增加的SQL。	 */	public void addBat(List list) throws AppException, SysException {		if (list == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql(				"INSERT INTO APP_INFO(APP_ID,APP_INFO_ID,APP_NAME,STS,STS_DATE,URL)");		sql.append(" VALUES (:appId,:appInfoId,:appName,:sts,:stsDate,:url)");		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			for (int i = 0; i < list.size(); i++) {				AppInfoSVO appInfo = (AppInfoSVO) list.get(i);				if (appInfo == null) {					throw new AppException("100001", "缺少DAO操作对象！");				}				if (StringUtil.isBlank(appInfo.getAppInfoId())) {					throw new AppException("100002", "缺少对象的主键！");				}				if (StringUtil.isBlank(appInfo.getAppId())) {					sql.setNullString("appId");				} else {					sql.setString("appId", appInfo.getAppId());				}				if (StringUtil.isBlank(appInfo.getAppInfoId())) {					sql.setNullLong("appInfoId");				} else {					sql.setLong("appInfoId", appInfo.getAppInfoId());				}				if (StringUtil.isBlank(appInfo.getAppName())) {					sql.setNullString("appName");				} else {					sql.setString("appName", appInfo.getAppName());				}				if (StringUtil.isBlank(appInfo.getSts())) {					sql.setNullString("sts");				} else {					sql.setString("sts", appInfo.getSts());				}				if (appInfo.getStsDate() == null) {					sql.setNullDate("stsDate");				} else {					sql.setTimestamp("stsDate", appInfo.getStsDate());				}				if (StringUtil.isBlank(appInfo.getUrl())) {					sql.setNullString("url");				} else {					sql.setString("url", appInfo.getUrl());				}				sql.fillParams(ps);				sql.log(this.getClass());				sql.clearParameters();				ps.addBatch();			}			ps.executeBatch();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 根据传入参数删除一条或者一批记录。	 * 	 * @return String ： 删除的SQL。	 */	public void delete(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		AppInfoSVO appInfo = (AppInfoSVO) vo;		if (StringUtil.isBlank(appInfo.getAppInfoId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql("DELETE FROM APP_INFO WHERE 1=1  ");		sql.append(" and APP_INFO_ID=:appInfoId");		sql.setLong("appInfoId", appInfo.getAppInfoId());		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 注销一条或者一批	 * 	 * @return String ： 注销一条或者一批的SQL。	 */	public void unable(GenericVO vo) throws AppException, SysException {		// AppInfoSVO appInfo=(AppInfoSVO) vo;	}}