package com.cattsoft.pub.vo;

import java.sql.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-20 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author luojia
 */
public class DataCacheConfigSVO extends GenericVO {
    private static final long serialVersionUID = 1L;

    private String dataCacheConfigId;

    private String tableName;

    private String cacheId;

    private String cacheValue;

    private String condition;

    private String conditionValue;

    private String orderId;

    private String hashMap;

    private String sts;

    private Date stsDate;

    private String treeFlag;

    private String parentId;
    private String remarks;

    public void setDataCacheConfigId(String dataCacheConfigId) {
        this.dataCacheConfigId = dataCacheConfigId;
    }

    public String getDataCacheConfigId() {
        return dataCacheConfigId;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return cacheId;
    }

    public void setCacheValue(String cacheValue) {
        this.cacheValue = cacheValue;
    }

    public String getCacheValue() {
        return cacheValue;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setHashMap(String hashMap) {
        this.hashMap = hashMap;
    }

    public String getHashMap() {
        return hashMap;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getSts() {
        return sts;
    }

    public void setStsDate(Date stsDate) {
        this.stsDate = stsDate;
    }

    public Date getStsDate() {
        return stsDate;
    }

    public void setTreeFlag(String treeFlag) {
        this.treeFlag = treeFlag;
    }

    public String getTreeFlag() {
        return treeFlag;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj != null && obj instanceof DataCacheConfigSVO) {
            DataCacheConfigSVO another = (DataCacheConfigSVO) obj;
            equals = new EqualsBuilder().append(dataCacheConfigId, another.getDataCacheConfigId())
                    .isEquals();
        }
        return equals;
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(dataCacheConfigId).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this).append("dataCacheConfigId", getDataCacheConfigId())
                .toString();
    }

}
