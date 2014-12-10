package com.cattsoft.tm.component.dao.oracleImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.sql.BLOB;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.JdbcUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.tm.component.dao.IMosSurveyMDAO;
import com.cattsoft.tm.vo.MosSurveyMVO;

public class MosSurveyMDAOImpl implements IMosSurveyMDAO {

	public void addWithoutSignature(GenericVO vo) throws AppException, SysException{
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosSurveyMVO mosSurvey = (MosSurveyMVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_SURVEY(EXT_SO_NBR,IS_EXPLANATION,IS_FINISHED,IS_REVERSE_IN_TIME,IS_SATISFACTION,IS_VISIT_IN_TIME,MOS_SURVEY_ID,REMARKS,SIGNATURE)");
		sql
				.append(" VALUES (:extSoNbr,:isExplanation,:isFinished,:isReverseInTime,:isSatisfaction,:isVisitInTime,:mosSurveyId,:remarks,EMPTY_BLOB())");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			if (StringUtil.isBlank(mosSurvey.getExtSoNbr())) {
				sql.setNullString("extSoNbr");
			} else {
				sql.setString("extSoNbr", mosSurvey.getExtSoNbr());
			}

			if (StringUtil.isBlank(mosSurvey.getIsExplanation())) {
				sql.setNullString("isExplanation");
			} else {
				sql.setString("isExplanation", mosSurvey.getIsExplanation());
			}

			if (StringUtil.isBlank(mosSurvey.getIsFinished())) {
				sql.setNullString("isFinished");
			} else {
				sql.setString("isFinished", mosSurvey.getIsFinished());
			}

			if (StringUtil.isBlank(mosSurvey.getIsReverseInTime())) {
				sql.setNullString("isReverseInTime");
			} else {
				sql
						.setString("isReverseInTime", mosSurvey
								.getIsReverseInTime());
			}

			if (StringUtil.isBlank(mosSurvey.getIsSatisfaction())) {
				sql.setNullString("isSatisfaction");
			} else {
				sql.setString("isSatisfaction", mosSurvey.getIsSatisfaction());
			}

			if (StringUtil.isBlank(mosSurvey.getIsVisitInTime())) {
				sql.setNullString("isVisitInTime");
			} else {
				sql.setString("isVisitInTime", mosSurvey.getIsVisitInTime());
			}

			if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
				sql.setNullLong("mosSurveyId");
			} else {
				sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());
			}

			if (StringUtil.isBlank(mosSurvey.getRemarks())) {
				sql.setNullString("remarks");
			} else {
				sql.setString("remarks", mosSurvey.getRemarks());
			}

//			if (mosSurvey.getSignature() == null) {
//				sql.setNullBlob("signature");
//			} else {
//				sql.setBlob("signature", mosSurvey.getSignature());
//			}

			sql.fillParams(ps);
			sql.log(this.getClass());
			ps.executeUpdate();
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} finally {
			JdbcUtil.close(ps);
		}
	}
	
	public void updateSignature(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosSurveyMVO mosSurvey = (MosSurveyMVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT SIGNATURE FROM MOS_SURVEY WHERE MOS_SURVEY_ID = :mosSurveyId FOR UPDATE");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			
			if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
				sql.setNullLong("mosSurveyId");
			} else {
				sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());
			}

			sql.fillParams(ps);
			sql.log(this.getClass());
			rs=ps.executeQuery();
			if(rs.next()) {
				 Object obj = rs.getBlob(1);
			      Class clazz = obj.getClass();
			      Method method = clazz.getMethod("getBinaryOutputStream", new Class[]{});
			      OutputStream outputStream = (OutputStream)method.invoke(obj, new Object[]{});
//			      BufferedOutputStream bos = new BufferedOutputStream(os);
//
//				
//				oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob("SIGNATURE");
//				@SuppressWarnings("deprecation")
//				OutputStream outputStream=blob.getBinaryOutputStream();

					if (mosSurvey.getSignatureBytes() != null) {
						outputStream.write(mosSurvey.getSignatureBytes(), 0, mosSurvey.getSignatureBytes().length);
					}
					outputStream.flush();
					outputStream.close();

			}

		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} catch (IOException ie) {
			throw new SysException("", "io流操作异常", ie);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs,ps);
		}
	}
	
	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosSurveyMVO mosSurvey = (MosSurveyMVO) vo;
		List res = new ArrayList();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql sql = new Sql(
				"SELECT EXT_SO_NBR,IS_EXPLANATION,IS_FINISHED,IS_REVERSE_IN_TIME,IS_SATISFACTION,IS_VISIT_IN_TIME,MOS_SURVEY_ID,REMARKS,SIGNATURE FROM MOS_SURVEY WHERE 1=1 ");
		try {
			if (mosSurvey.getFlagExtSoNbr() == 1) {
				if (StringUtil.isBlank(mosSurvey.getExtSoNbr())) {
					sql.append(" and EXT_SO_NBR is null ");
				} else {
					sql.append(" and EXT_SO_NBR=:extSoNbr");
					sql.setString("extSoNbr", mosSurvey.getExtSoNbr());
				}
			}

			if (mosSurvey.getFlagIsExplanation() == 1) {
				if (StringUtil.isBlank(mosSurvey.getIsExplanation())) {
					sql.append(" and IS_EXPLANATION is null ");
				} else {
					sql.append(" and IS_EXPLANATION=:isExplanation");
					sql
							.setString("isExplanation", mosSurvey
									.getIsExplanation());
				}
			}

			if (mosSurvey.getFlagIsFinished() == 1) {
				if (StringUtil.isBlank(mosSurvey.getIsFinished())) {
					sql.append(" and IS_FINISHED is null ");
				} else {
					sql.append(" and IS_FINISHED=:isFinished");
					sql.setString("isFinished", mosSurvey.getIsFinished());
				}
			}

			if (mosSurvey.getFlagIsReverseInTime() == 1) {
				if (StringUtil.isBlank(mosSurvey.getIsReverseInTime())) {
					sql.append(" and IS_REVERSE_IN_TIME is null ");
				} else {
					sql.append(" and IS_REVERSE_IN_TIME=:isReverseInTime");
					sql.setString("isReverseInTime", mosSurvey
							.getIsReverseInTime());
				}
			}

			if (mosSurvey.getFlagIsSatisfaction() == 1) {
				if (StringUtil.isBlank(mosSurvey.getIsSatisfaction())) {
					sql.append(" and IS_SATISFACTION is null ");
				} else {
					sql.append(" and IS_SATISFACTION=:isSatisfaction");
					sql.setString("isSatisfaction", mosSurvey
							.getIsSatisfaction());
				}
			}

			if (mosSurvey.getFlagIsVisitInTime() == 1) {
				if (StringUtil.isBlank(mosSurvey.getIsVisitInTime())) {
					sql.append(" and IS_VISIT_IN_TIME is null ");
				} else {
					sql.append(" and IS_VISIT_IN_TIME=:isVisitInTime");
					sql
							.setString("isVisitInTime", mosSurvey
									.getIsVisitInTime());
				}
			}

			if (mosSurvey.getFlagMosSurveyId() == 1) {
				if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
					sql.append(" and MOS_SURVEY_ID is null ");
				} else {
					sql.append(" and MOS_SURVEY_ID=:mosSurveyId");
					sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());
				}
			}

			if (mosSurvey.getFlagRemarks() == 1) {
				if (StringUtil.isBlank(mosSurvey.getRemarks())) {
					sql.append(" and REMARKS is null ");
				} else {
					sql.append(" and REMARKS=:remarks");
					sql.setString("remarks", mosSurvey.getRemarks());
				}
			}

//			if (mosSurvey.getFlagSignature() == 1) {
//				if (mosSurvey.getSignature() == null) {
//					sql.append(" and SIGNATURE is null ");
//				} else {
//					sql.append(" and SIGNATURE=:signature");
//					sql.setBlob("signature", mosSurvey.getSignature());
//				}
//			}

			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			ps = sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosSurvey = new MosSurveyMVO();
				mosSurvey.setExtSoNbr(rs.getString("EXT_SO_NBR"));
				mosSurvey.setIsExplanation(rs.getString("IS_EXPLANATION"));
				mosSurvey.setIsFinished(rs.getString("IS_FINISHED"));
				mosSurvey
						.setIsReverseInTime(rs.getString("IS_REVERSE_IN_TIME"));
				mosSurvey.setIsSatisfaction(rs.getString("IS_SATISFACTION"));
				mosSurvey.setIsVisitInTime(rs.getString("IS_VISIT_IN_TIME"));
				mosSurvey.setMosSurveyId(rs.getString("MOS_SURVEY_ID"));
				mosSurvey.setRemarks(rs.getString("REMARKS"));
				
				BLOB blob = (BLOB)rs.getBlob("SIGNATURE");
				InputStream inputStream=blob.getBinaryStream();
				if(inputStream!=null) {
					byte[] signatureBytes=new byte[inputStream.available()];
					inputStream.read(signatureBytes, 0, signatureBytes.length);
					mosSurvey.setSignatureBytes(signatureBytes);
				}
				res.add(mosSurvey);

			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);
		} catch (IOException ie) {
			throw new SysException("", "io流操作异常", ie);
		} finally {
			JdbcUtil.close(rs, ps);
		}

		if (0 == res.size())
			res = null;
		return res;
	}
}
