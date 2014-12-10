package com.cattsoft.tm.component.dao.oracleImpl;

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
import com.cattsoft.tm.component.dao.IStaffLocationSDAO;
import com.cattsoft.tm.vo.StaffLocationSVO;

/**
 * 方法StaffLocationSDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class StaffLocationSDAOImpl implements IStaffLocationSDAO {
	private static Logger log = Logger.getLogger(StaffLocationSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
		if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO STAFF_LOCATION(CREATE_TIME,LOCATION,REMARKS,STAFF_ID,STAFF_LOCATIOIN_ID,STS,STS_DATE)");
		sql
				.append(" VALUES (:createTime,:location,:remarks,:staffId,:staffLocatioinId,:sts,:stsDate)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (staffLocation.getCreateTime() == null) {
				sql.setNullDate("createTime");
			} else {
				sql.setTimestamp("createTime", staffLocation.getCreateTime());
			}

			if (StringUtil.isBlank(staffLocation.getLocation())) {
				sql.setNullString("location");
			} else {
				sql.setString("location", staffLocation.getLocation());
			}

			if (StringUtil.isBlank(staffLocation.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", staffLocation.getRemarks());
			}

			if (StringUtil.isBlank(staffLocation.getStaffId())) {
				sql.setNullString("staffId");
			} else {
				sql.setString("staffId", staffLocation.getStaffId());
			}

			if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
				sql.setNullLong("staffLocatioinId");
			} else {
				sql.setLong("staffLocatioinId", staffLocation
						.getStaffLocatioinId());
			}

			if (StringUtil.isBlank(staffLocation.getSts())) {
				sql.setNullString("sts");
			} else {
				sql.setString("sts", staffLocation.getSts());
			}

			if (staffLocation.getStsDate() == null) {
				sql.setNullDate("stsDate");
			} else {
				sql.setTimestamp("stsDate", staffLocation.getStsDate());
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
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
		if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Sql sql = new Sql(
				"SELECT CREATE_TIME,LOCATION,REMARKS,STAFF_ID,STAFF_LOCATIOIN_ID,STS,STS_DATE FROM STAFF_LOCATION WHERE 1=1  ");
		sql.append(" and STAFF_LOCATIOIN_ID=:staffLocatioinId");
		sql.setLong("staffLocatioinId", staffLocation.getStaffLocatioinId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		staffLocation = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				staffLocation = new StaffLocationSVO();
				staffLocation.setCreateTime(rs.getTimestamp("CREATE_TIME"));
				staffLocation.setLocation(rs.getString("LOCATION"));
				staffLocation.setRemarks(rs.getString("REMARKS"));
				staffLocation.setStaffId(rs.getString("STAFF_ID"));
				staffLocation.setStaffLocatioinId(rs
						.getString("STAFF_LOCATIOIN_ID"));
				staffLocation.setSts(rs.getString("STS"));
				staffLocation.setStsDate(rs.getTimestamp("STS_DATE"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return staffLocation;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT CREATE_TIME,LOCATION,REMARKS,STAFF_ID,STAFF_LOCATIOIN_ID,STS,STS_DATE FROM STAFF_LOCATION WHERE 1=1 ");
		try {
			if (staffLocation.getFlagCreateTime() == 1) {
				if (staffLocation.getCreateTime() == null) {
					sql.append(" and CREATE_TIME is null ");
				} else {
					sql.append(" and CREATE_TIME=:createTime");
					sql.setTimestamp("createTime", staffLocation
							.getCreateTime());
				}
			}

			if (staffLocation.getFlagLocation() == 1) {
				if (StringUtil.isBlank(staffLocation.getLocation())) {
					sql.append(" and LOCATION is null ");
				} else {
					sql.append(" and LOCATION=:location");
					sql.setString("location", staffLocation.getLocation());
				}
			}

			if (staffLocation.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(staffLocation.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", staffLocation.getRemarks());
				}
			}

			if (staffLocation.getFlagStaffId() == 1) {
				if (StringUtil.isBlank(staffLocation.getStaffId())) {
					sql.append(" and STAFF_ID is null ");
				} else {
					sql.append(" and STAFF_ID=:staffId");
					sql.setString("staffId", staffLocation.getStaffId());
				}
			}

			if (staffLocation.getFlagStaffLocatioinId() == 1) {
				if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
					sql.append(" and STAFF_LOCATIOIN_ID is null ");
				} else {
					sql.append(" and STAFF_LOCATIOIN_ID=:staffLocatioinId");
					sql.setLong("staffLocatioinId", staffLocation
							.getStaffLocatioinId());
				}
			}

			if (staffLocation.getFlagSts() == 1) {
				if (StringUtil.isBlank(staffLocation.getSts())) {
					sql.append(" and STS is null ");
				} else {
					sql.append(" and STS=:sts");
					sql.setString("sts", staffLocation.getSts());
				}
			}

			if (staffLocation.getFlagStsDate() == 1) {
				if (staffLocation.getStsDate() == null) {
					sql.append(" and STS_DATE is null ");
				} else {
					sql.append(" and STS_DATE=:stsDate");
					sql.setTimestamp("stsDate", staffLocation.getStsDate());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				staffLocation = new StaffLocationSVO();
				staffLocation.setCreateTime(rs.getTimestamp("CREATE_TIME"));
				staffLocation.setLocation(rs.getString("LOCATION"));
				staffLocation.setRemarks(rs.getString("REMARKS"));
				staffLocation.setStaffId(rs.getString("STAFF_ID"));
				staffLocation.setStaffLocatioinId(rs
						.getString("STAFF_LOCATIOIN_ID"));
				staffLocation.setSts(rs.getString("STS"));
				staffLocation.setStsDate(rs.getTimestamp("STS_DATE"));
				res.add(staffLocation);

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
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
		if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE STAFF_LOCATION SET ");
		try {
			if (staffLocation.getFlagCreateTime() == 1) {
				sql.append("CREATE_TIME=:createTime,");
				sql.setTimestamp("createTime", staffLocation.getCreateTime());
			}

			if (staffLocation.getFlagLocation() == 1) {
				sql.append("LOCATION=:location,");
				sql.setString("location", staffLocation.getLocation());
			}

			if (staffLocation.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", staffLocation.getRemarks());
			}

			if (staffLocation.getFlagStaffId() == 1) {
				sql.append("STAFF_ID=:staffId,");
				sql.setString("staffId", staffLocation.getStaffId());
			}

			if (staffLocation.getFlagSts() == 1) {
				sql.append("STS=:sts,");
				sql.setString("sts", staffLocation.getSts());
			}

			if (staffLocation.getFlagStsDate() == 1) {
				sql.append("STS_DATE=:stsDate,");
				sql.setTimestamp("stsDate", staffLocation.getStsDate());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			sql.append(" and STAFF_LOCATIOIN_ID=:staffLocatioinId");
			sql
					.setLong("staffLocatioinId", staffLocation
							.getStaffLocatioinId());

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
				"INSERT INTO STAFF_LOCATION(CREATE_TIME,LOCATION,REMARKS,STAFF_ID,STAFF_LOCATIOIN_ID,STS,STS_DATE)");
		sql
				.append(" VALUES (:createTime,:location,:remarks,:staffId,:staffLocatioinId,:sts,:stsDate)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				StaffLocationSVO staffLocation = (StaffLocationSVO) list.get(i);
				if (staffLocation == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
					throw new AppException("100002", "缺少对象的主键！");
				}
				if (staffLocation.getCreateTime() == null) {
					sql.setNullDate("createTime");
				} else {
					sql.setTimestamp("createTime", staffLocation
							.getCreateTime());
				}

				if (StringUtil.isBlank(staffLocation.getLocation())) {
					sql.setNullString("location");
				} else {
					sql.setString("location", staffLocation.getLocation());
				}

				if (StringUtil.isBlank(staffLocation.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", staffLocation.getRemarks());
				}

				if (StringUtil.isBlank(staffLocation.getStaffId())) {
					sql.setNullString("staffId");
				} else {
					sql.setString("staffId", staffLocation.getStaffId());
				}

				if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
					sql.setNullLong("staffLocatioinId");
				} else {
					sql.setLong("staffLocatioinId", staffLocation
							.getStaffLocatioinId());
				}

				if (StringUtil.isBlank(staffLocation.getSts())) {
					sql.setNullString("sts");
				} else {
					sql.setString("sts", staffLocation.getSts());
				}

				if (staffLocation.getStsDate() == null) {
					sql.setNullDate("stsDate");
				} else {
					sql.setTimestamp("stsDate", staffLocation.getStsDate());
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
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
		if (StringUtil.isBlank(staffLocation.getStaffLocatioinId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM STAFF_LOCATION WHERE 1=1  ");
		sql.append(" and STAFF_LOCATIOIN_ID=:staffLocatioinId");
		sql.setLong("staffLocatioinId", staffLocation.getStaffLocatioinId());

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
		StaffLocationSVO staffLocation = (StaffLocationSVO) vo;
	}
}
