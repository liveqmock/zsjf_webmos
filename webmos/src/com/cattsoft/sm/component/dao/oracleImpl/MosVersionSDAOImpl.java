package com.cattsoft.sm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.component.dao.IMosVersionSDAO;
import com.cattsoft.tm.vo.MosVersionSVO;

/**
 * 方法MosVersionSDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class MosVersionSDAOImpl implements IMosVersionSDAO {
	private static Logger log = Logger.getLogger(MosVersionSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosVersionSVO mosVersion = (MosVersionSVO) vo;

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_VERSION(IS_FORCE,PUBLISH_DATE,PUBLISH_PATH,REMARKS,VERSION_DESC,VERSION_ID,VERSION_NUM)");
		sql
				.append(" VALUES (:isForce,:publishDate,:publishPath,:remarks,:versionDesc,:versionId,:versionNum)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (StringUtil.isBlank(mosVersion.getIsForce())) {
				sql.setNullString("isForce");
			} else {
				sql.setString("isForce", mosVersion.getIsForce());
			}

			if (mosVersion.getPublishDate() == null) {
				sql.setNullDate("publishDate");
			} else {
				sql.setTimestamp("publishDate", mosVersion.getPublishDate());
			}

			if (StringUtil.isBlank(mosVersion.getPublishPath())) {
				sql.setNullString("publishPath");
			} else {
				sql.setString("publishPath", mosVersion.getPublishPath());
			}

			if (StringUtil.isBlank(mosVersion.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", mosVersion.getRemarks());
			}

			if (StringUtil.isBlank(mosVersion.getVersionDesc())) {
				sql.setNullString("versionDesc");
			} else {
				sql.setString("versionDesc", mosVersion.getVersionDesc());
			}

			if (StringUtil.isBlank(mosVersion.getVersionId())) {
				sql.setNullLong("versionId");
			} else {
				sql.setLong("versionId", mosVersion.getVersionId());
			}

			if (StringUtil.isBlank(mosVersion.getVersionNum())) {
				sql.setNullLong("versionNum");
			} else {
				sql.setLong("versionNum", mosVersion.getVersionNum());
			}

			sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * 主键查询的SQL。
	 * @return String ： 主键查询的SQL。
	 */
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosVersionSVO mosVersion = (MosVersionSVO) vo;

		Sql sql = new Sql(
				"SELECT IS_FORCE,PUBLISH_DATE,PUBLISH_PATH,REMARKS,VERSION_DESC,VERSION_ID,VERSION_NUM FROM MOS_VERSION WHERE 1=1  ");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mosVersion = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosVersion = new MosVersionSVO();
				mosVersion.setIsForce(rs.getString("IS_FORCE"));
				mosVersion.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));
				mosVersion.setPublishPath(rs.getString("PUBLISH_PATH"));
				mosVersion.setRemarks(rs.getString("REMARKS"));
				mosVersion.setVersionDesc(rs.getString("VERSION_DESC"));
				mosVersion.setVersionId(rs.getString("VERSION_ID"));
				mosVersion.setVersionNum(rs.getString("VERSION_NUM"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return mosVersion;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosVersionSVO mosVersion = (MosVersionSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT IS_FORCE,PUBLISH_DATE,PUBLISH_PATH,REMARKS,VERSION_DESC,VERSION_ID,VERSION_NUM FROM MOS_VERSION WHERE 1=1 ");
		try {
			if (mosVersion.getFlagIsForce() == 1) {
				if (StringUtil.isBlank(mosVersion.getIsForce())) {
					sql.append(" and IS_FORCE is null ");
				} else {
					sql.append(" and IS_FORCE=:isForce");
					sql.setString("isForce", mosVersion.getIsForce());
				}
			}

			if (mosVersion.getFlagPublishDate() == 1) {
				if (mosVersion.getPublishDate() == null) {
					sql.append(" and PUBLISH_DATE is null ");
				} else {
					sql.append(" and PUBLISH_DATE=:publishDate");
					sql
							.setTimestamp("publishDate", mosVersion
									.getPublishDate());
				}
			}

			if (mosVersion.getFlagPublishPath() == 1) {
				if (StringUtil.isBlank(mosVersion.getPublishPath())) {
					sql.append(" and PUBLISH_PATH is null ");
				} else {
					sql.append(" and PUBLISH_PATH=:publishPath");
					sql.setString("publishPath", mosVersion.getPublishPath());
				}
			}

			if (mosVersion.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(mosVersion.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", mosVersion.getRemarks());
				}
			}

			if (mosVersion.getFlagVersionDesc() == 1) {
				if (StringUtil.isBlank(mosVersion.getVersionDesc())) {
					sql.append(" and VERSION_DESC is null ");
				} else {
					sql.append(" and VERSION_DESC=:versionDesc");
					sql.setString("versionDesc", mosVersion.getVersionDesc());
				}
			}

			if (mosVersion.getFlagVersionId() == 1) {
				if (StringUtil.isBlank(mosVersion.getVersionId())) {
					sql.append(" and VERSION_ID is null ");
				} else {
					sql.append(" and VERSION_ID=:versionId");
					sql.setLong("versionId", mosVersion.getVersionId());
				}
			}

			if (mosVersion.getFlagVersionNum() == 1) {
				if (StringUtil.isBlank(mosVersion.getVersionNum())) {
					sql.append(" and VERSION_NUM is null ");
				} else {
					sql.append(" and VERSION_NUM=:versionNum");
					sql.setLong("versionNum", mosVersion.getVersionNum());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosVersion = new MosVersionSVO();
				mosVersion.setIsForce(rs.getString("IS_FORCE"));
				mosVersion.setPublishDate(rs.getTimestamp("PUBLISH_DATE"));
				mosVersion.setPublishPath(rs.getString("PUBLISH_PATH"));
				mosVersion.setRemarks(rs.getString("REMARKS"));
				mosVersion.setVersionDesc(rs.getString("VERSION_DESC"));
				mosVersion.setVersionId(rs.getString("VERSION_ID"));
				mosVersion.setVersionNum(rs.getString("VERSION_NUM"));
				res.add(mosVersion);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}

	/**
	 * 更新的SQL。
	 * @return String ： 更新的SQL。
	 */
	public void update(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosVersionSVO mosVersion = (MosVersionSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MOS_VERSION SET ");
		try {
			if (mosVersion.getFlagIsForce() == 1) {
				sql.append("IS_FORCE=:isForce,");
				sql.setString("isForce", mosVersion.getIsForce());
			}

			if (mosVersion.getFlagPublishDate() == 1) {
				sql.append("PUBLISH_DATE=:publishDate,");
				sql.setTimestamp("publishDate", mosVersion.getPublishDate());
			}

			if (mosVersion.getFlagPublishPath() == 1) {
				sql.append("PUBLISH_PATH=:publishPath,");
				sql.setString("publishPath", mosVersion.getPublishPath());
			}

			if (mosVersion.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", mosVersion.getRemarks());
			}

			if (mosVersion.getFlagVersionDesc() == 1) {
				sql.append("VERSION_DESC=:versionDesc,");
				sql.setString("versionDesc", mosVersion.getVersionDesc());
			}

			if (mosVersion.getFlagVersionId() == 1) {
				sql.append("VERSION_ID=:versionId,");
				sql.setLong("versionId", mosVersion.getVersionId());
			}

			if (mosVersion.getFlagVersionNum() == 1) {
				sql.append("VERSION_NUM=:versionNum,");
				sql.setLong("versionNum", mosVersion.getVersionNum());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeQuery();

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(ps);
		}

	}

	/**
	 * 批量增加记录。
	 * @return String ： 批量增加的SQL。
	 */
	public void addBat(List list) throws AppException, SysException {
		if (list == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_VERSION(IS_FORCE,PUBLISH_DATE,PUBLISH_PATH,REMARKS,VERSION_DESC,VERSION_ID,VERSION_NUM)");
		sql
				.append(" VALUES (:isForce,:publishDate,:publishPath,:remarks,:versionDesc,:versionId,:versionNum)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MosVersionSVO mosVersion = (MosVersionSVO) list.get(i);
				if (mosVersion == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(mosVersion.getIsForce())) {
					sql.setNullString("isForce");
				} else {
					sql.setString("isForce", mosVersion.getIsForce());
				}

				if (mosVersion.getPublishDate() == null) {
					sql.setNullDate("publishDate");
				} else {
					sql
							.setTimestamp("publishDate", mosVersion
									.getPublishDate());
				}

				if (StringUtil.isBlank(mosVersion.getPublishPath())) {
					sql.setNullString("publishPath");
				} else {
					sql.setString("publishPath", mosVersion.getPublishPath());
				}

				if (StringUtil.isBlank(mosVersion.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", mosVersion.getRemarks());
				}

				if (StringUtil.isBlank(mosVersion.getVersionDesc())) {
					sql.setNullString("versionDesc");
				} else {
					sql.setString("versionDesc", mosVersion.getVersionDesc());
				}

				if (StringUtil.isBlank(mosVersion.getVersionId())) {
					sql.setNullLong("versionId");
				} else {
					sql.setLong("versionId", mosVersion.getVersionId());
				}

				if (StringUtil.isBlank(mosVersion.getVersionNum())) {
					sql.setNullLong("versionNum");
				} else {
					sql.setLong("versionNum", mosVersion.getVersionNum());
				}

				sql.fillParams(ps);
				sql.log(this.getClass());
				sql.clearParameters();
				ps.addBatch();
			}

			ps.executeBatch();
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * 根据传入参数删除一条或者一批记录。
	 * @return String ： 删除的SQL。
	 */
	public void delete(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosVersionSVO mosVersion = (MosVersionSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MOS_VERSION WHERE 1=1  ");

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * 注销一条或者一批
	 * @return String ： 注销一条或者一批的SQL。
	 */
	public void unable(GenericVO vo) throws AppException, SysException {
		MosVersionSVO mosVersion = (MosVersionSVO) vo;
	}
}
