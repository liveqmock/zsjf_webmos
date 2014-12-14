package com.cattsoft.pub.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-6-6 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author liaoyh
 */
public class MaxId {
    private static Logger log = Logger.getLogger(MaxId.class);

    /**
     * getSequenceNextVal:�õ���һ��Sequence
     * 
     * @param columnName
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return long
     * @throws AppException
     */
    public static String getSequenceNextVal(String seqName) throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        long seq = 0;
        Sql sql = new Sql();
        sql.append("select " + seqName + "_SEQ.nextval from dual");
        // sql.setString("seqName", seqName);
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.fillParams(ps);
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = rs.getLong(1);
                // System.out.println(columnName + "_SEQ is :" + seq);
            }
        } catch (SQLException ex) {
            throw new SysException("", "�����ֶ���" + seqName + "�����ֵʧ��", ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        String str = Long.toString(seq);
        return str;
    }

    /**
     * getMaxIdFromTable:��ĳ���и��������õ�ָ���ֶε����ֵ
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param condition
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return long
     * @throws AppException
     */
    public static Long getMaxIdFromTable(String tableName, String columnName, String condition)
            throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        Long seq = null;
        Sql sql = new Sql();
        sql.append("select nvl(max(");
        sql.append(columnName);
        sql.append("),0) from ");
        sql.append(tableName);

        if (!StringUtil.isBlank(condition)) {
            sql.append(" where ");
            sql.append(condition);
        }
        System.out.println("sql is >>>>> "+sql.getSql());
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = new Long(rs.getLong(1));
                // //System.out.println("max_id is :" + seq);
            }
        } catch (SQLException ex) {
            throw new SysException("", "����" + tableName + "���ֶ�" + columnName + "�����ֵʧ��" + "sql is "
                    + sql, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return seq;

    }

    
    
    /**
     * getMaxSeqFromTable:��ĳ���и���vo���õ�seq���ֵ
     * 
     * @param tableName
     *            String
     * @param columnName
     *            String
     * @param condition
     *            String
     * @throws AppException
     * @throws SysException
     * @throws NamingException
     * @return long
     * @throws AppException
     */
    public static Long getMaxSeqFromTable(String tableName, String columnName, String condition)
            throws SysException, AppException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        Long seq = null;
        Sql sql = new Sql();
        sql.append("select nvl(max(");
        sql.append(columnName);
        sql.append("),0) from ");
        sql.append(tableName);

        if (!StringUtil.isBlank(condition)) {
            sql.append(" where ");
            sql.append(condition);
        }
        try {
            conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql.getSql());
            sql.log(MaxId.class);
            rs = ps.executeQuery();
            if (rs.next()) {
                seq = new Long(rs.getLong(1));
                // //System.out.println("max_id is :" + seq);
            }
        } catch (SQLException ex) {
            throw new SysException("", "����" + tableName + "���ֶ�" + columnName + "�����ֵʧ��" + "sql is "
                    + sql, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return seq;

    }
    
    
    
    /**
     * <p>
     * ʹ�÷���ʾ��1:getMaxId,ȡ���ֵ(һ������¶����������)
     * </p>
     * <p>
     * ˵��:
     * </p>
     * <p>
     * �����oracle��ȷ���Ѿ�����Sequence
     * </p>
     * <p>
     * �����Sybase��ȷ����MAX_IDS�����Ѿ����������
     * </p>
     * <p>
     * long commServSpecId ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * commServSpecId = maxId.getMaxId("comm_serv_spec_id");
     * </p>
     * <p>
     * .......
     * </p>
     * 
     * 
     * 
     * <p>
     * ʹ�÷���ʾ��2:getMaxAreaId,ȡ���ֵ(������ӡʱ��������ȡ���ֵ)
     * </p>
     * <p>
     * ˵��:
     * </p>
     * <p>
     * ��ȷ����MAX_IDS�����Ѿ����������
     * </p>
     * 
     * <p>
     * long printNbr ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * printNbr = maxId.getMaxAreaId("PRINT_NBR","10501");
     * </p>
     * 
     * 
     * 
     * <p>
     * ʹ�÷���ʾ��2:getMaxIdFromTable,��ĳ���и��������õ�ָ���ֶε����ֵ
     * </p>
     * 
     * <p>
     * long prodId ;
     * </p>
     * <p>
     * MaxId maxId = new MaxId() ;
     * </p>
     * <p>
     * prodId = maxId.getMaxIdFromTable("product","prod_id","sts = 'A'");
     * </p>
     * <p>
     * .......
     * </p>
     * 
     * 
     */
    public static void main(String args[]) {
    }

}
