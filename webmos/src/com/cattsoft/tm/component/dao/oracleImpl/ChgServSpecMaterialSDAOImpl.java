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
import com.cattsoft.tm.component.dao.IChgServSpecMaterialSDAO;
import com.cattsoft.tm.vo.ChgServSpecMaterialSVO;

/**
 * 方法ChgServSpecMaterialSDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class ChgServSpecMaterialSDAOImpl implements IChgServSpecMaterialSDAO {
	private static Logger log = Logger
			.getLogger(ChgServSpecMaterialSDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO CHG_SERV_SPEC_MATERIAL(AREA_ID,CHG_SERV_SPEC_ID,CHG_SPEC_MATE_ID,LOCAL_NET_ID,MATERIAL_ID,PROD_ID,REMARKS,STS,STS_DATE)");
		sql
				.append(" VALUES (:areaId,:chgServSpecId,:chgSpecMateId,:localNetId,:materialId,:prodId,:remarks,:sts,:stsDate)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (StringUtil.isBlank(chgServSpecMaterial.getAreaId())) {
				sql.setNullLong("areaId");
			} else {
				sql.setLong("areaId", chgServSpecMaterial.getAreaId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getChgServSpecId())) {
				sql.setNullString("chgServSpecId");
			} else {
				sql.setString("chgServSpecId", chgServSpecMaterial
						.getChgServSpecId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getChgSpecMateId())) {
				sql.setNullString("chgSpecMateId");
			} else {
				sql.setString("chgSpecMateId", chgServSpecMaterial
						.getChgSpecMateId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getLocalNetId())) {
				sql.setNullLong("localNetId");
			} else {
				sql.setLong("localNetId", chgServSpecMaterial.getLocalNetId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getMaterialId())) {
				sql.setNullLong("materialId");
			} else {
				sql.setLong("materialId", chgServSpecMaterial.getMaterialId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getProdId())) {
				sql.setNullString("prodId");
			} else {
				sql.setString("prodId", chgServSpecMaterial.getProdId());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", chgServSpecMaterial.getRemarks());
			}

			if (StringUtil.isBlank(chgServSpecMaterial.getSts())) {
				sql.setNullString("sts");
			} else {
				sql.setString("sts", chgServSpecMaterial.getSts());
			}

			if (chgServSpecMaterial.getStsDate() == null) {
				sql.setNullDate("stsDate");
			} else {
				sql.setTimestamp("stsDate", chgServSpecMaterial.getStsDate());
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
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;

		Sql sql = new Sql(
				"SELECT AREA_ID,CHG_SERV_SPEC_ID,CHG_SPEC_MATE_ID,LOCAL_NET_ID,MATERIAL_ID,PROD_ID,REMARKS,STS,STS_DATE FROM CHG_SERV_SPEC_MATERIAL WHERE 1=1  ");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		chgServSpecMaterial = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				chgServSpecMaterial = new ChgServSpecMaterialSVO();
				chgServSpecMaterial.setAreaId(rs.getString("AREA_ID"));
				chgServSpecMaterial.setChgServSpecId(rs
						.getString("CHG_SERV_SPEC_ID"));
				chgServSpecMaterial.setChgSpecMateId(rs
						.getString("CHG_SPEC_MATE_ID"));
				chgServSpecMaterial.setLocalNetId(rs.getString("LOCAL_NET_ID"));
				chgServSpecMaterial.setMaterialId(rs.getString("MATERIAL_ID"));
				chgServSpecMaterial.setProdId(rs.getString("PROD_ID"));
				chgServSpecMaterial.setRemarks(rs.getString("REMARKS"));
				chgServSpecMaterial.setSts(rs.getString("STS"));
				chgServSpecMaterial.setStsDate(rs.getTimestamp("STS_DATE"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return chgServSpecMaterial;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT AREA_ID,CHG_SERV_SPEC_ID,CHG_SPEC_MATE_ID,LOCAL_NET_ID,MATERIAL_ID,PROD_ID,REMARKS,STS,STS_DATE FROM CHG_SERV_SPEC_MATERIAL WHERE 1=1 ");
		try {
			if (chgServSpecMaterial.getFlagAreaId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getAreaId())) {
					sql.append(" and AREA_ID is null ");
				} else {
					sql.append(" and AREA_ID=:areaId");
					sql.setLong("areaId", chgServSpecMaterial.getAreaId());
				}
			}

			if (chgServSpecMaterial.getFlagChgServSpecId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getChgServSpecId())) {
					sql.append(" and CHG_SERV_SPEC_ID is null ");
				} else {
					sql.append(" and CHG_SERV_SPEC_ID=:chgServSpecId");
					sql.setString("chgServSpecId", chgServSpecMaterial
							.getChgServSpecId());
				}
			}

			if (chgServSpecMaterial.getFlagChgSpecMateId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getChgSpecMateId())) {
					sql.append(" and CHG_SPEC_MATE_ID is null ");
				} else {
					sql.append(" and CHG_SPEC_MATE_ID=:chgSpecMateId");
					sql.setString("chgSpecMateId", chgServSpecMaterial
							.getChgSpecMateId());
				}
			}

			if (chgServSpecMaterial.getFlagLocalNetId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getLocalNetId())) {
					sql.append(" and LOCAL_NET_ID is null ");
				} else {
					sql.append(" and LOCAL_NET_ID=:localNetId");
					sql.setLong("localNetId", chgServSpecMaterial
							.getLocalNetId());
				}
			}

			if (chgServSpecMaterial.getFlagMaterialId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getMaterialId())) {
					sql.append(" and MATERIAL_ID is null ");
				} else {
					sql.append(" and MATERIAL_ID=:materialId");
					sql.setLong("materialId", chgServSpecMaterial
							.getMaterialId());
				}
			}

			if (chgServSpecMaterial.getFlagProdId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getProdId())) {
					sql.append(" and PROD_ID is null ");
				} else {
					sql.append(" and PROD_ID=:prodId");
					sql.setString("prodId", chgServSpecMaterial.getProdId());
				}
			}

			if (chgServSpecMaterial.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", chgServSpecMaterial.getRemarks());
				}
			}

			if (chgServSpecMaterial.getFlagSts() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getSts())) {
					sql.append(" and STS is null ");
				} else {
					sql.append(" and STS=:sts");
					sql.setString("sts", chgServSpecMaterial.getSts());
				}
			}

			if (chgServSpecMaterial.getFlagStsDate() == 1) {
				if (chgServSpecMaterial.getStsDate() == null) {
					sql.append(" and STS_DATE is null ");
				} else {
					sql.append(" and STS_DATE=:stsDate");
					sql.setTimestamp("stsDate", chgServSpecMaterial
							.getStsDate());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				chgServSpecMaterial = new ChgServSpecMaterialSVO();
				chgServSpecMaterial.setAreaId(rs.getString("AREA_ID"));
				chgServSpecMaterial.setChgServSpecId(rs
						.getString("CHG_SERV_SPEC_ID"));
				chgServSpecMaterial.setChgSpecMateId(rs
						.getString("CHG_SPEC_MATE_ID"));
				chgServSpecMaterial.setLocalNetId(rs.getString("LOCAL_NET_ID"));
				chgServSpecMaterial.setMaterialId(rs.getString("MATERIAL_ID"));
				chgServSpecMaterial.setProdId(rs.getString("PROD_ID"));
				chgServSpecMaterial.setRemarks(rs.getString("REMARKS"));
				chgServSpecMaterial.setSts(rs.getString("STS"));
				chgServSpecMaterial.setStsDate(rs.getTimestamp("STS_DATE"));
				res.add(chgServSpecMaterial);

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
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE CHG_SERV_SPEC_MATERIAL SET ");
		try {
			if (chgServSpecMaterial.getFlagAreaId() == 1) {
				sql.append("AREA_ID=:areaId,");
				sql.setLong("areaId", chgServSpecMaterial.getAreaId());
			}

			if (chgServSpecMaterial.getFlagChgServSpecId() == 1) {
				sql.append("CHG_SERV_SPEC_ID=:chgServSpecId,");
				sql.setString("chgServSpecId", chgServSpecMaterial
						.getChgServSpecId());
			}

			if (chgServSpecMaterial.getFlagChgSpecMateId() == 1) {
				sql.append("CHG_SPEC_MATE_ID=:chgSpecMateId,");
				sql.setString("chgSpecMateId", chgServSpecMaterial
						.getChgSpecMateId());
			}

			if (chgServSpecMaterial.getFlagLocalNetId() == 1) {
				sql.append("LOCAL_NET_ID=:localNetId,");
				sql.setLong("localNetId", chgServSpecMaterial.getLocalNetId());
			}

			if (chgServSpecMaterial.getFlagMaterialId() == 1) {
				sql.append("MATERIAL_ID=:materialId,");
				sql.setLong("materialId", chgServSpecMaterial.getMaterialId());
			}

			if (chgServSpecMaterial.getFlagProdId() == 1) {
				sql.append("PROD_ID=:prodId,");
				sql.setString("prodId", chgServSpecMaterial.getProdId());
			}

			if (chgServSpecMaterial.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", chgServSpecMaterial.getRemarks());
			}

			if (chgServSpecMaterial.getFlagSts() == 1) {
				sql.append("STS=:sts,");
				sql.setString("sts", chgServSpecMaterial.getSts());
			}

			if (chgServSpecMaterial.getFlagStsDate() == 1) {
				sql.append("STS_DATE=:stsDate,");
				sql.setTimestamp("stsDate", chgServSpecMaterial.getStsDate());
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
				"INSERT INTO CHG_SERV_SPEC_MATERIAL(AREA_ID,CHG_SERV_SPEC_ID,CHG_SPEC_MATE_ID,LOCAL_NET_ID,MATERIAL_ID,PROD_ID,REMARKS,STS,STS_DATE)");
		sql
				.append(" VALUES (:areaId,:chgServSpecId,:chgSpecMateId,:localNetId,:materialId,:prodId,:remarks,:sts,:stsDate)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) list
						.get(i);
				if (chgServSpecMaterial == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(chgServSpecMaterial.getAreaId())) {
					sql.setNullLong("areaId");
				} else {
					sql.setLong("areaId", chgServSpecMaterial.getAreaId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getChgServSpecId())) {
					sql.setNullString("chgServSpecId");
				} else {
					sql.setString("chgServSpecId", chgServSpecMaterial
							.getChgServSpecId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getChgSpecMateId())) {
					sql.setNullString("chgSpecMateId");
				} else {
					sql.setString("chgSpecMateId", chgServSpecMaterial
							.getChgSpecMateId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getLocalNetId())) {
					sql.setNullLong("localNetId");
				} else {
					sql.setLong("localNetId", chgServSpecMaterial
							.getLocalNetId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getMaterialId())) {
					sql.setNullLong("materialId");
				} else {
					sql.setLong("materialId", chgServSpecMaterial
							.getMaterialId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getProdId())) {
					sql.setNullString("prodId");
				} else {
					sql.setString("prodId", chgServSpecMaterial.getProdId());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getRemarks())) {
					sql.setNullString("remarks");
				} else {
					sql.setString("remarks", chgServSpecMaterial.getRemarks());
				}

				if (StringUtil.isBlank(chgServSpecMaterial.getSts())) {
					sql.setNullString("sts");
				} else {
					sql.setString("sts", chgServSpecMaterial.getSts());
				}

				if (chgServSpecMaterial.getStsDate() == null) {
					sql.setNullDate("stsDate");
				} else {
					sql.setTimestamp("stsDate", chgServSpecMaterial
							.getStsDate());
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
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM CHG_SERV_SPEC_MATERIAL WHERE 1=1  ");

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
		ChgServSpecMaterialSVO chgServSpecMaterial = (ChgServSpecMaterialSVO) vo;
	}
}
