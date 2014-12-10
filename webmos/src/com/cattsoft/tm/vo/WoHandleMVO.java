package com.cattsoft.tm.vo;

import java.util.Date;

public class WoHandleMVO extends WoHandleSVO{

	private static final long serialVersionUID = 1L;
	private String failReasonId = null;
	private Date handleDate = null;
	private String handleTypeId = null;
	private String localNetId = null;
	private String overtimeId = null;
	private String remarks = null;
	private String soNbr = null;
	private String staffId = null;
	private String wostaffId = null;
	private String woHandleId = null;
	private String woNbr = null;
	private String progress = null;
	private String handleRate = null;
	
	private String failReasonName;
	private String overTimeName;
	private String staffName;
	private String wostaffName;
	private String workareaName;
	private String localNetName;
	private String handleTypeName;
	
	private String qryFlag=null;
	
	private int flagWoNbr=0;
	
	private int flagSoNbr=0;
	
	public String getQryFlag() {
		return qryFlag;
	}
	public void setQryFlag(String qryFlag) {
		this.qryFlag = qryFlag;
	}
	public String getFailReasonName() {
		return failReasonName;
	}
	public void setFailReasonName(String failReasonName) {
		this.failReasonName = failReasonName;
	}
	public String getHandleTypeName() {
		return handleTypeName;
	}
	public void setHandleTypeName(String handleTypeName) {
		this.handleTypeName = handleTypeName;
	}
	public String getLocalNetName() {
		return localNetName;
	}
	public void setLocalNetName(String localNetName) {
		this.localNetName = localNetName;
	}
	public String getOverTimeName() {
		return overTimeName;
	}
	public void setOverTimeName(String overTimeName) {
		this.overTimeName = overTimeName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getFailReasonId() {
		return failReasonId;
	}
	public void setFailReasonId(String failReasonId) {
		this.failReasonId = failReasonId;
	}
	public Date getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	public String getHandleTypeId() {
		return handleTypeId;
	}
	public void setHandleTypeId(String handleTypeId) {
		this.handleTypeId = handleTypeId;
	}
	public String getLocalNetId() {
		return localNetId;
	}
	public void setLocalNetId(String localNetId) {
		this.localNetId = localNetId;
	}
	public String getOvertimeId() {
		return overtimeId;
	}
	public void setOvertimeId(String overtimeId) {
		this.overtimeId = overtimeId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getSoNbr() {
		return soNbr;
	}
	public void setSoNbr(String soNbr) {
		this.soNbr = soNbr;
		this.flagSoNbr=1;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getWoHandleId() {
		return woHandleId;
	}
	public void setWoHandleId(String woHandleId) {
		this.woHandleId = woHandleId;
	}
	public String getWoNbr() {
		return woNbr;
	}
	public void setWoNbr(String woNbr) {
		this.woNbr = woNbr;
		this.flagWoNbr=1;
	}
	public int getFlagSoNbr() {
		return flagSoNbr;
	}
	public void setFlagSoNbr(int flagSoNbr) {
		this.flagSoNbr = flagSoNbr;
	}
	public int getFlagWoNbr() {
		return flagWoNbr;
	}
	public void setFlagWoNbr(int flagWoNbr) {
		this.flagWoNbr = flagWoNbr;
	}
	public String getWostaffId() {
		return wostaffId;
	}
	public void setWostaffId(String wostaffId) {
		this.wostaffId = wostaffId;
	}
	public String getWostaffName() {
		return wostaffName;
	}
	public void setWostaffName(String wostaffName) {
		this.wostaffName = wostaffName;
	}
	public String getWorkareaName() {
		return workareaName;
	}
	public void setWorkareaName(String workareaName) {
		this.workareaName = workareaName;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getHandleRate() {
		return handleRate;
	}
	public void setHandleRate(String handleRate) {
		this.handleRate = handleRate;
	}
}
