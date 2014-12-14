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
 * Title: 服务开通系统<br>
 * Description: <br>
 * Date: 2007-6-12 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class Sql {

    private static final Logger log = Logger.getLogger(Sql.class);

    // sql语句
    private StringBuffer sqlStr = new StringBuffer();

    // 占位符的在sql语句中的先后顺序
    private List paramIndexs = new ArrayList();

    // 占位符名称-值对应关系Map<String,Parameter>
    private Map parameters = new HashMap();

    // 占位符起始标记
    private static final String PARAM_SIGN = ":";

    private static final String REF_SIGN = "?";

    public Sql() {

    }

    public Sql(String sql) {
        sqlStr = new StringBuffer(sql);
    }

    /**
     * 获得标准的带参数sql(?作为参数引用的sql)
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
     * 返回 参数转换后的sql（占位符转成?）
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
        // TODO 大字段参数设置2
    }

    public void setNullClob(String name) {
        // TODO 大字段参数设置1
    }

    public void setClob(String name, Clob blob) {
        // TODO 大字段参数设置2
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
     * 输出完整不带参数的sql语句
     * 
     * @param classObj
     * @throws AppException
     */
    public void log(Class classObj) throws AppException {
        if (null == classObj) {
            throw new AppException("100006", "缺少日志输出的指定类！");
        }

        // 输出日志的完整sql（不含参数）
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
     * 根据paramIndexs的参数顺序，从parameters里取出对应的值，给ps设置参数值
     * 
     * @param ps
     * @return
     * @throws SysException
     */
    public PreparedStatement fillParams(PreparedStatement ps) throws AppException, SysException {
        if (null == ps)
            throw new AppException("100007", "缺少设置参数的PreparedStatement对象！");

        // 将sql中的参数排序
        paramIndexs = this.orderParameters();
        // 没有参数，直接返回
        if (null == paramIndexs)
            return ps;

        for (int i = 0; i < paramIndexs.size(); i++) {
            Parameter param = (Parameter) parameters.get(paramIndexs.get(i));
            if (null == param)
                throw new AppException("100008", "sql语句缺少参数" + paramIndexs.get(i) + "设置!");
            ps = param.fillParam(ps, i + 1);
        }
        return ps;
    }

    public void clearParameters() {
        this.parameters = new HashMap();
    }

    /**
     * 转换sql（占位符转成?）
     * 
     * @return
     */
    public String converSql(String converdSql) {
        if (null == converdSql || "".equals(converdSql)) {
            return null;
        }

        for (int i = 0; i < paramIndexs.size(); i++) {
            String paramName = (String) paramIndexs.get(i);
            converdSql = converdSql.replaceAll(PARAM_SIGN + paramName + "\\b", REF_SIGN);// \b匹配单词结尾
        }

        return converdSql;
    }

    /**
     * 将sql中的占位符按顺序取出
     * 
     * @return
     */
    public List orderParameters() {
        List paramsOrder = new ArrayList();
        if (sqlStr != null) {
            int index = sqlStr.toString().indexOf(PARAM_SIGN);
            // 无占位符
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
     * 按指定长度，截取最后length长的字符串
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
