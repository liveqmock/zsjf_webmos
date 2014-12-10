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
import com.cattsoft.tm.component.dao.IMosSurveySDAO;
import com.cattsoft.tm.vo.MosSurveySVO;

/**
 * 方法MosSurveySDAOImpl
 * <p>Company: 大唐软件</p>
 * @author ：白小亮。
 * @version 1.0  2007-5-14
 */
public class MosSurveySDAOImpl implements IMosSurveySDAO {
	private static Logger log = Logger.getLogger(MosSurveySDAOImpl.class);
	private static final String UNABLE_STS = "P";

	/**
	 * 增加。
	 * @return String
	 */
	public void add(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql(
				"INSERT INTO MOS_SURVEY(EXT_SO_NBR,IS_EXPLANATION,IS_FINISHED,IS_REVERSE_IN_TIME,IS_SATISFACTION,IS_VISIT_IN_TIME,MOS_SURVEY_ID,REMARKS,SIGNATURE)");
		sql
				.append(" VALUES (:extSoNbr,:isExplanation,:isFinished,:isReverseInTime,:isSatisfaction,:isVisitInTime,:mosSurveyId,:remarks,:signature)");
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

			if (mosSurvey.getSignature() == null) {
				sql.setNullBlob("signature");
			} else {
				sql.setBlob("signature", mosSurvey.getSignature());
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
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}

		Sql sql = new Sql(
				"SELECT EXT_SO_NBR,IS_EXPLANATION,IS_FINISHED,IS_REVERSE_IN_TIME,IS_SATISFACTION,IS_VISIT_IN_TIME,MOS_SURVEY_ID,REMARKS,SIGNATURE FROM MOS_SURVEY WHERE 1=1  ");
		sql.append(" and MOS_SURVEY_ID=:mosSurveyId");
		sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mosSurvey = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			sql.fillParams(ps);
			sql.log(this.getClass());
			rs = ps.executeQuery();

			while (rs.next()) {
				mosSurvey = new MosSurveySVO();
				mosSurvey.setExtSoNbr(rs.getString("EXT_SO_NBR"));
				mosSurvey.setIsExplanation(rs.getString("IS_EXPLANATION"));
				mosSurvey.setIsFinished(rs.getString("IS_FINISHED"));
				mosSurvey
						.setIsReverseInTime(rs.getString("IS_REVERSE_IN_TIME"));
				mosSurvey.setIsSatisfaction(rs.getString("IS_SATISFACTION"));
				mosSurvey.setIsVisitInTime(rs.getString("IS_VISIT_IN_TIME"));
				mosSurvey.setMosSurveyId(rs.getString("MOS_SURVEY_ID"));
				mosSurvey.setRemarks(rs.getString("REMARKS"));
				mosSurvey.setSignature(rs.getBlob("SIGNATURE"));
			}
		} catch (SQLException se) {
			throw new SysException("100003", "JDBC操作异常！", se);

		} finally {
			JdbcUtil.close(rs, ps);
		}
		return mosSurvey;
	}

	/**
	 * 批量查询的SQL。
	 * @return String ： 批量查询的SQL。
	 */
	public List findByVO(GenericVO vo) throws AppException, SysException {
		if (vo == null) {
			throw new AppException("100001", "缺少DAO操作对象！");
		}
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
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
				mosSurvey = new MosSurveySVO();
				mosSurvey.setExtSoNbr(rs.getString("EXT_SO_NBR"));
				mosSurvey.setIsExplanation(rs.getString("IS_EXPLANATION"));
				mosSurvey.setIsFinished(rs.getString("IS_FINISHED"));
				mosSurvey
						.setIsReverseInTime(rs.getString("IS_REVERSE_IN_TIME"));
				mosSurvey.setIsSatisfaction(rs.getString("IS_SATISFACTION"));
				mosSurvey.setIsVisitInTime(rs.getString("IS_VISIT_IN_TIME"));
				mosSurvey.setMosSurveyId(rs.getString("MOS_SURVEY_ID"));
				mosSurvey.setRemarks(rs.getString("REMARKS"));
//				mosSurvey.setSignature(rs.getBlob("SIGNATURE"));
				res.add(mosSurvey);

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
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("UPDATE MOS_SURVEY SET ");
		try {
			if (mosSurvey.getFlagExtSoNbr() == 1) {
				sql.append("EXT_SO_NBR=:extSoNbr,");
				sql.setString("extSoNbr", mosSurvey.getExtSoNbr());
			}

			if (mosSurvey.getFlagIsExplanation() == 1) {
				sql.append("IS_EXPLANATION=:isExplanation,");
				sql.setString("isExplanation", mosSurvey.getIsExplanation());
			}

			if (mosSurvey.getFlagIsFinished() == 1) {
				sql.append("IS_FINISHED=:isFinished,");
				sql.setString("isFinished", mosSurvey.getIsFinished());
			}

			if (mosSurvey.getFlagIsReverseInTime() == 1) {
				sql.append("IS_REVERSE_IN_TIME=:isReverseInTime,");
				sql
						.setString("isReverseInTime", mosSurvey
								.getIsReverseInTime());
			}

			if (mosSurvey.getFlagIsSatisfaction() == 1) {
				sql.append("IS_SATISFACTION=:isSatisfaction,");
				sql.setString("isSatisfaction", mosSurvey.getIsSatisfaction());
			}

			if (mosSurvey.getFlagIsVisitInTime() == 1) {
				sql.append("IS_VISIT_IN_TIME=:isVisitInTime,");
				sql.setString("isVisitInTime", mosSurvey.getIsVisitInTime());
			}

			if (mosSurvey.getFlagRemarks() == 1) {
				sql.append("REMARKS=:remarks,");
				sql.setString("remarks", mosSurvey.getRemarks());
			}

			if (mosSurvey.getFlagSignature() == 1) {
				sql.append("SIGNATURE=:signature,");
				sql.setBlob("signature", mosSurvey.getSignature());
			}

			sql.removeSuffix(1);
			sql.append(" WHERE 1=1 ");
			sql.append(" and MOS_SURVEY_ID=:mosSurveyId");
			sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());

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
				"INSERT INTO MOS_SURVEY(EXT_SO_NBR,IS_EXPLANATION,IS_FINISHED,IS_REVERSE_IN_TIME,IS_SATISFACTION,IS_VISIT_IN_TIME,MOS_SURVEY_ID,REMARKS,SIGNATURE)");
		sql
				.append(" VALUES (:extSoNbr,:isExplanation,:isFinished,:isReverseInTime,:isSatisfaction,:isVisitInTime,:mosSurveyId,:remarks,:signature)");
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql.getSql());
			for (int i = 0; i < list.size(); i++) {
				MosSurveySVO mosSurvey = (MosSurveySVO) list.get(i);
				if (mosSurvey == null) {
					throw new AppException("100001", "缺少DAO操作对象！");
				}
				if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
					throw new AppException("100002", "缺少对象的主键！");
				}
				if (StringUtil.isBlank(mosSurvey.getExtSoNbr())) {
					sql.setNullString("extSoNbr");
				} else {
					sql.setString("extSoNbr", mosSurvey.getExtSoNbr());
				}

				if (StringUtil.isBlank(mosSurvey.getIsExplanation())) {
					sql.setNullString("isExplanation");
				} else {
					sql
							.setString("isExplanation", mosSurvey
									.getIsExplanation());
				}

				if (StringUtil.isBlank(mosSurvey.getIsFinished())) {
					sql.setNullString("isFinished");
				} else {
					sql.setString("isFinished", mosSurvey.getIsFinished());
				}

				if (StringUtil.isBlank(mosSurvey.getIsReverseInTime())) {
					sql.setNullString("isReverseInTime");
				} else {
					sql.setString("isReverseInTime", mosSurvey
							.getIsReverseInTime());
				}

				if (StringUtil.isBlank(mosSurvey.getIsSatisfaction())) {
					sql.setNullString("isSatisfaction");
				} else {
					sql.setString("isSatisfaction", mosSurvey
							.getIsSatisfaction());
				}

				if (StringUtil.isBlank(mosSurvey.getIsVisitInTime())) {
					sql.setNullString("isVisitInTime");
				} else {
					sql
							.setString("isVisitInTime", mosSurvey
									.getIsVisitInTime());
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

				if (mosSurvey.getSignature() == null) {
					sql.setNullBlob("signature");
				} else {
					sql.setBlob("signature", mosSurvey.getSignature());
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
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
		if (StringUtil.isBlank(mosSurvey.getMosSurveyId())) {
			throw new AppException("100002", "缺少对象的主键！");
		}
		Connection conn = null;
		PreparedStatement ps = null;
		Sql sql = new Sql("DELETE FROM MOS_SURVEY WHERE 1=1  ");
		sql.append(" and MOS_SURVEY_ID=:mosSurveyId");
		sql.setLong("mosSurveyId", mosSurvey.getMosSurveyId());

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
		MosSurveySVO mosSurvey = (MosSurveySVO) vo;
	}
}
