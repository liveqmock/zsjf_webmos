package com.cattsoft.tm.vo;


import java.util.Date;

//import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.vo.GenericVO;

public class SimpleQueryMVO extends GenericVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1774130312047904321L;


//	private static final Logger log = Logger.getLogger(SimpleQueryMVO.class);

	
	private String localNetId;

	private String areaId;
	
	private String workAreaId;
	
	private String chbWorkAreaId;
	
	//施工方式
	private String workMode;

	private Date startRunStsDate;

	private Date endRunStsDate;

	private String extSoNbr;
	
	private String soNbr;

	private String accNbr;

	private String stepId;

	private String tabId;

	private String servDept;
	
	private String checkRange;
	
	private String chbServDept;
	
	private String chbLocalNetId;

	private String chbAreaId;

	private String chbStsDate;

	private String chbExtSoNbr;
	
	private String chbSoNbr;

	private String chbAccNbr;

	private String chbStepId;

	private String chbTabId;
	
	private String chbCheckRange;

	private Date startAsgnDate;

	private Date endAsgnDate;

	private String chbAsgnDate;
	
	private Date startBusiStsDate;

	private Date endBusiStsDate;
	
	private String chbCoNbr;
	
	private String coNbr;
	

	public String getChbStepId() {
		return chbStepId;
	}

	public void setChbStepId(String chbStepId) {
		this.chbStepId = chbStepId;
	}

	public String getChbTabId() {
		return chbTabId;
	}

	public void setChbTabId(String chbTabId) {
		this.chbTabId = chbTabId;
	}

	public String getAccNbr() {
		return accNbr;
	}

	public void setAccNbr(String accNbr) {
		this.accNbr = accNbr;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public Date getEndRunStsDate() {
		return endRunStsDate;
	}

	public void setEndRunStsDate(Date endRunStsDate) {
		this.endRunStsDate = endRunStsDate;
	}

	public String getEndRunStsDateStr() {
		String str = "";
		if (null != this.endRunStsDate) {
			str = DateUtil.to_char(endRunStsDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setEndRunStsDateStr(String endRunStsDateStr) throws SysException, AppException {
		if (!StringUtil.isBlank(endRunStsDateStr)) {
			this.endRunStsDate = DateUtil.to_date(endRunStsDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.endRunStsDate = null;
	}
	public Date getEndBusiStsDate() {
		return endBusiStsDate;
	}

	public void setEndBusiStsDate(Date endBusiStsDate) {
		this.endBusiStsDate = endBusiStsDate;
	}
	
	public String getEndBusiStsDateStr() {
		String str = "";
		if (null != this.endBusiStsDate) {
			str = DateUtil.to_char(endBusiStsDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setEndBusiStsDateStr(String endBusiStsDateStr) throws SysException, AppException {
		if (!StringUtil.isBlank(endBusiStsDateStr)) {
			this.endBusiStsDate = DateUtil.to_date(endBusiStsDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.endBusiStsDate = null;
	}
	public String getLocalNetId() {
		return localNetId;
	}

	public void setLocalNetId(String localNetId) {
		this.localNetId = localNetId;
	}

	public String getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(String soNbr) {
		this.soNbr = soNbr;
	}

	public Date getStartRunStsDate() {
		return startRunStsDate;
	}

	public void setStartRunStsDate(Date startRunStsDate) {
		this.startRunStsDate = startRunStsDate;
	}

	public String getStartRunStsDateStr() {
		String str = "";
		if (null != this.startRunStsDate) {
			str = DateUtil.to_char(startRunStsDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setStartRunStsDateStr(String startRunStsDateStr) throws SysException, AppException {
		if (!StringUtil.isBlank(startRunStsDateStr)) {
			this.startRunStsDate = DateUtil.to_date(startRunStsDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.startRunStsDate = null;
	}
	public Date getStartBusiStsDate() {
		return startBusiStsDate;
	}

	public void setStartBusiStsDate(Date startBusiStsDate) {
		this.startBusiStsDate = startBusiStsDate;
	}

	public String getStartBusiStsDateStr() {
		String str = "";
		if (null != this.startBusiStsDate) {
			str = DateUtil.to_char(startBusiStsDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setStartBusiStsDateStr(String startBusiStsDateStr) throws SysException, AppException {
		if (!StringUtil.isBlank(startBusiStsDateStr)) {
			this.startBusiStsDate = DateUtil.to_date(startBusiStsDateStr, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.startBusiStsDate = null;
	}
	public String getStepId() {
		return stepId;
	}

	public void setStepId(String stepId) {
		this.stepId = stepId;
	}

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public void setChbAccNbr(String chbAccNbr) {
		this.chbAccNbr = chbAccNbr;
	}

	public void setChbAreaId(String chbAreaId) {
		this.chbAreaId = chbAreaId;
	}

	public void setChbLocalNetId(String chbLocalNetId) {
		this.chbLocalNetId = chbLocalNetId;
	}

	public void setChbSoNbr(String chbSoNbr) {
		this.chbSoNbr = chbSoNbr;
	}

	public void setChbStsDate(String chbStsDate) {
		this.chbStsDate = chbStsDate;
	}

	public String getChbAccNbr() {
		return chbAccNbr;
	}

	public String getChbAreaId() {
		return chbAreaId;
	}

	public String getChbLocalNetId() {
		return chbLocalNetId;
	}

	public String getChbSoNbr() {
		return chbSoNbr;
	}

	public String getChbStsDate() {
		return chbStsDate;
	}

	public String getChbAsgnDate() {
		return chbAsgnDate;
	}

	public void setChbAsgnDate(String chbAsgnDate) {
		this.chbAsgnDate = chbAsgnDate;
	}

	public Date getStartAsgnDate() {
		return startAsgnDate;
	}

	public Date getEndAsgnDate() {
		return endAsgnDate;
	}

	public String getStartAsgnDateStr() {
		String str = "";
		if (null != this.startAsgnDate) {
			str = DateUtil.to_char(startAsgnDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setStartAsgnDateStr(String startAsgnDate) throws SysException, AppException {
		if (!StringUtil.isBlank(startAsgnDate)) {
			this.startAsgnDate = DateUtil.to_date(startAsgnDate, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.startAsgnDate = null;
	}

	public void setEndAsgnDate(Date endAsgnDate) {
		this.endAsgnDate = endAsgnDate;
	}

	public void setStartAsgnDate(Date startAsgnDate) {
		this.startAsgnDate = startAsgnDate;
	}

	public String getEndAsgnDateStr() {
		String str = "";
		if (null != this.endAsgnDate) {
			str = DateUtil.to_char(endAsgnDate, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	public void setEndAsgnDateStr(String endAsgnDate) throws SysException, AppException {
		if (!StringUtil.isBlank(endAsgnDate)) {
			this.endAsgnDate = DateUtil.to_date(endAsgnDate, "yyyy-MM-dd HH:mm:ss");
			return;
		}
		this.endAsgnDate = null;
	}

	public String getWorkMode() {
		return workMode;
	}

	public void setWorkMode(String workMode) {
		this.workMode = workMode;
	}

	public String getChbExtSoNbr() {
		return chbExtSoNbr;
	}

	public void setChbExtSoNbr(String chbExtSoNbr) {
		this.chbExtSoNbr = chbExtSoNbr;
	}

	public String getExtSoNbr() {
		return extSoNbr;
	}

	public void setExtSoNbr(String extSoNbr) {
		this.extSoNbr = extSoNbr;
	}

	public String getChbServDept() {
		return chbServDept;
	}

	public void setChbServDept(String chbServDept) {
		this.chbServDept = chbServDept;
	}

	public String getServDept() {
		return servDept;
	}

	public void setServDept(String servDept) {
		this.servDept = servDept;
	}

	public String getChbCheckRange() {
		return chbCheckRange;
	}

	public void setChbCheckRange(String chbCheckRange) {
		this.chbCheckRange = chbCheckRange;
	}

	public String getCheckRange() {
		return checkRange;
	}

	public void setCheckRange(String checkRange) {
		this.checkRange = checkRange;
	}

	public String getWorkAreaId() {
		return workAreaId;
	}

	public void setWorkAreaId(String workAreaId) {
		this.workAreaId = workAreaId;
	}

	public String getChbWorkAreaId() {
		return chbWorkAreaId;
	}

	public void setChbWorkAreaId(String chbWorkAreaId) {
		this.chbWorkAreaId = chbWorkAreaId;
	}

	public String getChbCoNbr() {
		return chbCoNbr;
	}

	public void setChbCoNbr(String chbCoNbr) {
		this.chbCoNbr = chbCoNbr;
	}

	public String getCoNbr() {
		return coNbr;
	}

	public void setCoNbr(String coNbr) {
		this.coNbr = coNbr;
	}

}
