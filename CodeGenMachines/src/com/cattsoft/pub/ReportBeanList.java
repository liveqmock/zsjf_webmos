package com.cattsoft.pub;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cattsoft.pub.exception.SysException;

/**
 * 
 * Title: ����ͨϵͳ<br>
 * Description: <br>
 * Date: 2007-6-9 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class ReportBeanList {
	private List beanList = new ArrayList();
	private String[] title ;
	
	private String[] columnName;
	private String[] columnLabel;
	

	public String[] getColumnLabel() {
		return columnLabel;
	}


	public void setColumnLabel(String[] columnLabel) {
		this.columnLabel = columnLabel;
	}


	public String[] getColumnName() {
		return columnName;
	}


	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}


	/**
	 * ����ResultSet�ļ�¼����map����ʽ����list��
	 * @param rs
	 * @throws SysException 
	 */
	public void populate(ResultSet rs) throws SysException{
		if(null == rs) return;
		
		
		try {
			Map aBean = null;
			String columnName;
			
			while(rs.next()){
				ResultSetMetaData mtd = rs.getMetaData();
				int count = mtd.getColumnCount();
				aBean = new HashMap();
				for(int i=1;i<=count;i++){
					
					columnName = mtd.getColumnName(i);
					aBean.put(columnName, rs.getString(columnName));
				}
				beanList.add(aBean);
			}
		} catch (SQLException e) {
			throw new SysException("","���������ע�䵽ReportBeanListʱ����",e);
		}
		
	}


	public List getBeanList() {
		return beanList;
	}


	public void setBeanList(List beanList) {
		this.beanList = beanList;
	}


	public String[] getTitle() {
		return title;
	}


	public void setTitle(String[] title) {
		this.title = title;
	}
	

	
	
	
	
	

}
