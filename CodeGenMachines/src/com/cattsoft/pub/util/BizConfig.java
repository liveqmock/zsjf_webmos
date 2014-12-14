/*package com.cattsoft.pub.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.sm.vo.StatusSVO;

public class BizConfig {
	*//**
     * 根据表名、列名取得该列的所有类型对象。
     * 
     * @param tabName
     * @param colName
     * @return
     * @throws DataCacheException
     *//*
    public static List getStatusSVOLst(String tabName, String colName) throws DataCacheException {
        if (tabName == null || colName == null) {
            return null;
        }
        List voList = new ArrayList();
        try {
            HashMap tableMap = (HashMap) DataCache.getCache("status_" + tabName);
            if (tableMap != null) {
                HashMap columnMap = (HashMap) tableMap.get(colName);
                if (columnMap != null) {
                    Iterator ite = columnMap.keySet().iterator();
                    Object key, value;
                    int orderId = 1;
                    while (ite.hasNext()) {
                        StatusSVO vo = new StatusSVO();
                        vo.setColumnName(colName);
                        vo.setTableName(tabName);
                        vo.setOrderId(String.valueOf(orderId));
                        key = ite.next();
                        value = columnMap.get(key);
                        vo.setStsId(key.toString());
                        vo.setStsWords(value.toString());
                        voList.add(vo);
                        orderId++;
                    }
                }
            }
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
        return voList;
    }

    *//**
     * 根据表名、列名取得该列的所有类型对象。
     * 
     * @param tabName
     * @param colName
     * @return
     * @throws DataCacheException
     *//*
    public static HashMap getStatusHashMap(String tabName, String colName)
            throws DataCacheException {
        if (tabName == null || colName == null) {
            return null;
        }
        HashMap result = new HashMap();
        try {
            HashMap tableMap = (HashMap) DataCache.getCache("status_" + tabName);
            if (tableMap != null) {
                result = (HashMap) tableMap.get(colName);
            }
        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
        return result;
    }
}
*/