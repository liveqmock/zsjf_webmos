package com.cattsoft.tm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.vo.GenericVO;

import com.cattsoft.tm.component.dao.IMosVersionMDAO;
import com.cattsoft.tm.vo.MosVersionSVO;

public class MosVersionMDAOImpl implements IMosVersionMDAO {

	/**
	 * 查询最新版本
	 */
	public MosVersionSVO getLateVersion(String which) throws SysException, AppException {
		// TODO Auto-generated method stub
		Sql sql = new Sql(
				"SELECT IS_FORCE,PUBLISH_DATE,PUBLISH_PATH,REMARKS,VERSION_DESC,VERSION_ID,VERSION_NUM FROM MOS_VERSION WHERE remarks='" +which+"' and "+
				"VERSION_NUM=(select MAX(VERSION_NUM) from MOS_VERSION where remarks='"+which+"' )");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MosVersionSVO mosVersion = null;
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
		} catch (Exception se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return mosVersion;
	}

	
}
