package com.cattsoft.sp.component.dao.oracleImpl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.CollectionFactory;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sp.component.dao.ISoAttachMDAO;
import com.cattsoft.sp.vo.SoAttachMVO;
import com.cattsoft.sp.vo.SoAttachSVO;

public class SoAttachMDAOImpl implements ISoAttachMDAO {

	private static Logger log = Logger.getLogger(SoAttachMDAOImpl.class);

	public void updateSoAttach(FormFile file, String soAttachId)
			throws AppException, SysException {
		if (StringUtil.isBlank(soAttachId)) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE SO_ATTACH SET ATTACHMENT=? WHERE SO_ATTACH_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setBinaryStream(1, file.getInputStream(), file.getFileSize());
			ps.setLong(2, Long.parseLong(soAttachId));
			Sql logSql = new Sql(sql);
			logSql.log(this.getClass());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SysException("100003", "JDBC操作异常！", e);
		} catch (Exception e) {
			throw new SysException("100003", "JDBC操作异常！", e);
		} finally {
			JdbcUtil.close(ps);
		}
	}

	/**
	 * Mos Native是以byte[]上传，故重载此方法以适应byte[]
	 * @param bytes
	 * @param soAttachId
	 * @throws AppException
	 * @throws SysException
	 * @author maxun
	 * CreateTime 2012-11-13 15:08:08
	 */
	public void updateSoAttach(byte[] bytes, String soAttachId)
			throws AppException, SysException {
		if (StringUtil.isBlank(soAttachId)) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = ConnectionFactory.getConnection();
			String sql = "UPDATE SO_ATTACH SET ATTACHMENT=? WHERE SO_ATTACH_ID=?";
			ps = conn.prepareStatement(sql);
			InputStream inputStream=new ByteArrayInputStream(bytes);
			ps.setBinaryStream(1, inputStream,inputStream.available());
			ps.setLong(2, Long.parseLong(soAttachId));
			Sql logSql = new Sql(sql);
			logSql.log(this.getClass());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new SysException("100003", "JDBC操作异常！", e);
		} catch (Exception e) {
			throw new SysException("100003", "JDBC操作异常！", e);
		} finally {
			JdbcUtil.close(ps);
		}
	}
	
	public GenericVO findByPK(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		SoAttachSVO soAttach = (SoAttachSVO) vo;
		if (StringUtil.isBlank(soAttach.getSoAttachId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Sql sql = new Sql(
				"SELECT ATTACHMENT,FILE_NAME,LOCAL_NET_ID,REMARKS,SO_ATTACH_ID,SO_NBR,STS,STS_DATE,WO_NBR FROM SO_ATTACH WHERE 1=1  ");
		sql.append(" and SO_ATTACH_ID=:soAttachId");
		sql.setLong("soAttachId", soAttach.getSoAttachId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		SoAttachMVO soAttachMVO = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				soAttachMVO = new SoAttachMVO();
				//soAttachMVO.setAttachment(rs.getBlob("ATTACHMENT"));
				
				Blob b = rs.getBlob("ATTACHMENT");
				soAttachMVO.setBytes(b.getBytes(1, (int) b.length()));
				soAttachMVO.setFileName(rs.getString("FILE_NAME"));
				soAttachMVO.setLocalNetId(rs.getString("LOCAL_NET_ID"));
				soAttachMVO.setRemarks(rs.getString("REMARKS"));
				soAttachMVO.setSoAttachId(rs.getString("SO_ATTACH_ID"));
				soAttachMVO.setSoNbr(rs.getString("SO_NBR"));
				soAttachMVO.setSts(rs.getString("STS"));
				soAttachMVO.setStsDate(rs.getTimestamp("STS_DATE"));
				soAttachMVO.setWoNbr(rs.getString("WO_NBR"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return soAttachMVO;
	}
	public List findSoAttachListByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		SoAttachMVO soAttach = (SoAttachMVO) vo;
		List res = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT FILE_NAME,LOCAL_NET_ID,REMARKS,SO_ATTACH_ID,SO_NBR,STS,STS_DATE,WO_NBR,ATTACHMENT FROM SO_ATTACH WHERE 1=1 ");
		try {
			if (soAttach.getFlagAttachment() == 1) {
				if (soAttach.getAttachment() == null) {
					sql.append(" and ATTACHMENT is null ");
				} else {
					sql.append(" and ATTACHMENT=:attachment");
					sql.setBlob("attachment", soAttach.getAttachment());
				}
			}

			if (soAttach.getFlagFileName() == 1) {
				if (StringUtil.isBlank(soAttach.getFileName())) {
					sql.append(" and FILE_NAME is null ");
				} else {
					sql.append(" and FILE_NAME=:fileName");
					sql.setString("fileName", soAttach.getFileName());
				}
			}

			if (soAttach.getFlagLocalNetId() == 1) {
				if (StringUtil.isBlank(soAttach.getLocalNetId())) {
					sql.append(" and LOCAL_NET_ID is null ");
				} else {
					sql.append(" and LOCAL_NET_ID=:localNetId");
					sql.setLong("localNetId", soAttach.getLocalNetId());
				}
			}

			if (soAttach.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(soAttach.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", soAttach.getRemarks());
				}
			}

			if (soAttach.getFlagSoAttachId() == 1) {
				if (StringUtil.isBlank(soAttach.getSoAttachId())) {
					sql.append(" and SO_ATTACH_ID is null ");
				} else {
					sql.append(" and SO_ATTACH_ID=:soAttachId");
					sql.setLong("soAttachId", soAttach.getSoAttachId());
				}
			}

			if (soAttach.getFlagSoNbr() == 1) {
				if (StringUtil.isBlank(soAttach.getSoNbr())) {
					sql.append(" and SO_NBR is null ");
				} else {
					sql.append(" and SO_NBR=:soNbr");
					sql.setString("soNbr", soAttach.getSoNbr());
				}
			}

			if (soAttach.getFlagSts() == 1) {
				if (StringUtil.isBlank(soAttach.getSts())) {
					sql.append(" and STS is null ");
				} else {
					sql.append(" and STS=:sts");
					sql.setString("sts", soAttach.getSts());
				}
			}

			if (soAttach.getFlagStsDate() == 1) {
				if (soAttach.getStsDate() == null) {
					sql.append(" and STS_DATE is null ");
				} else {
					sql.append(" and STS_DATE=:stsDate");
					sql.setTimestamp("stsDate", soAttach.getStsDate());
				}
			}

			if (soAttach.getFlagWoNbr() == 1) {
				if (StringUtil.isBlank(soAttach.getWoNbr())) {
					sql.append(" and WO_NBR is null ");
				} else {
					sql.append(" and WO_NBR=:woNbr");
					sql.setLong("woNbr", soAttach.getWoNbr());
				}
			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				soAttach = new SoAttachMVO();
				Blob attachment = rs.getBlob("ATTACHMENT");
				 byte[] b = null;  
				try {
					if (attachment != null) {
						long in = 1;
						/**
						 * ：第一个参数表示从第一个字节开始返回字节，第二个参数说明它返回的字节长度是BLOB值的长度。
						 * 需要说明的是，因为SQL和Java语言之间的不同，一个BLOB值得第一个字节在位置1，
						 * 而Java数组的第一个元素的索引是0。
						 * */
						b = attachment.getBytes(in,(int)(attachment.length()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				soAttach.setSoAttachId(rs.getString("SO_ATTACH_ID"));
				soAttach.setBytes(b);
				soAttach.setRemarks(rs.getString("REMARKS"));
				res.add(soAttach);

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
