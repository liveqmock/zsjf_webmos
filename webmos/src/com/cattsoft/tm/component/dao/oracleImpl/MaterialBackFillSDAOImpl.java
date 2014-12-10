package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.cattsoft.tm.component.dao.IMaterialBackFillSDAO;
import com.cattsoft.tm.vo.MaterialBackFillSVO;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;

/**
 * 方法MaterialBackFillSDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class MaterialBackFillSDAOImpl implements IMaterialBackFillSDAO {
	private static Logger log = Logger
			.getLogger(MaterialBackFillSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MATERIAL_BACK_FILL(AMOUNT,AREA_ID,BACK_FILL_TYPE,LOCAL_NET_ID,MATERIAL_ID,MATERIAL_SPEC_ID,REMARKS,STAFF_ID,STS,STS_DATE,WO_NBR)");
		sql
				.append(" VALUES (:amount,:areaId,:backFillType,:localNetId,:materialId,:materialSpecId,:remarks,:staffId,:sts,:stsDate,:woNbr)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (StringUtil.isBlank(materialBackFill.getAmount())) {
				sql.setNullLong("amount");
			} else {
				sql.setLong("amount", materialBackFill.getAmount());
			}

			if (StringUtil.isBlank(materialBackFill.getAreaId())) {
				sql.setNullLong("areaId");
			} else {
				sql.setLong("areaId", materialBackFill.getAreaId());
			}

			if (StringUtil.isBlank(materialBackFill.getBackFillType())) {
				sql.setNullString("backFillType");
			} else {
				sql.setString("backFillType", materialBackFill
						.getBackFillType());
			}

			if (StringUtil.isBlank(materialBackFill.getLocalNetId())) {
				sql.setNullLong("localNetId");
			} else {
				sql.setLong("localNetId", materialBackFill.getLocalNetId());
			}

			if (StringUtil.isBlank(materialBackFill.getMaterialId())) {
				sql.setNullLong("materialId");
			} else {
				sql.setLong("materialId", materialBackFill.getMaterialId());
			}

			if (StringUtil.isBlank(materialBackFill.getMaterialSpecId())) {
				sql.setNullLong("materialSpecId");
			} else {
				sql.setLong("materialSpecId", materialBackFill
						.getMaterialSpecId());
			}

			if (StringUtil.isBlank(materialBackFill.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", materialBackFill.getRemarks());
			}

			if (StringUtil.isBlank(materialBackFill.getStaffId())) {
				sql.setNullString("staffId");
			} else {
				sql.setString("staffId", materialBackFill.getStaffId());
			}

			if (StringUtil.isBlank(materialBackFill.getSts())) {
				sql.setNullString("sts");
			} else {
				sql.setString("sts", materialBackFill.getSts());
			}

			if (materialBackFill.getStsDate() == null) {
				sql.setNullDate("stsDate");
			} else {
				sql.setTimestamp("stsDate", materialBackFill.getStsDate());
			}

			if (StringUtil.isBlank(materialBackFill.getWoNbr())) {
				sql.setNullString("woNbr");
			} else {
				sql.setString("woNbr", materialBackFill.getWoNbr());
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
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;

		Sql sql = new Sql(
				"SELECT AMOUNT,AREA_ID,BACK_FILL_TYPE,LOCAL_NET_ID,MATERIAL_ID,MATERIAL_SPEC_ID,REMARKS,STAFF_ID,STS,STS_DATE,WO_NBR FROM MATERIAL_BACK_FILL WHERE 1=1  ");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		materialBackFill = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				materialBackFill = new MaterialBackFillSVO();
				materialBackFill.setAmount(rs.getString("AMOUNT"));
				materialBackFill.setAreaId(rs.getString("AREA_ID"));
				materialBackFill
						.setBackFillType(rs.getString("BACK_FILL_TYPE"));
				materialBackFill.setLocalNetId(rs.getString("LOCAL_NET_ID"));
				materialBackFill.setMaterialId(rs.getString("MATERIAL_ID"));
				materialBackFill.setMaterialSpecId(rs
						.getString("MATERIAL_SPEC_ID"));
				materialBackFill.setRemarks(rs.getString("REMARKS"));
				materialBackFill.setStaffId(rs.getString("STAFF_ID"));
				materialBackFill.setSts(rs.getString("STS"));
				materialBackFill.setStsDate(rs.getTimestamp("STS_DATE"));
				materialBackFill.setWoNbr(rs.getString("WO_NBR"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return materialBackFill;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT AMOUNT,AREA_ID,BACK_FILL_TYPE,LOCAL_NET_ID,MATERIAL_ID,MATERIAL_SPEC_ID,REMARKS,STAFF_ID,STS,STS_DATE,WO_NBR FROM MATERIAL_BACK_FILL WHERE 1=1 ");
		try {
			if (materialBackFill.getFlagAmount() == 1) {
				if (StringUtil.isBlank(materialBackFill.getAmount())) {
					sql.append(" and AMOUNT is null ");
				} else {
					sql.append(" and AMOUNT=:amount");
					sql.setLong("amount", materialBackFill.getAmount());
				}
			}

			if (materialBackFill.getFlagAreaId() == 1) {
				if (StringUtil.isBlank(materialBackFill.getAreaId())) {
					sql.append(" and AREA_ID is null ");
				} else {
					sql.append(" and AREA_ID=:areaId");
					sql.setLong("areaId", materialBackFill.getAreaId());
				}
			}

			if (materialBackFill.getFlagBackFillType() == 1) {
				if (StringUtil.isBlank(materialBackFill.getBackFillType())) {
					sql.append(" and BACK_FILL_TYPE is null ");
				} else {
					sql.append(" and BACK_FILL_TYPE=:backFillType");
					sql.setString("backFillType", materialBackFill
							.getBackFillType());
				}
			}

			if (materialBackFill.getFlagLocalNetId() == 1) {
				if (StringUtil.isBlank(materialBackFill.getLocalNetId())) {
					sql.append(" and LOCAL_NET_ID is null ");
				} else {
					sql.append(" and LOCAL_NET_ID=:localNetId");
					sql.setLong("localNetId", materialBackFill.getLocalNetId());
				}
			}

			if (materialBackFill.getFlagMaterialId() == 1) {
				if (StringUtil.isBlank(materialBackFill.getMaterialId())) {
					sql.append(" and MATERIAL_ID is null ");
				} else {
					sql.append(" and MATERIAL_ID=:materialId");
					sql.setLong("materialId", materialBackFill.getMaterialId());
				}
			}

			if (materialBackFill.getFlagMaterialSpecId() == 1) {
				if (StringUtil.isBlank(materialBackFill.getMaterialSpecId())) {
					sql.append(" and MATERIAL_SPEC_ID is null ");
				} else {
					sql.append(" and MATERIAL_SPEC_ID=:materialSpecId");
					sql.setLong("materialSpecId", materialBackFill
							.getMaterialSpecId());
				}
			}

			if (materialBackFill.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(materialBackFill.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", materialBackFill.getRemarks());
				}
			}

			if (materialBackFill.getFlagStaffId() == 1) {
				if (StringUtil.isBlank(materialBackFill.getStaffId())) {
					sql.append(" and STAFF_ID is null ");
				} else {
					sql.append(" and STAFF_ID=:staffId");
					sql.setString("staffId", materialBackFill.getStaffId());
				}
			}

			if (materialBackFill.getFlagSts() == 1) {
				if (StringUtil.isBlank(materialBackFill.getSts())) {
					sql.append(" and STS is null ");
				} else {
					sql.append(" and STS=:sts");
					sql.setString("sts", materialBackFill.getSts());
				}
			}

			if (materialBackFill.getFlagStsDate() == 1) {
				if (materialBackFill.getStsDate() == null) {
					sql.append(" and STS_DATE is null ");
				} else {
					sql.append(" and STS_DATE=:stsDate");
					sql.setTimestamp("stsDate", materialBackFill.getStsDate());
				}
			}

			if (materialBackFill.getFlagWoNbr() == 1) {
				if (StringUtil.isBlank(materialBackFill.getWoNbr())) {
					sql.append(" and WO_NBR is null ");
				} else {
					sql.append(" and WO_NBR=:woNbr");
					sql.setString("woNbr", materialBackFill.getWoNbr());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				materialBackFill = new MaterialBackFillSVO();
				materialBackFill.setAmount(rs.getString("AMOUNT"));
				materialBackFill.setAreaId(rs.getString("AREA_ID"));
				materialBackFill
						.setBackFillType(rs.getString("BACK_FILL_TYPE"));
				materialBackFill.setLocalNetId(rs.getString("LOCAL_NET_ID"));
				materialBackFill.setMaterialId(rs.getString("MATERIAL_ID"));
				materialBackFill.setMaterialSpecId(rs
						.getString("MATERIAL_SPEC_ID"));
				materialBackFill.setRemarks(rs.getString("REMARKS"));
				materialBackFill.setStaffId(rs.getString("STAFF_ID"));
				materialBackFill.setSts(rs.getString("STS"));
				materialBackFill.setStsDate(rs.getTimestamp("STS_DATE"));
				materialBackFill.setWoNbr(rs.getString("WO_NBR"));
				res.add(materialBackFill);

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
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MATERIAL_BACK_FILL SET ");
		try {
			if (materialBackFill.getFlagAmount() == 1) {
				sql.append("AMOUNT=:amount,");
				sql.setLong("amount", materialBackFill.getAmount());
			}

			if (materialBackFill.getFlagAreaId() == 1) {
				sql.append("AREA_ID=:areaId,");
				sql.setLong("areaId", materialBackFill.getAreaId());
			}

			if (materialBackFill.getFlagBackFillType() == 1) {
				sql.append("BACK_FILL_TYPE=:backFillType,");
				sql.setString("backFillType", materialBackFill
						.getBackFillType());
			}

			if (materialBackFill.getFlagLocalNetId() == 1) {
				sql.append("LOCAL_NET_ID=:localNetId,");
				sql.setLong("localNetId", materialBackFill.getLocalNetId());
			}

			if (materialBackFill.getFlagMaterialId() == 1) {
				sql.append("MATERIAL_ID=:materialId,");
				sql.setLong("materialId", materialBackFill.getMaterialId());
			}

			if (materialBackFill.getFlagMaterialSpecId() == 1) {
				sql.append("MATERIAL_SPEC_ID=:materialSpecId,");
				sql.setLong("materialSpecId", materialBackFill
						.getMaterialSpecId());
			}

			if (materialBackFill.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", materialBackFill.getRemarks());
			}

			if (materialBackFill.getFlagStaffId() == 1) {
				sql.append("STAFF_ID=:staffId,");
				sql.setString("staffId", materialBackFill.getStaffId());
			}

			if (materialBackFill.getFlagSts() == 1) {
				sql.append("STS=:sts,");
				sql.setString("sts", materialBackFill.getSts());
			}

			if (materialBackFill.getFlagStsDate() == 1) {
				sql.append("STS_DATE=:stsDate,");
				sql.setTimestamp("stsDate", materialBackFill.getStsDate());
			}

			if (materialBackFill.getFlagWoNbr() == 1) {
				sql.append("WO_NBR=:woNbr,");
				sql.setString("woNbr", materialBackFill.getWoNbr());
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
				"INSERT INTO MATERIAL_BACK_FILL(AMOUNT,AREA_ID,BACK_FILL_TYPE,LOCAL_NET_ID,MATERIAL_ID,MATERIAL_SPEC_ID,REMARKS,STAFF_ID,STS,STS_DATE,WO_NBR)");
		sql
				.append(" VALUES (:amount,:areaId,:backFillType,:localNetId,:materialId,:materialSpecId,:remarks,:staffId,:sts,:stsDate,:woNbr)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) list
						.get(i);
				if (materialBackFill == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(materialBackFill.getAmount())) {
					sql.setNullLong("amount");
				} else {
					sql.setLong("amount", materialBackFill.getAmount());
				}

				if (StringUtil.isBlank(materialBackFill.getAreaId())) {
					sql.setNullLong("areaId");
				} else {
					sql.setLong("areaId", materialBackFill.getAreaId());
				}

				if (StringUtil.isBlank(materialBackFill.getBackFillType())) {
					sql.setNullString("backFillType");
				} else {
					sql.setString("backFillType", materialBackFill
							.getBackFillType());
				}

				if (StringUtil.isBlank(materialBackFill.getLocalNetId())) {
					sql.setNullLong("localNetId");
				} else {
					sql.setLong("localNetId", materialBackFill.getLocalNetId());
				}

				if (StringUtil.isBlank(materialBackFill.getMaterialId())) {
					sql.setNullLong("materialId");
				} else {
					sql.setLong("materialId", materialBackFill.getMaterialId());
				}

				if (StringUtil.isBlank(materialBackFill.getMaterialSpecId())) {
					sql.setNullLong("materialSpecId");
				} else {
					sql.setLong("materialSpecId", materialBackFill
							.getMaterialSpecId());
				}

				if (StringUtil.isBlank(materialBackFill.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", materialBackFill.getRemarks());
				}

				if (StringUtil.isBlank(materialBackFill.getStaffId())) {
					sql.setNullString("staffId");
				} else {
					sql.setString("staffId", materialBackFill.getStaffId());
				}

				if (StringUtil.isBlank(materialBackFill.getSts())) {
					sql.setNullString("sts");
				} else {
					sql.setString("sts", materialBackFill.getSts());
				}

				if (materialBackFill.getStsDate() == null) {
					sql.setNullDate("stsDate");
				} else {
					sql.setTimestamp("stsDate", materialBackFill.getStsDate());
				}

				if (StringUtil.isBlank(materialBackFill.getWoNbr())) {
					sql.setNullString("woNbr");
				} else {
					sql.setString("woNbr", materialBackFill.getWoNbr());
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
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MATERIAL_BACK_FILL WHERE 1=1  ");
		sql.append(" and WO_NBR=:woNbr");
		sql.setLong("woNbr", materialBackFill.getWoNbr());
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
		MaterialBackFillSVO materialBackFill = (MaterialBackFillSVO) vo;
	}
}
