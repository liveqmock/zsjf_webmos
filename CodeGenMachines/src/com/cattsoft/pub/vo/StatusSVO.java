package com.cattsoft.pub.vo;


/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-7-27 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author luojia
 */
public class StatusSVO extends GenericVO {
    private static final long serialVersionUID = 1L;

    private String tableName;

    private String columnName;

    private String stsId;

    private String stsWords;

    private String orderId;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setcolumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getcolumnName() {
        return columnName;
    }

    public void setStsId(String stsId) {
        this.stsId = stsId;
    }

    public String getStsId() {
        return stsId;
    }

    public void setStsWords(String stsWords) {
        this.stsWords = stsWords;
    }

    public String getStsWords() {
        return stsWords;
    }

    public void setOderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

}
