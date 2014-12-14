package com.cattsoft.pub.util;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-12 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class Sql {

    private static final Logger log = Logger.getLogger(Sql.class);

    // sql���
    private StringBuffer sqlStr = new StringBuffer();

    // ռλ������sql����е��Ⱥ�˳��
    private List paramIndexs = new ArrayList();

    // ռλ������-ֵ��Ӧ��ϵMap<String,Parameter>
    private Map parameters = new HashMap();

    // ռλ����ʼ���
    private static final String PARAM_SIGN = ":";

    private static final String REF_SIGN = "?";

    public Sql() {

    }

    public Sql(String sql) {
        sqlStr = new StringBuffer(sql);
    }

    /**
     * ��ñ�׼�Ĵ�����sql(?��Ϊ�������õ�sql)
     * 
     * @param sql
     */
    public void setSql(String sql) {
        this.sqlStr = new StringBuffer(sql);
        parameters = new HashMap();
        paramIndexs = new ArrayList();
    }

    public void append(String sql) {
        this.sqlStr.append(sql);
    }

    public void insert(int index, String str) {
        this.sqlStr.insert(index, str);
    }

    /**
     * ���� ����ת�����sql��ռλ��ת��?��
     * 
     * @return
     */
    public String getSql() {
        // paramIndexs = orderParameters();
        // sqlStr = new StringBuffer(converSql(sqlStr.toString()));
        return sqlStr.toString();
    }

    public void setNullBlob(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_DATE, null));
    }

    public void setBlob(String name, Blob blob) {
        // TODO ���ֶβ�������2
    }

    public void setNullClob(String name) {
        // TODO ���ֶβ�������1
    }

    public void setClob(String name, Clob blob) {
        // TODO ���ֶβ�������2
    }

    public void setString(String name, String value) {
        if (StringUtil.isBlank(value))
            this.setNullString(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.STRING, value));
        }
    }

    public void setNullString(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_STRING, null));
    }

    public void setDate(String name, Date value) {
        if (null == value)
            this.setNullDate(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.DATE, value));
        }
    }

    public void setDate(String name, java.util.Date value) {
        if (null == value)
            this.setNullDate(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.DATE, new Date(value.getTime())));
        }
    }

    public void setNullDate(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_DATE, null));
    }

    public void setTimestamp(String name, java.util.Date value) {
        if (null == value)
            this.setNullDate(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.TIME_STAMP, new Timestamp(value
                    .getTime())));
        }
    }

    public void setNullTimestamp(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_TIME_STAMP, null));
    }

    public void setInteger(String name, Integer value) {
        if (null == value)
            this.setNullInteger(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.INTEGER, value));
        }
    }

    public void setNullInteger(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_INTEGER, null));
    }

    public void setInteger(String name, String value) {
        if (StringUtil.isBlank(value))
            this.setNullInteger(name);
        else {
            Integer integerValue = Integer.valueOf(value);
            setInteger(name, integerValue);
        }
    }

    public void setLong(String name, Long value) {
        if (null == value)
            this.setNullLong(name);
        else {
            name = name.trim();
            parameters.put(name, new Parameter(name, Parameter.LONG, value));
        }
    }

    public void setNullLong(String name) {
        name = name.trim();
        parameters.put(name, new Parameter(name, Parameter.NULL_LONG, null));
    }

    public void setLong(String name, String value) {
        if (StringUtil.isBlank(value))
            this.setNullLong(name);
        else {
            Long longValue = Long.valueOf(value);
            setLong(name, longValue);
        }
    }

    /**
     * �����������������sql���
     * 
     * @param classObj
     * @throws AppException
     */
    public void log(Class classObj) throws AppException {
        if (null == classObj) {
            throw new AppException("100006", "ȱ����־�����ָ���࣡");
        }

        // �����־������sql������������
        String logSqlStr = sqlStr.toString();
        Iterator itor = parameters.keySet().iterator();
        while (itor.hasNext()) {
            String paramName = (String) itor.next();
            Parameter param = (Parameter) parameters.get(paramName);
            logSqlStr = logSqlStr.replaceAll(PARAM_SIGN + paramName, param.getSqlStr());

        }

        Logger log = Logger.getLogger(classObj);
        // LogUtil.debug(log, this.getSql());
        LogUtil.debug(log, logSqlStr);
    }

    /**
     * ����paramIndexs�Ĳ���˳�򣬴�parameters��ȡ����Ӧ��ֵ����ps���ò���ֵ
     * 
     * @param ps
     * @return
     * @throws SysException
     */
    public PreparedStatement fillParams(PreparedStatement ps) throws AppException, SysException {
        if (null == ps)
            throw new AppException("100007", "ȱ�����ò�����PreparedStatement����");

        // ��sql�еĲ�������
        paramIndexs = this.orderParameters();
        // û�в�����ֱ�ӷ���
        if (null == paramIndexs)
            return ps;

        for (int i = 0; i < paramIndexs.size(); i++) {
            Parameter param = (Parameter) parameters.get(paramIndexs.get(i));
            if (null == param)
                throw new AppException("100008", "sql���ȱ�ٲ���" + paramIndexs.get(i) + "����!");
            ps = param.fillParam(ps, i + 1);
        }
        return ps;
    }

    public void clearParameters() {
        this.parameters = new HashMap();
    }

    /**
     * ת��sql��ռλ��ת��?��
     * 
     * @return
     */
    public String converSql(String converdSql) {
        if (null == converdSql || "".equals(converdSql)) {
            return null;
        }

        for (int i = 0; i < paramIndexs.size(); i++) {
            String paramName = (String) paramIndexs.get(i);
            converdSql = converdSql.replaceAll(PARAM_SIGN + paramName + "\\b", REF_SIGN);// \bƥ�䵥�ʽ�β
        }

        return converdSql;
    }

    /**
     * ��sql�е�ռλ����˳��ȡ��
     * 
     * @return
     */
    public List orderParameters() {
        List paramsOrder = new ArrayList();
        if (sqlStr != null) {
            int index = sqlStr.toString().indexOf(PARAM_SIGN);
            // ��ռλ��
            if (-1 == index) {
                return null;
            }
            String[] ary = sqlStr.substring(index + 1).split(PARAM_SIGN);
            for (int i = 0; i < ary.length; i++) {
                String[] temp = ary[i].split("\\W");
                paramsOrder.add(temp[0]);
            }
        }

        return paramsOrder;

    }

    /**
     * ��ָ�����ȣ���ȡ���length�����ַ���
     * 
     * @param length
     */
    public void removeSuffix(int length) {
        sqlStr = new StringBuffer(sqlStr.substring(0, sqlStr.length() - length));
    }

    public Object clone() {
        Sql cloneSql = new Sql();
        cloneSql.setSqlStr(sqlStr.toString());
        cloneSql.setParameters(parameters);
        cloneSql.setParamIndexs(paramIndexs);
        return cloneSql;
    }

    public Map getParameters() {
        return parameters;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public List getParamIndexs() {
        paramIndexs = this.orderParameters();
        return paramIndexs;
    }

    public void setParamIndexs(List paramIndexs) {
        this.paramIndexs = paramIndexs;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = new StringBuffer(sqlStr);
    }

    public static void main(String[] args) {
        Sql sql = new Sql();
        sql.append("select * from WHERE STS=:STS1 AND STSDATE =:STSDATE ");

        System.out.println(sql.getSql().replaceAll(":STS1\\b", "1"));

        String str = "for the wise";
        System.out.println(str.replaceAll("\\<the", "11"));

    }

}
