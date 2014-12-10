package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.cattsoft.tm.component.dao.IMaterialSpecSDAO;
import com.cattsoft.tm.vo.MaterialSpecSVO;
import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;

/**
 * 方法MaterialSpecSDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class MaterialSpecSDAOImpl implements IMaterialSpecSDAO {
	private static Logger log = Logger.getLogger(MaterialSpecSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
		if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MATERIAL_SPEC(BRAND,CAPACITY,MANAGE_PATTERN,MATERIAL_CODE,MATERIAL_MODEL,MATERIAL_SPEC_ID,MATERIAL_TYPE,METERIAL_SN_CODE,NAME,NEED_FLAG,REMARKS,STS,STS_DATE,UNIT_ID,USED_UNIT_ID)");
		sql
				.append(" VALUES (:brand,:capacity,:managePattern,:materialCode,:materialModel,:materialSpecId,:materialType,:meterialSnCode,:name,:needFlag,:remarks,:sts,:stsDate,:unitId,:usedUnitId)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (StringUtil.isBlank(materialSpec.getBrand())) {
				sql.setNullString("brand");
			} else {
				sql.setString("brand", materialSpec.getBrand());
			}

			if (StringUtil.isBlank(materialSpec.getCapacity())) {
				sql.setNullLong("capacity");
			} else {
				sql.setLong("capacity", materialSpec.getCapacity());
			}

			if (StringUtil.isBlank(materialSpec.getManagePattern())) {
				sql.setString("managePattern", "S");
			} else {
				sql.setString("managePattern", materialSpec.getManagePattern());
			}

			if (StringUtil.isBlank(materialSpec.getMaterialCode())) {
				sql.setNullString("materialCode");
			} else {
				sql.setString("materialCode", materialSpec.getMaterialCode());
			}

			if (StringUtil.isBlank(materialSpec.getMaterialModel())) {
				sql.setNullString("materialModel");
			} else {
				sql.setString("materialModel", materialSpec.getMaterialModel());
			}

			if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
				sql.setNullLong("materialSpecId");
			} else {
				sql.setLong("materialSpecId", materialSpec.getMaterialSpecId());
			}

			if (StringUtil.isBlank(materialSpec.getMaterialType())) {
				sql.setNullString("materialType");
			} else {
				sql.setString("materialType", materialSpec.getMaterialType());
			}

			if (StringUtil.isBlank(materialSpec.getMeterialSnCode())) {
				sql.setNullString("meterialSnCode");
			} else {
				sql.setString("meterialSnCode", materialSpec
						.getMeterialSnCode());
			}

			if (StringUtil.isBlank(materialSpec.getName())) {
				sql.setNullString("name");
			} else {
				sql.setString("name", materialSpec.getName());
			}

			if (StringUtil.isBlank(materialSpec.getNeedFlag())) {
				sql.setString("needFlag", "N");
			} else {
				sql.setString("needFlag", materialSpec.getNeedFlag());
			}

			if (StringUtil.isBlank(materialSpec.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", materialSpec.getRemarks());
			}

			if (StringUtil.isBlank(materialSpec.getSts())) {
				sql.setString("sts", "A");
			} else {
				sql.setString("sts", materialSpec.getSts());
			}

			if (materialSpec.getStsDate() == null) {
				sql.setNullDate("stsDate");
			} else {
				sql.setTimestamp("stsDate", materialSpec.getStsDate());
			}

			if (StringUtil.isBlank(materialSpec.getUnitId())) {
				sql.setNullString("unitId");
			} else {
				sql.setString("unitId", materialSpec.getUnitId());
			}

			if (StringUtil.isBlank(materialSpec.getUsedUnitId())) {
				sql.setNullString("usedUnitId");
			} else {
				sql.setString("usedUnitId", materialSpec.getUsedUnitId());
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
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
		if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Sql sql = new Sql(
				"SELECT BRAND,CAPACITY,MANAGE_PATTERN,MATERIAL_CODE,MATERIAL_MODEL,MATERIAL_SPEC_ID,MATERIAL_TYPE,METERIAL_SN_CODE,NAME,NEED_FLAG,REMARKS,STS,STS_DATE,UNIT_ID,USED_UNIT_ID FROM MATERIAL_SPEC WHERE 1=1  ");
		sql.append(" and MATERIAL_SPEC_ID=:materialSpecId");
		sql.setLong("materialSpecId", materialSpec.getMaterialSpecId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		materialSpec = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				materialSpec = new MaterialSpecSVO();
				materialSpec.setBrand(rs.getString("BRAND"));
				materialSpec.setCapacity(rs.getString("CAPACITY"));
				materialSpec.setManagePattern(rs.getString("MANAGE_PATTERN"));
				materialSpec.setMaterialCode(rs.getString("MATERIAL_CODE"));
				materialSpec.setMaterialModel(rs.getString("MATERIAL_MODEL"));
				materialSpec
						.setMaterialSpecId(rs.getString("MATERIAL_SPEC_ID"));
				materialSpec.setMaterialType(rs.getString("MATERIAL_TYPE"));
				materialSpec
						.setMeterialSnCode(rs.getString("METERIAL_SN_CODE"));
				materialSpec.setName(rs.getString("NAME"));
				materialSpec.setNeedFlag(rs.getString("NEED_FLAG"));
				materialSpec.setRemarks(rs.getString("REMARKS"));
				materialSpec.setSts(rs.getString("STS"));
				materialSpec.setStsDate(rs.getTimestamp("STS_DATE"));
				materialSpec.setUnitId(rs.getString("UNIT_ID"));
				materialSpec.setUsedUnitId(rs.getString("USED_UNIT_ID"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return materialSpec;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT BRAND,CAPACITY,MANAGE_PATTERN,MATERIAL_CODE,MATERIAL_MODEL,MATERIAL_SPEC_ID,MATERIAL_TYPE,METERIAL_SN_CODE,NAME,NEED_FLAG,REMARKS,STS,STS_DATE,UNIT_ID,USED_UNIT_ID FROM MATERIAL_SPEC WHERE 1=1 ");
		try {
			if (materialSpec.getFlagBrand() == 1) {
				if (StringUtil.isBlank(materialSpec.getBrand())) {
					sql.append(" and BRAND is null ");
				} else {
					sql.append(" and BRAND=:brand");
					sql.setString("brand", materialSpec.getBrand());
				}
			}

			if (materialSpec.getFlagCapacity() == 1) {
				if (StringUtil.isBlank(materialSpec.getCapacity())) {
					sql.append(" and CAPACITY is null ");
				} else {
					sql.append(" and CAPACITY=:capacity");
					sql.setLong("capacity", materialSpec.getCapacity());
				}
			}

			if (materialSpec.getFlagManagePattern() == 1) {
				if (StringUtil.isBlank(materialSpec.getManagePattern())) {
					sql.append(" and MANAGE_PATTERN is null ");
				} else {
					sql.append(" and MANAGE_PATTERN=:managePattern");
					sql.setString("managePattern", materialSpec
							.getManagePattern());
				}
			}

			if (materialSpec.getFlagMaterialCode() == 1) {
				if (StringUtil.isBlank(materialSpec.getMaterialCode())) {
					sql.append(" and MATERIAL_CODE is null ");
				} else {
					sql.append(" and MATERIAL_CODE=:materialCode");
					sql.setString("materialCode", materialSpec
							.getMaterialCode());
				}
			}

			if (materialSpec.getFlagMaterialModel() == 1) {
				if (StringUtil.isBlank(materialSpec.getMaterialModel())) {
					sql.append(" and MATERIAL_MODEL is null ");
				} else {
					sql.append(" and MATERIAL_MODEL=:materialModel");
					sql.setString("materialModel", materialSpec
							.getMaterialModel());
				}
			}

			if (materialSpec.getFlagMaterialSpecId() == 1) {
				if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
					sql.append(" and MATERIAL_SPEC_ID is null ");
				} else {
					sql.append(" and MATERIAL_SPEC_ID=:materialSpecId");
					sql.setLong("materialSpecId", materialSpec
							.getMaterialSpecId());
				}
			}

			if (materialSpec.getFlagMaterialType() == 1) {
				if (StringUtil.isBlank(materialSpec.getMaterialType())) {
					sql.append(" and MATERIAL_TYPE is null ");
				} else {
					sql.append(" and MATERIAL_TYPE=:materialType");
					sql.setString("materialType", materialSpec
							.getMaterialType());
				}
			}

			if (materialSpec.getFlagMeterialSnCode() == 1) {
				if (StringUtil.isBlank(materialSpec.getMeterialSnCode())) {
					sql.append(" and METERIAL_SN_CODE is null ");
				} else {
					sql.append(" and METERIAL_SN_CODE=:meterialSnCode");
					sql.setString("meterialSnCode", materialSpec
							.getMeterialSnCode());
				}
			}

			if (materialSpec.getFlagName() == 1) {
				if (StringUtil.isBlank(materialSpec.getName())) {
					sql.append(" and NAME is null ");
				} else {
					sql.append(" and NAME=:name");
					sql.setString("name", materialSpec.getName());
				}
			}

			if (materialSpec.getFlagNeedFlag() == 1) {
				if (StringUtil.isBlank(materialSpec.getNeedFlag())) {
					sql.append(" and NEED_FLAG is null ");
				} else {
					sql.append(" and NEED_FLAG=:needFlag");
					sql.setString("needFlag", materialSpec.getNeedFlag());
				}
			}

			if (materialSpec.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(materialSpec.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", materialSpec.getRemarks());
				}
			}

			if (materialSpec.getFlagSts() == 1) {
				if (StringUtil.isBlank(materialSpec.getSts())) {
					sql.append(" and STS is null ");
				} else {
					sql.append(" and STS=:sts");
					sql.setString("sts", materialSpec.getSts());
				}
			}

			if (materialSpec.getFlagStsDate() == 1) {
				if (materialSpec.getStsDate() == null) {
					sql.append(" and STS_DATE is null ");
				} else {
					sql.append(" and STS_DATE=:stsDate");
					sql.setTimestamp("stsDate", materialSpec.getStsDate());
				}
			}

			if (materialSpec.getFlagUnitId() == 1) {
				if (StringUtil.isBlank(materialSpec.getUnitId())) {
					sql.append(" and UNIT_ID is null ");
				} else {
					sql.append(" and UNIT_ID=:unitId");
					sql.setString("unitId", materialSpec.getUnitId());
				}
			}

			if (materialSpec.getFlagUsedUnitId() == 1) {
				if (StringUtil.isBlank(materialSpec.getUsedUnitId())) {
					sql.append(" and USED_UNIT_ID is null ");
				} else {
					sql.append(" and USED_UNIT_ID=:usedUnitId");
					sql.setString("usedUnitId", materialSpec.getUsedUnitId());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				materialSpec = new MaterialSpecSVO();
				materialSpec.setBrand(rs.getString("BRAND"));
				materialSpec.setCapacity(rs.getString("CAPACITY"));
				materialSpec.setManagePattern(rs.getString("MANAGE_PATTERN"));
				materialSpec.setMaterialCode(rs.getString("MATERIAL_CODE"));
				materialSpec.setMaterialModel(rs.getString("MATERIAL_MODEL"));
				materialSpec
						.setMaterialSpecId(rs.getString("MATERIAL_SPEC_ID"));
				materialSpec.setMaterialType(rs.getString("MATERIAL_TYPE"));
				materialSpec
						.setMeterialSnCode(rs.getString("METERIAL_SN_CODE"));
				materialSpec.setName(rs.getString("NAME"));
				materialSpec.setNeedFlag(rs.getString("NEED_FLAG"));
				materialSpec.setRemarks(rs.getString("REMARKS"));
				materialSpec.setSts(rs.getString("STS"));
				materialSpec.setStsDate(rs.getTimestamp("STS_DATE"));
				materialSpec.setUnitId(rs.getString("UNIT_ID"));
				materialSpec.setUsedUnitId(rs.getString("USED_UNIT_ID"));
				res.add(materialSpec);

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
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
		if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MATERIAL_SPEC SET ");
		try {
			if (materialSpec.getFlagBrand() == 1) {
				sql.append("BRAND=:brand,");
				sql.setString("brand", materialSpec.getBrand());
			}

			if (materialSpec.getFlagCapacity() == 1) {
				sql.append("CAPACITY=:capacity,");
				sql.setLong("capacity", materialSpec.getCapacity());
			}

			if (materialSpec.getFlagManagePattern() == 1) {
				sql.append("MANAGE_PATTERN=:managePattern,");
				sql.setString("managePattern", materialSpec.getManagePattern());
			}

			if (materialSpec.getFlagMaterialCode() == 1) {
				sql.append("MATERIAL_CODE=:materialCode,");
				sql.setString("materialCode", materialSpec.getMaterialCode());
			}

			if (materialSpec.getFlagMaterialModel() == 1) {
				sql.append("MATERIAL_MODEL=:materialModel,");
				sql.setString("materialModel", materialSpec.getMaterialModel());
			}

			if (materialSpec.getFlagMaterialType() == 1) {
				sql.append("MATERIAL_TYPE=:materialType,");
				sql.setString("materialType", materialSpec.getMaterialType());
			}

			if (materialSpec.getFlagMeterialSnCode() == 1) {
				sql.append("METERIAL_SN_CODE=:meterialSnCode,");
				sql.setString("meterialSnCode", materialSpec
						.getMeterialSnCode());
			}

			if (materialSpec.getFlagName() == 1) {
				sql.append("NAME=:name,");
				sql.setString("name", materialSpec.getName());
			}

			if (materialSpec.getFlagNeedFlag() == 1) {
				sql.append("NEED_FLAG=:needFlag,");
				sql.setString("needFlag", materialSpec.getNeedFlag());
			}

			if (materialSpec.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", materialSpec.getRemarks());
			}

			if (materialSpec.getFlagSts() == 1) {
				sql.append("STS=:sts,");
				sql.setString("sts", materialSpec.getSts());
			}

			if (materialSpec.getFlagStsDate() == 1) {
				sql.append("STS_DATE=:stsDate,");
				sql.setTimestamp("stsDate", materialSpec.getStsDate());
			}

			if (materialSpec.getFlagUnitId() == 1) {
				sql.append("UNIT_ID=:unitId,");
				sql.setString("unitId", materialSpec.getUnitId());
			}

			if (materialSpec.getFlagUsedUnitId() == 1) {
				sql.append("USED_UNIT_ID=:usedUnitId,");
				sql.setString("usedUnitId", materialSpec.getUsedUnitId());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			sql.append(" and MATERIAL_SPEC_ID=:materialSpecId");
			sql.setLong("materialSpecId", materialSpec.getMaterialSpecId());

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
				"INSERT INTO MATERIAL_SPEC(BRAND,CAPACITY,MANAGE_PATTERN,MATERIAL_CODE,MATERIAL_MODEL,MATERIAL_SPEC_ID,MATERIAL_TYPE,METERIAL_SN_CODE,NAME,NEED_FLAG,REMARKS,STS,STS_DATE,UNIT_ID,USED_UNIT_ID)");
		sql
				.append(" VALUES (:brand,:capacity,:managePattern,:materialCode,:materialModel,:materialSpecId,:materialType,:meterialSnCode,:name,:needFlag,:remarks,:sts,:stsDate,:unitId,:usedUnitId)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MaterialSpecSVO materialSpec = (MaterialSpecSVO) list.get(i);
				if (materialSpec == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
					throw new AppException("100002", "缺少对象的主键！");
				}
				if (StringUtil.isBlank(materialSpec.getBrand())) {
					sql.setNullString("brand");
				} else {
					sql.setString("brand", materialSpec.getBrand());
				}

				if (StringUtil.isBlank(materialSpec.getCapacity())) {
					sql.setNullLong("capacity");
				} else {
					sql.setLong("capacity", materialSpec.getCapacity());
				}

				if (StringUtil.isBlank(materialSpec.getManagePattern())) {
					sql.setString("managePattern", "S");
				} else {
					sql.setString("managePattern", materialSpec
							.getManagePattern());
				}

				if (StringUtil.isBlank(materialSpec.getMaterialCode())) {
					sql.setNullString("materialCode");
				} else {
					sql.setString("materialCode", materialSpec
							.getMaterialCode());
				}

				if (StringUtil.isBlank(materialSpec.getMaterialModel())) {
					sql.setNullString("materialModel");
				} else {
					sql.setString("materialModel", materialSpec
							.getMaterialModel());
				}

				if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
					sql.setNullLong("materialSpecId");
				} else {
					sql.setLong("materialSpecId", materialSpec
							.getMaterialSpecId());
				}

				if (StringUtil.isBlank(materialSpec.getMaterialType())) {
					sql.setNullString("materialType");
				} else {
					sql.setString("materialType", materialSpec
							.getMaterialType());
				}

				if (StringUtil.isBlank(materialSpec.getMeterialSnCode())) {
					sql.setNullString("meterialSnCode");
				} else {
					sql.setString("meterialSnCode", materialSpec
							.getMeterialSnCode());
				}

				if (StringUtil.isBlank(materialSpec.getName())) {
					sql.setNullString("name");
				} else {
					sql.setString("name", materialSpec.getName());
				}

				if (StringUtil.isBlank(materialSpec.getNeedFlag())) {
					sql.setString("needFlag", "N");
				} else {
					sql.setString("needFlag", materialSpec.getNeedFlag());
				}

				if (StringUtil.isBlank(materialSpec.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", materialSpec.getRemarks());
				}

				if (StringUtil.isBlank(materialSpec.getSts())) {
					sql.setString("sts", "A");
				} else {
					sql.setString("sts", materialSpec.getSts());
				}

				if (materialSpec.getStsDate() == null) {
					sql.setNullDate("stsDate");
				} else {
					sql.setTimestamp("stsDate", materialSpec.getStsDate());
				}

				if (StringUtil.isBlank(materialSpec.getUnitId())) {
					sql.setNullString("unitId");
				} else {
					sql.setString("unitId", materialSpec.getUnitId());
				}

				if (StringUtil.isBlank(materialSpec.getUsedUnitId())) {
					sql.setNullString("usedUnitId");
				} else {
					sql.setString("usedUnitId", materialSpec.getUsedUnitId());
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
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
		if (StringUtil.isBlank(materialSpec.getMaterialSpecId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MATERIAL_SPEC WHERE 1=1  ");
		sql.append(" and MATERIAL_SPEC_ID=:materialSpecId");
		sql.setLong("materialSpecId", materialSpec.getMaterialSpecId());

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
		MaterialSpecSVO materialSpec = (MaterialSpecSVO) vo;
	}
}
