package com.cattsoft.pub.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.Sql;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * <p>
 * Title: ��ҳ������
 * </p>
 * <p>
 * Description: �¾���ϵͳ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: CATTSoft
 * </p>
 * 
 * @author ʷ��
 * @version 1.0
 */
public class PagUtil {
	public PagUtil() {
	}

	private static Logger log = Logger.getLogger(PagUtil.class);

	private static int PAGE_NUM = 1000;// ��ʼҳ����

	/**
	 * ��÷�ҳ��Ϣ,����ÿҳ��ʾ��¼��,��Ҫ��ʾ��ҳ.
	 * ��û�еõ�ֵʱĬ��ֵΪ-1.PagInfo.getPagSize()��������ȷ��ֵ.��Ϊ-1���޷��õ���ȷ���
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @return PagInfo
	 */
	static public PagInfo getPagInfo(HttpServletRequest req) {
		PagInfo pagInfo = new PagInfo();
		int pagSize = req.getParameter("pagSize") == null ? 1000 : Integer
				.parseInt(req.getParameter("pagSize"));
		int pageNo = req.getParameter("pageNo") == null ? -1 : Integer
				.parseInt(req.getParameter("pageNo"));
		log.debug("pageSize" + pagSize);
		log.debug(req.getParameter("pagSize"));
		pagInfo.setPagSize(pagSize);
		pagInfo.setPagNo(pageNo);
		return pagInfo;
	}

	/**
	 * �Ƽ�ʹ��] ��÷�ҳ��Ϣ,����ÿҳ��ʾ��¼��,��Ҫ��ʾ��ҳ.
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param pagSize
	 *            int
	 * @return PagInfo
	 */
	static public PagInfo getPagInfo(HttpServletRequest req, int pagSize) {
		PagInfo pagInfo = new PagInfo();
		pagSize = req.getParameter("pagSize") == null ? pagSize : Integer
				.parseInt(req.getParameter("pagSize"));
		int pageNo = req.getParameter("pageNo") == null ? -1 : Integer
				.parseInt(req.getParameter("pageNo"));
		pagInfo.setPagSize(pagSize);
		pagInfo.setPagNo(pageNo);
		return pagInfo;
	}

	/**
	 * ��÷�ҳ��ѯ��SQL ��õ�SQL����ʹ����Oracle ����JDBC��ʽ�ķ�ҳ��ѯ
	 * 
	 * @param sql
	 *            String
	 * @return String
	 */
	public static Sql getPagSql(Sql pageSql, PagInfo pagInfo) {
		int pageSize = pagInfo.getPagSize(); // ÿҳ��ʾ��¼��
		int pageNo = pagInfo.getPagNo(); // �ڼ�ҳ
		if (pageNo < 0)
			pageNo = 1;

		pageSql.insert(0,
				"select * from ( select row_.*, rownum rownum_ from ( ");
		pageSql
				.append(" ) row_ where rownum <= :startOraclePageNum) where rownum_ >:endOraclePageNum ");

		pageSql
				.setInteger("startOraclePageNum",
						new Integer(pageNo * pageSize));
		pageSql.setInteger("endOraclePageNum", new Integer((pageNo - 1)
				* pageSize));

		
		return pageSql;
	}

	/**
	 * ��ò�ѯ��Ŀ������SQL, ����JDBC�Ĳ�ѯ,��ʹ����Oracle
	 * 
	 * @param sql
	 *            String
	 * @return String
	 */
	public static String getCountSql(String sql) {
		StringBuffer pagingSelect = new StringBuffer();
		pagingSelect.append("select count(*) from (");
		pagingSelect.append(sql);
		pagingSelect.append(")");
		return pagingSelect.toString();
	}

	/**
	 * ��ò�ѯ��Ŀ������Hql,����Herve
	 * 
	 * @param hql
	 *            String
	 * @return String
	 */
	public static String getCountHql(String hql) {
		String countHql = null;
		String tmpStr = null;
		if (hql.toLowerCase().indexOf("select") < 0) {
			countHql = "select count(*)  " + hql;
		} else {
			if (hql.toLowerCase().indexOf("distinct") < 0) {
				tmpStr = hql.substring(hql.toLowerCase().indexOf("from"));
				// System.out.println("hql:" + tmpStr);
				countHql = "select count(*)  " + tmpStr + "";
			} else {
				countHql = hql;
			}
		}
		if (log.isDebugEnabled()) {
			log.debug("countHql:" + countHql);
		}
		return countHql;
	}

	/*
	 * public static PagView InitPagView(Sql sql, PagInfo pagInfo) { int count =
	 * pagInfo.getCount(); // �ܼ�¼�� int pageSize = pagInfo.getPagSize(); //
	 * ÿҳ��ʾ��¼�� int pageNo = pagInfo.getPagNo(); // �ڼ�ҳ if (pageNo < 0) { //
	 * û�г�ʼ��Ĭ��Ϊ��һҳ pageNo = 1; } if (pageSize < 0) pageSize = 1000; PagView pv =
	 * new PagView(); PreparedStatement ps =null; ResultSet rs = null; try {
	 * Connection conn = ConnectionFactory.getConnection(); ps =
	 * conn.prepareStatement(getCountHql(sql.getSql())); sql.fillParams(ps); if
	 * (sql.getSql().toLowerCase().indexOf("distinct") < 0) { rs =
	 * ps.executeQuery(); if(rs.next()){ count = rs.getInt(0); } } else { rs =
	 * ps.executeQuery(); int i = 0; while (rs.next()) { i++; } count = i; }
	 * pv.setCount(count); if (log.isDebugEnabled()) log.debug("count:" +
	 * count); if (count % pageSize == 0) { // ����ҳ�� pv.setPagCount(count /
	 * pageSize); } else { pv.setPagCount(count / pageSize + 1); } if (pageNo >
	 * pv.getPagCount()) pageNo = pv.getPagCount(); pv.setPagSize(pageSize);
	 * pv.setPagNo(pageNo); if (log.isDebugEnabled()) log.debug("pageSize��" +
	 * pv.getPagSize()); if (log.isDebugEnabled()) log.debug("pageNo��" +
	 * pv.getPagNo()); if (log.isDebugEnabled()) log.debug("hql��" + hql); Query
	 * q = session.createQuery(hql); q.setFirstResult((pageNo - 1) * pageSize);
	 * q.setMaxResults(pageSize);
	 * 
	 * Iterator ita=q.iterate(); List lt=new ArrayList(); while(ita.hasNext()){
	 * lt.add(ita.next()); }
	 * 
	 * pv.setViewList(q.list()); } catch (HibernateException ex) {
	 * ex.printStackTrace(); throw ex; } catch (HibernateSessionException ex) {
	 * ex.printStackTrace(); } return pv; }
	 */

	/**
	 * ����ܼ�¼�� JDBC
	 * 
	 * @param conn
	 *            Connection
	 * @param sql
	 *            String
	 * @throws SQLException
	 * @return int
	 * @throws SysException
	 * @throws AppException
	 */
	public static int getCountJDBC(Connection conn, Sql sql)
			throws AppException, SysException {
		int count = 0;
		Sql coutSql = (Sql)sql.clone();
		PreparedStatement ps = null;
		ResultSet rs = null;
		coutSql.setSqlStr(getCountSql(sql.getSql()));
		// System.out.println("coutSql:" + coutSql);
		try {
			ps = conn.prepareStatement(coutSql.getSql());
			coutSql.fillParams(ps);
			coutSql.log(PagUtil.class);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException ex) {
			throw new SysException("", "", ex);
		} finally {
			JdbcUtil.close(rs, ps);
		}
		return count;
	}

	/**
	 * ��ѯ���ݿ�
	 * 
	 * @param conn
	 *            Connection ����
	 * @param sql
	 *            String ���ڲ�ѯ��SQL
	 * @param pv
	 *            PagView ������ҳ����Ϣ����ʾ����
	 * @throws SQLException
	 * @return ResultSet
	 * @throws SysException
	 * @throws AppException
	 */
	public static ResultSet queryOracle(Connection conn, Sql sql,
			PagInfo pagInfo) throws AppException, SysException {

		Sql pageSql = (Sql) sql.clone();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sql pagSql = getPagSql(pageSql, pagInfo);
		
		try {
			ps = conn.prepareStatement(pagSql.getSql());
			pagSql.fillParams(ps);
			pagSql.log(PagUtil.class);
			rs = ps.executeQuery();
			return rs;
		} catch (SQLException ex) {
			throw new SysException("100010", "��ҳ��ѯ�����쳣��", ex);
		}
	}

	/**
	 * ��ѯ���ݿ�
	 * 
	 * @param conn
	 *            Connection ����
	 * @param sql
	 *            String ���ڲ�ѯ��SQL
	 * @param pv
	 *            PagView ������ҳ����Ϣ����ʾ����
	 * @throws SQLException
	 * @return ResultSet
	 * @throws AppException
	 */
	/*
	 * public static ResultSet queryOracle(String sql, PagInfo pagInfo) throws
	 * SysException { int pageSize = pagInfo.getPagSize(); // ÿҳ��ʾ��¼�� int pageNo =
	 * pagInfo.getPagNo(); // �ڼ�ҳ if (pageNo < 0) pageNo = 1; Connection conn =
	 * null; PreparedStatement ps = null; ResultSet rs = null;
	 * 
	 * String pagSql = getPagSql(sql); List vos = new ArrayList(); try { Session
	 * session = HibernateSession.getSession(); conn = session.connection(); ps =
	 * conn.prepareStatement(pagSql); ps.setInt(1, pageNo * pageSize);
	 * ps.setInt(2, (pageNo - 1) * pageSize); rs = ps.executeQuery(); return rs; }
	 * catch (HibernateException ex) { throw new SysException("9000004",
	 * "queryOracle��HibernateException", ex); } catch (HibernateSessionException
	 * ex) { throw new SysException("9000004",
	 * "queryOracle��HibernateSessionException", ex); }
	 * 
	 * catch (SQLException ex) { throw new SysException("9000004",
	 * "queryOracle��SQLException", ex); } finally {
	 *  } }
	 */

	public static PagView InitPagViewJDBC(Connection conn, Sql sql,
			PagInfo pagInfo) throws SysException, AppException {
		int count; // �ܼ�¼��
		int pageSize = pagInfo.getPagSize(); // ÿҳ��ʾ��¼��
		int pageNo = pagInfo.getPagNo(); // �ڼ�ҳ
		if (pageNo < 0)
			pageNo = 1;

		PagView pv = new PagView();

		count = getCountJDBC(conn, sql);
		//LogUtil.debug(log,"rowcount:"+count);
		pv.setCount(count);
		if (count % pageSize == 0) { // ����ҳ��
			pv.setPagCount(count / pageSize);
		} else {
			pv.setPagCount(count / pageSize + 1);
		}
		if (pageNo < 0) { // û�г�ʼ��Ĭ��Ϊ��һҳ
			pageNo = 1;
		}
		pv.setPagSize(pageSize);
		pv.setPagNo(pageNo);

		return pv;
	}

	/**
	 * �ر��α������
	 * 
	 * @param ps
	 *            PreparedStatement
	 * @param rs
	 *            ResultSet
	 * @param conn
	 *            Connection
	 */
	public static void close(PreparedStatement ps, ResultSet rs, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			log.error("�α�رմ���", ex);
		}
	}

	/**
	 * ���ض���Ĳ�ѯ��¼����Ĭ��ΪPAGE_NUM
	 * 
	 * @param key
	 *            String
	 * @throws SysException
	 * @return int
	 */
	public static int getPageNum(String key) throws SysException {
		InputStream is = PagUtil.class.getResourceAsStream("/page.properties");
		try {
			PropertyResourceBundle prb = new PropertyResourceBundle(is);
			String str = prb.getString(key);
			if (str != null) {
				Integer it = new Integer(str);
				return it.intValue();
			} else
				// if not config ,return default value.
				return PAGE_NUM;

		} catch (IOException ex) {
			throw new SysException("", "", ex);
		}

	}

	public static void main(String[] args) {
		try {
			System.out.print("SM_SYS_USER" + PagUtil.getPageNum("SM_SYS_USER"));
		} catch (SysException ex) {
		}
	}
}
