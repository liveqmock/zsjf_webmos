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
     * getSequenceNextVal:得到下一个Sequence
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
            throw new SysException("", "查找字段名" + seqName + "的最大值失败", ex);
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
     * getMaxIdFromTable:从某表中根据条件得到指定字段的最大值
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
            throw new SysException("", "查找" + tableName + "表字段" + columnName + "的最大值失败" + "sql is "
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
     * getMaxSeqFromTable:从某表中根据vo。得到seq最大值
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
            throw new SysException("", "查找" + tableName + "表字段" + columnName + "的最大值失败" + "sql is "
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
     * 使用方法示例1:getMaxId,取最大值(一般情况下都用这个方法)
     * </p>
     * <p>
     * 说明:
     * </p>
     * <p>
     * 如果是oracle请确认已经建好Sequence
     * </p>
     * <p>
     * 如果是Sybase请确认在MAX_IDS表中已经有相关数据
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
     * 使用方法示例2:getMaxAreaId,取最大值(工单打印时按照区域取最大值)
     * </p>
     * <p>
     * 说明:
     * </p>
     * <p>
     * 请确认在MAX_IDS表中已经有相关数据
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
     * 使用方法示例2:getMaxIdFromTable,从某表中根据条件得到指定字段的最大值
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
