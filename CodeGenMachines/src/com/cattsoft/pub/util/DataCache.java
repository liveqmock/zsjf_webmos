/*package com.cattsoft.pub.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sm.vo.StatusSVO;
import com.cattsoft.sm.vo.SysAreaConfigSVO;
import com.cattsoft.sm.vo.SysConfigSVO;
import com.cattsoft.sp.vo.DataCacheConfigSVO;


*//**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-20 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author caoyunliang
 *//*
public class DataCache {
    private static Log log = LogFactory.getLog(DataCache.class);

    public DataCache() {
    }

//    public static String LOCAL_NET = "local_net";
//
//    public static String LOCAL_NET_h = "local_net_h";
//
//    public static String AREA = "area";
//
//    public static String SERV_DEPT = "serv_dept";
//
//    public static String PRODUCT = "product";
//
//    public static String COMM_SERV_SPEC = "comm_serv_spec";
//
//    public static String RESOURCE_SPEC = "resource_spec";
//
//    public static String PROD_SPEC = "prod_spec";
//
//    public static String SERV_ACT = "serv_act";
//
//    public static String SERV_SPEC_CONT = "serv_spec_cont";
//
//    public static String LOCAL_NET_T = "local_net_t";
//
//    public static String AREA_T = "area_t";
//
//    public static String STATUS_SO_PAUSE = "status_SO_PAUSE";
//
//    public static String STATUS_SO_ACC_NBR = "status_SO_ACC_NBR";
//
//    public static String STATUS_BUSINESS = "status_BUSINESS";
//
//    public static String STATUS_SO = "status_SO";
//
//    public static String SYS_CONFIG = "sys_config";
//
//    public static String SYS_AREA_CONFIG = "sys_area_config";
//
//    public static String CERT_TYPE = "cert_type";
//
//    public static String CUST_VOCA = "cust_voca";
//
//    public static String CUST_TYPE = "cust_type";
//
//    public static String CUST_LEVEL = "cust_level";
//
//    public static String CUST_TYPE_T = "cust_type_t";

    private static HashMap allHashMaps = new HashMap();

    private static Class clazz = DataCache.class;
    
     用来缓存的HashMap变量名 
	public static final String AREA = "area";

	public static final String SYSCONFIG = "sysConfig";

	public static final String REGION = "region";

	public static final String PRODSPECCAT = "prodSpecCat";
	

	public static final String PROD_CAT = "prodCat";
	
	public static final String PROD_CAT_T="prodCat_t";

	public static final String PRODUCT = "prod";
	
	public static final String PRODUCT_T = "prod_t";

	public static final String CHANGESERVSPEC = "changeServSpec";

	public static final String LOCALNET = "localNet";
	
	public static final String LOCALNET_T="localNet_t";//本地网服务区

	public static final String WORKAREA = "workArea";

	public static final String EXCH = "exch";

	public static final String STEP = "step";

	public static final String STATUS = "status";

	public static final String GUOUPTYPE = "groupType";

	public static final String WORKTYPE = "workType";
	
	public static final String SYSAREACONFIG="sysAreaConfig";
	
	public static String STATUS_SO_PAUSE = "status_SO_PAUSE";//从status表中取

	public static String STATUS_SO_ACC_NBR = "status_SO_ACC_NBR";

	public static String STATUS_BUSINESS = "status_BUSINESS";

	public static String STATUS_SO = "status_SO";
	
	public static String STEP_TYPE_T="stepType_t";  //环节类型
	
	public static String LOCALNET_AREA_EXCH="localExch_t"; //本地网服务区局向

	public static final String STATUS_SPLIT_WORD = "||";

	public static final String STATUS_SPLIT_WORD_REGEXP = "\\u007C";

    *//**
     * Clone一个HashMap
     * 
     * @param hash
     *            HashMap
     * @throws DataCacheException
     * @return HashMap
     *//*
    private static HashMap hashClone(HashMap hash) throws DataCacheException {
        if (log.isDebugEnabled()) {
            log.debug("calling DataCache.hashClone()");
        }
        if (hash == null) {
            return null;
        }
        HashMap ret = new HashMap();
        Iterator ite = hash.keySet().iterator();
        Object key = null, keyObj = null;
        Object value = null, valueObj = null;
        try {
            while (ite.hasNext()) {
                key = ite.next();

                value = hash.get(key);
                if (key.getClass().getName().startsWith("java")) {
                    keyObj = key;
                } else {
                    try {
                        keyObj = key.getClass().newInstance();
                        PropertyUtils.copyProperties(keyObj, key);
                    } catch (Exception ex) {
                        keyObj = key;
                    }
                }

                if (value.getClass().getName().startsWith("java")) {
                    valueObj = value;
                } else {
                    try {
                        valueObj = key.getClass().newInstance();
                        PropertyUtils.copyProperties(valueObj, value);
                    } catch (Exception ex) {
                        valueObj = value;
                    }
                }
                ret.put(keyObj, valueObj);
            }
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
        return ret;
    }

    *//**
     * 获取配置表DATA_CACHE_CONFIG信息
     * 
     * @throws DataCacheException
     * @return List
     *//*
    private static List getConfigTableInfo(String tableName, String treeFlag)
            throws DataCacheException {
        List results = null;
        String psql=" select                          " +
        		    "       a.DATA_CACHE_CONFIG_ID,   " +
        		    "       a.TABLE_NAME,             " +
        		    "       a.CACHE_ID,               " +
        		    "       a.CACHE_VALUE,            " +
        		    "       a.CONDITION,              " +
        		    "       a.CONDITION_VALUE,        " +
                    "       a.ORDER_ID,               " +
                    "       a.HASH_MAP,               " +
                    "       a.STS,                    " +
                    "       a.STS_DATE,               " +
                    "       a.PARENT_ID,              " +
                    "       a.TREE_FLAG,              " +
                    "       a.REMARKS                 " +
                    " from                            " +
                    "       DATA_CACHE_CONFIG a       " +
                    "        where 1=1                ";
        StringBuffer sql = new StringBuffer(psql);
        if (tableName != null) {
            sql.append(" and a.HASH_MAP ='" + tableName + "'");
        }
        if (treeFlag != null) {
            sql.append(" and a.TREE_FLAG ='" + treeFlag + "'");
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionFactory.createConnection();
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            results = (List)ResultSetUtil.convertToList(rs, DataCacheConfigSVO.class);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("get data from DATA_CHACHE_CONFIG error");
            }
            throw new DataCacheException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps err");
                }
                throw new DataCacheException(ex);
            }
        }
        return results;
    }
    
    public  static boolean isNumber(String val){
    	boolean isNum=true;
    	if(StringUtil.isBlank(val))
    		isNum=false;
    	else{
    		int len=val.length();
    		for(int i=0;i<len;i++){
    			int c=val.charAt(i);
    			if(c<48||c>57){
    				isNum=false;
    				break;
    			}
    		}
    	}
    	return isNum;
    }

    *//**
     * 根据配置表中获取的基础表信息，读取相关的数据存储到一个hashmap，将其返回
     * 
     * @param dataConfig
     * @throws DataCacheException
     * @return HashMap
     *//*
    private static HashMap setHashMap(DataCacheConfigSVO dataConfig, String conditon,
            String conditonValue) throws DataCacheException {
        Connection connection = null;
        PreparedStatement ps = null;
        StringBuffer sql = new StringBuffer();
        sql.append("select a." + dataConfig.getCacheId() + " , a." + dataConfig.getCacheValue()
                + " from " + dataConfig.getTableName() + " a where 1=1");
        if (dataConfig.getCondition() != null) {
            sql.append(" and " + dataConfig.getCondition()); //+ "='"
                    //+ dataConfig.getConditionValue() + "' ");
        }
        if (conditon != null && isNumber(conditonValue)) {
            sql.append(" and a." + conditon + "=" + conditonValue + " ");
        }
        else if(conditon != null){
        	sql.append(" and a." + conditon + "='" + conditonValue + "'");
        }
        if (dataConfig.getOrderId() != null) {
            sql.append(" order by a." + dataConfig.getOrderId());
        }
//        if (dataConfig.getOrder() != null) {
//            sql.append(" order by a." + dataConfig.getOrder());
//        }
        ResultSet rs = null;
        HashMap hashMap = new HashMap();
        hashMap.clear();
        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                hashMap.put(rs.getString(dataConfig.getCacheId()), rs.getObject(dataConfig
                        .getCacheValue()));
            }
        } catch (SQLException ex) {
            if (log.isDebugEnabled()) {
                log.debug(ex);
            }
            throw new DataCacheException(ex);
        } catch (AppException e) {
        	if (log.isDebugEnabled()) {
                log.debug(e);
            }
            throw new DataCacheException(e);
		} catch (SysException e) {
			if (log.isDebugEnabled()) {
                log.debug(e);
            }
            throw new DataCacheException(e);
		} finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps or rs error");
                }
            }
        }

        return hashMap;
    }

    *//**
     * 根据传入的配置表ID，查找其是否存在下级表，如果存在，只返回第一个下级表
     * 
     * @param dataCacheConfigId
     * @return
     * @throws DataCacheException
     *//*
    private static DataCacheConfigSVO getChildTableInfo(String dataCacheConfigId)
            throws DataCacheException {
        DataCacheConfigSVO childTableInfo = null;
        List results = null;
        StringBuffer sql = new StringBuffer();
        sql
                .append("select a.DATA_CACHE_CONFIG_ID,a.TABLE_NAME,a.CACHE_ID,a.CACHE_VALUE, a.CONDITION,a.CONDITION_VALUE,"
                        + "a.ORDER_ID,a.HASH_MAP,a.STS,a.STS_DATE,a.PARENT_ID,a.TREE_FLAG,a.REMARKS from DATA_CACHE_CONFIG a where 1=1 ");
        if (dataCacheConfigId != null) {
            sql.append(" and a.PARENT_ID =" + dataCacheConfigId);
        }
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionFactory.createConnection();
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());

            rs = ps.executeQuery();
            results = (List) ResultSetUtil.convertToList(rs, DataCacheConfigSVO.class);
            if (results != null) {
                childTableInfo = (DataCacheConfigSVO) results.get(0);
            }
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("get data from DATA_CHACHE_CONFIG error");
            }
            throw new DataCacheException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps err");
                }
                throw new DataCacheException(ex);
            }
        }
        return childTableInfo;
    }

    *//**
     * 获取一个树型列表，根据传入的表名，查找其是否有下级列表，如果有下级列表，将该列表添加到父表的VALUE字段，生成一个树型表结构
     * 
     * @param tableName
     * @param condition
     * @param condtionValue
     * @return HashMap
     * @throws DataCacheException
     *//*
    private static HashMap getTreeHashMap(DataCacheConfigSVO parentTableInfo, String condition,
            String condtionValue) throws DataCacheException {
        HashMap parentHashMap = setHashMap(parentTableInfo, condition, condtionValue);//取下级的上级节点
        DataCacheConfigSVO childTableInfo = (DataCacheConfigSVO) getChildTableInfo(parentTableInfo
                .getDataCacheConfigId());
        if (childTableInfo != null) {
            if (parentHashMap != null && !parentHashMap.isEmpty()) {
                Iterator ite = parentHashMap.keySet().iterator();
                Object key;
                while (ite.hasNext()) {
                    key = ite.next();
                    HashMap childHashMap = getTreeHashMap(childTableInfo, parentTableInfo
                            .getCacheId(), key.toString());
                    parentHashMap.put(key.toString(), childHashMap);
                }
            }
        }
        return parentHashMap;
    }

    *//**
     * 取一个cache对象
     * 
     * @param cacheObj
     * @throws DataCacheException
     * @return HashMap
     *//*
    public static HashMap getCache(String cacheObj) throws DataCacheException {

        HashMap allObjHash = null;
        HashMap result = null;
        try {
            Field field = clazz.getDeclaredField("allHashMaps");// 获取所有hashmap集合
            allObjHash = (HashMap) field.get(null);
            result = (HashMap) allObjHash.get(cacheObj);// 根据传入参数返回指定的hashmap
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        return result;
    }

    *//**
     * 取一个cache对象
     * 
     * @param cacheObj
     * @throws DataCacheException
     * @return HashMap
     *//*
    public static HashMap getCacheClone(String cacheObj) throws DataCacheException {

        HashMap allObjHash = null;
        HashMap result = null;
        try {
            Field field = clazz.getDeclaredField("allHashMaps");// 获取所有hashmap集合
            allObjHash = (HashMap) field.get(null);
            result = (HashMap) allObjHash.get(cacheObj);// 根据传入参数返回指定的hashmap
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        return hashClone(result);
    }

    *//**
     * 取一个cache对象，使用LabelValueBean重新封装
     * 
     * @param cacheObj
     *            String 目标cache
     * @throws DataCacheException
     * @return HashMap
     *//*
    public static List getListForOption(String cacheObj) throws DataCacheException {
        HashMap objHash = null;
        try {
            objHash = getCache(cacheObj);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        List lst = new ArrayList();
        if (objHash != null && !objHash.isEmpty()) {
            Iterator ite = objHash.keySet().iterator();
            Object value, label;
            while (ite.hasNext()) {
                LabelValueBean bean = new LabelValueBean();
                value = ite.next();
                label = objHash.get(value.toString());
                bean.setLabel(label.toString());
                bean.setValue(value.toString());
                lst.add(bean);
            }
        }
        return lst;
    }

    *//**
     * 根据表名和KEY值，从cache中读取Object数据
     * 
     * @param cacheObj
     *            String 目标cache
     * @param id
     *            Object
     * @throws DataCacheException
     * @return Object
     *//*
    public static Object getObject(String cacheObj, Object id) throws DataCacheException {
        HashMap objHash = new HashMap();
        try {
            objHash = getCache(cacheObj);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        Object obj = objHash.get((String) id);
        return obj;
    }

    *//**
     * 根据表名和KEY值， 从cache中读取String数据
     * 
     * @param cacheObj
     *            String 目标cache
     * @param id
     *            Object
     * @throws DataCacheException
     * @return Object
     *//*
    public static String getString(String cacheObj, Object id) throws DataCacheException {
        HashMap objHash = new HashMap();
        try {
            objHash = getCache(cacheObj);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        String obj = (String) objHash.get((String) id);
        if (obj == null) {
            String msg = "The id[" + id + "] is not in cache object[" + cacheObj + "]";
            if (log.isDebugEnabled()) {
                log.debug(msg);
            }
        }
        return obj;
    }

    *//**
     * 从cache中读取字符串数据,当找不到这个id的时候，返回空字符串("")
     * 
     * @param cacheObj
     *            String 目标cache
     * @param id
     *            Object
     * @throws DataCacheException
     * @return Object
     *//*
    public static String getStringNoException(String cacheObj, Object id) throws DataCacheException {
        HashMap objHash = new HashMap();
        try {
            objHash = getCache(cacheObj);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("The cache Object[" + cacheObj + "] is not exist");
            }
            throw new DataCacheException(ex);
        }
        String obj = (String) objHash.get((String) id);
        if (obj == null) {
            String msg = "The id[" + id + "] is not in cache object[" + cacheObj + "]";
            if (log.isDebugEnabled()) {
                log.debug(msg);
            }
            return "";
        }
        return obj;
    }

    *//**
     * 初始化方法，根据传入的数据库表名称，读取配置表中设置的需要初始化的基础表信息，将其存入一个hashMap集
     * 
     * @param tableName
     * @param cachName
     * @throws DataCacheException
     *//*
    public static void initHashMaps(String tableName) throws DataCacheException {
        List configTablesInfo = getConfigTableInfo(tableName, null);// 获取配置表集合,如果传入null,则初始化配置表中所有数据集合
        if(configTablesInfo!=null)
        {
        	for (int i = 0; i < configTablesInfo.size(); i++) {
        		DataCacheConfigSVO configInfo = (DataCacheConfigSVO) configTablesInfo.get(i);
        		HashMap newTable = new HashMap();
        		newTable = (HashMap) allHashMaps.get((String) configInfo.getHashMap());
        		if (newTable != null) {
        			newTable.clear();
        		}
        		try {
        			newTable = setHashMap(configInfo, null, null);// 根据配置表中信息设置相应的hashMap
        			allHashMaps.put((String) configInfo.getHashMap(), (HashMap) newTable);
        		} catch (Exception ex) {
        			throw new DataCacheException(ex);
        		}
        	}
        }
    }

    *//**
     * 初始化方法，根据传入的数据库表名称，读取配置表中设置的需要初始化的基础表信息，生成一个树型HashMap，存入hashMap集
     * 
     * @param tableName，传入null表示初始化配置表中所有有级连关系的数据集合
     * @param cachName
     * @throws DataCacheException
     *//*
    public static void initTreeHashMap(String tableName) throws DataCacheException {
        if (tableName != null) {
            tableName = tableName.substring(0, tableName.lastIndexOf("_")); //表名
        }
        List configTablesInfo = getConfigTableInfo(tableName, "Y");// 获取配置表集合
        if (configTablesInfo != null) {
            for (int i = 0; i < configTablesInfo.size(); i++) {
                DataCacheConfigSVO configInfo = (DataCacheConfigSVO) configTablesInfo.get(i);
                HashMap newTable = (HashMap) allHashMaps.get(configInfo.getHashMap() + "_t");
                if (newTable != null) {
                    newTable.clear();
                }
                try {
                    newTable = getTreeHashMap(configInfo, null, null);// 根据配置表中设置获取相应的hashMap
                    allHashMaps.put(configInfo.getHashMap() + "_t", (HashMap) newTable);
                } catch (Exception ex) {
                    throw new DataCacheException(ex);
                }
            }
        }
    }

    *//**
     * 根据传入的表名，获取STATUS表中该表涉及到的数据集合，一个二级树型列表，COLUMN_NAM对应STS_ID,和STS_WORDS对应的HashMap对象
     * 
     * @param tableName,若传入null,获得STATUS表中所有数据集合
     * @return
     * @throws DataCacheException
     *//*
    private static HashMap getStatusMap(String tableName) throws DataCacheException {
        List tableInfo = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql
                .append("select a.TABLE_NAME,a.COLUMN_NAME,a.STS_ID,a.STS_WORDS,a.ORDER_ID from STATUS a where 1=1 ");
        if (tableName != null) {
            sql.append(" and a.TABLE_NAME ='" + tableName + "'");
        }
        sql.append(" order by a.ORDER_ID,a.COLUMN_NAME");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionFactory.createConnection();
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());

            rs = ps.executeQuery();
            tableInfo = (List) ResultSetUtil.convertToList(rs, StatusSVO.class);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("get data from DATA_CHACHE_CONFIG error");
            }
            throw new DataCacheException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps err");
                }
                throw new DataCacheException(ex);
            }
        }
        HashMap hashMaps = new HashMap();
        HashMap tableMap = new HashMap();
        HashMap columnMap = new HashMap();
        if (tableInfo != null) {
            for (int i = 0; i < tableInfo.size(); i++) {
                StatusSVO statusInfo = (StatusSVO) tableInfo.get(i);
                tableMap = (HashMap) hashMaps.get((String) statusInfo.getTableName());
                if (tableMap == null) {
                    HashMap newTableMap = new HashMap();
                    HashMap newColumnMap = new HashMap();
                    newColumnMap.put((String) statusInfo.getStsId(), statusInfo.getStsWords());
                    newTableMap.put((String) statusInfo.getColumnName(), newColumnMap);
                    hashMaps.put((String) statusInfo.getTableName(), newTableMap);
                } else {
                    columnMap = (HashMap) tableMap.get((String) statusInfo.getColumnName());
                    if (columnMap == null) {
                        HashMap newColumnMap = new HashMap();
                        newColumnMap.put((String) statusInfo.getStsId(), statusInfo.getStsWords());
                        tableMap.put((String) statusInfo.getColumnName(), newColumnMap);
                        hashMaps.put((String) statusInfo.getTableName(), tableMap);
                    } else {
                        columnMap.put((String) statusInfo.getStsId(), statusInfo.getStsWords());
                        tableMap.put((String) statusInfo.getColumnName(), columnMap);
                        hashMaps.put((String) statusInfo.getTableName(), tableMap);
                    }
                }
            }
        }
        return hashMaps;
    }

    *//**
     * 初始化STATUS表中指定表名的数据集合，生成一个树型HashMap，存入hashMap集
     * 
     * @param tableName
     * @throws DataCacheException
     *//*
    public static void initStatusHashMap(String tableName) throws DataCacheException {
        try {
            if (tableName != null) {
                tableName = tableName.substring(tableName.indexOf("_") + 1, tableName.length());
            }
            HashMap newTable = getStatusMap(tableName);// 根据传入的表名从STATUS表中获取相关数据集合，若传入null,则获取所有数据集合
            if (newTable != null && !newTable.isEmpty()) {
                Iterator ite = newTable.keySet().iterator();
                Object key;
                while (ite.hasNext()) {
                    key = ite.next();
                    HashMap tableMap = (HashMap) allHashMaps.get("status_" + key.toString());
                    if (tableMap != null) {
                        tableMap.clear();
                    }
                    try {
                        tableMap = (HashMap) newTable.get(key);
                        allHashMaps.put("status_" + key.toString(), (HashMap) tableMap);
                    } catch (Exception ex) {
                        throw new DataCacheException(ex);
                    }
                }
            }
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
    }

    public static void clearAllMaps() {
        allHashMaps.clear();
    }

    private static HashMap getSysConfigMap() throws DataCacheException {
        HashMap result = new HashMap();
        List tableInfo = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select a.CONFIG_ID,a.NAME,a.SYSTEM_NAME,a.CONFIG_TYPE,a.CUR_VALUE,"
                + "a.VALUE_DESC,a.CREATE_DATE from SYS_CONFIG a order by CONFIG_ID");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionFactory.createConnection();
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            tableInfo = (List) ResultSetUtil.convertToList(rs, SysConfigSVO.class);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("get data from SYS_CONFIG error");
            }
            throw new DataCacheException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps err");
                }
                throw new DataCacheException(ex);
            }
        }
        if (tableInfo != null) {
            for (int i = 0, size = tableInfo.size(); i < size; i++) {
                SysConfigSVO vo = (SysConfigSVO) tableInfo.get(i);
                result.put((String) vo.getConfigId(), (SysConfigSVO) vo);
            }
        }
        return result;
    }

    private static HashMap getSysAreaConfig() throws DataCacheException {
        List tableInfo = new ArrayList();
        StringBuffer sql = new StringBuffer();
        sql.append("select a.SYS_AREA_CONFIG_ID,a.CONFIG_ID,a.SP_AREA_ID,"
                + "a.CUR_VALUE ,a.VALUE_DESC from SYS_AREA_CONFIG a " + " order by CONFIG_ID");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ConnectionFactory.createConnection();
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());

            rs = ps.executeQuery();
            tableInfo = (List) ResultSetUtil.convertToList(rs, SysAreaConfigSVO.class);
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug("get data from SYS_AREA_CONFIG error");
            }
            throw new DataCacheException(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                if (log.isDebugEnabled()) {
                    log.debug("close ps err");
                }
                throw new DataCacheException(ex);
            }
        }
        HashMap tableMap = new HashMap();
        HashMap columnMap = new HashMap();
        if (tableInfo != null) {
            for (int i = 0, size = tableInfo.size(); i < size; i++) {
                SysAreaConfigSVO configInfo = (SysAreaConfigSVO) tableInfo.get(i);
                if (tableMap == null) {
                    HashMap newColumnMap = new HashMap();
                    newColumnMap.put((String) configInfo.getSpAreaId(), configInfo);
                    tableMap.put((String) configInfo.getConfigId(), newColumnMap);
                } else {
                    columnMap = (HashMap) tableMap.get((String) configInfo.getConfigId());
                    if (columnMap == null) {
                        HashMap newColumnMap = new HashMap();
                        newColumnMap.put((String) configInfo.getSpAreaId(), configInfo);
                        tableMap.put((String) configInfo.getConfigId(), newColumnMap);
                    } else {
                        columnMap.put((String) configInfo.getSpAreaId(), configInfo);
                        tableMap.put((String) configInfo.getConfigId(), columnMap);
                    }
                }
            }
        }
        return tableMap;
    }

    public static void initSysConfigHashMap() throws DataCacheException {
        HashMap newTable = (HashMap) allHashMaps.get(DataCache.SYSCONFIG);
//    	HashMap newTable = (HashMap) allHashMaps.get(DataCache.SYSCONFIG);
        if (newTable != null) {
            newTable.clear();
        }
        try {
            newTable = getSysConfigMap();// 根据配置表中设置获取相应的hashMap
            allHashMaps.put(DataCache.SYSCONFIG, (HashMap) newTable);
//            allHashMaps.put(DataCache.SYSCONFIG, (HashMap) newTable);
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
    }

    public static void initSysAreaConfigHashMap() throws DataCacheException {
        HashMap newTable = (HashMap) allHashMaps.get(DataCache.SYSAREACONFIG);
        if (newTable != null) {
            newTable.clear();
        }
        try {
            newTable = getSysAreaConfig();// 根据配置表中设置获取相应的hashMap
            allHashMaps.put(DataCache.SYSAREACONFIG, (HashMap) newTable);
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
    }
    
    
    
    *//**
     * 根据配置表初始化缓存信息
     * @throws DataCacheException
     *//*
    public static void initial() throws DataCacheException{
    	//对配置中所有表对应数据进行缓存
    	initHashMaps(null);
		initTreeHashMap(null);
		initStatusHashMap(null);
		initSysAreaConfigHashMap();
		initSysConfigHashMap();
    }
}*/