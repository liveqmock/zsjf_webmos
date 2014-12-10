package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.tm.component.dao.IChgServSpecMaterialMDAO;
import com.cattsoft.tm.vo.ChgServSpecMaterialMVO;
import com.cattsoft.tm.vo.ChgServSpecMaterialSVO;
import com.cattsoft.tm.vo.MaterialSpecMVO;
import com.cattsoft.tm.vo.MaterialSpecSVO;

public class ChgServSpecMaterialMDAOImpl extends ChgServSpecMaterialSDAOImpl implements IChgServSpecMaterialMDAO {

	public List findByMaterialVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		ChgServSpecMaterialMVO chgServSpecMaterial = (ChgServSpecMaterialMVO) vo;
		MaterialSpecMVO materialSpec ;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Sql sql = new Sql(" SELECT aa.*,(case when bb.AMOUNT is null then 0 else bb.AMOUNT end  ) as AMOUNT ");
       
		sql.append(" from (SELECT DISTINCT S.MATERIAL_SPEC_ID, S.NAME, S.UNIT_ID ");
				sql.append("  FROM CHG_SERV_SPEC_MATERIAL t, MATERIAL_SPEC S ");
				sql.append("   WHERE T.MATERIAL_ID = S.MATERIAL_SPEC_ID  ");
				sql.append("   and S.STS='A' ");
//		Sql sql = new Sql("  SELECT DISTINCT S.MATERIAL_SPEC_ID,S.NAME,S.UNIT_ID ");
//		sql.append(" FROM CHG_SERV_SPEC_MATERIAL t,MATERIAL_SPEC S ");
//		sql.append("  WHERE T.MATERIAL_ID=S.MATERIAL_SPEC_ID  ");
		
		try {
			if (chgServSpecMaterial.getFlagAreaId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getAreaId())) {
					sql.append(" and AREA_ID is null ");
				} else {
					sql.append(" and AREA_ID IN ('0',:areaId)");
					sql.setLong("areaId", chgServSpecMaterial.getAreaId());
				}
			}

			if (chgServSpecMaterial.getFlagChgServSpecId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getChgServSpecId())) {
					sql.append(" and CHG_SERV_SPEC_ID is null ");
				} else {
					sql.append(" and CHG_SERV_SPEC_ID IN ('0',:chgServSpecId)");
					sql.setString("chgServSpecId", chgServSpecMaterial
							.getChgServSpecId());
				}
			}

			if (chgServSpecMaterial.getFlagLocalNetId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getLocalNetId())) {
					sql.append(" and LOCAL_NET_ID is null ");
				} else {
					sql.append(" and LOCAL_NET_ID IN ('0',:localNetId)");
					sql.setLong("localNetId", chgServSpecMaterial
							.getLocalNetId());
				}
			}

			if (chgServSpecMaterial.getFlagProdId() == 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getProdId())) {
					sql.append(" and PROD_ID is null ");
				} else {
					sql.append(" and PROD_ID IN ('0',:prodId)");
					sql.setString("prodId", chgServSpecMaterial.getProdId());
				}
			}
			sql.append("    ) aa,");
		   sql.append("   (select * from MATERIAL_BACK_FILL mbf "); 
		   
		   if (chgServSpecMaterial.getFlagWorkOrder()== 1) {
				if (StringUtil.isBlank(chgServSpecMaterial.getWorkOrder())) {
					sql.append(" WHERE mbf.Wo_Nbr is null ");
				} else {
					sql.append(" where mbf.Wo_Nbr = :woNbr ");
					sql.setString("woNbr", chgServSpecMaterial.getWorkOrder());
				}
			}
		   sql.append(" ) bb ");
		   sql.append("  where   aa.material_spec_id=bb.material_spec_id(+)  ");
				
		if (!StringUtil.isBlank(chgServSpecMaterial.getMeterialSnCode())) {
			sql.append(" and METERIAL_SN_CODE= :meterialSnCode");
			sql.setString("meterialSnCode", chgServSpecMaterial.getMeterialSnCode());
		}	
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				materialSpec = new MaterialSpecMVO();
				materialSpec.setMaterialSpecId(rs.getString("MATERIAL_SPEC_ID"));
				materialSpec.setName(rs.getString("NAME"));
				materialSpec.setUnitId(rs.getString("UNIT_ID"));
				materialSpec.setAmount(rs.getInt("AMOUNT"));
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

	
}
