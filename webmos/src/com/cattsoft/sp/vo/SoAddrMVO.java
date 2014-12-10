package com.cattsoft.sp.vo;

public class SoAddrMVO extends SoAddrSVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4545638601181610692L;
	private String localNetName=null;
	private String areaName=null;
	private String servDeptName=null;
	private String exchName=null;
	private String qryFlag=null;
	private String azFlagName=null;
	private String twoExchFlagName=null;
	private String stsName=null;
	private String twoExchFlagDesc;
	private String azFlagDesc;
	private String changedFlagDesc;
	public String getTwoExchFlagDesc() {
		return twoExchFlagDesc;
	}
	public void setTwoExchFlagDesc(String twoExchFlagDesc) {
		this.twoExchFlagDesc = twoExchFlagDesc;
	}
	public String getAzFlagDesc() {
		return azFlagDesc;
	}
	public void setAzFlagDesc(String azFlagDesc) {
		this.azFlagDesc = azFlagDesc;
	}
	public String getChangedFlagDesc() {
		return changedFlagDesc;
	}
	public void setChangedFlagDesc(String changedFlagDesc) {
		this.changedFlagDesc = changedFlagDesc;
	}
	public String getAzFlagName() {
		return azFlagName;
	}
	public void setAzFlagName(String azFlagName) {
		this.azFlagName = azFlagName;
	}
	public String getTwoExchFlagName() {
		return twoExchFlagName;
	}
	public void setTwoExchFlagName(String twoExchFlagName) {
		this.twoExchFlagName = twoExchFlagName;
	}
	public String getStsName() {
		return stsName;
	}
	public void setStsName(String stsName) {
		this.stsName = stsName;
	}
	public String getQryFlag() {
		return qryFlag;
	}
	public void setQryFlag(String qryFlag) {
		this.qryFlag = qryFlag;
	}
	public String getLocalNetName() {
		return localNetName;
	}
	public void setLocalNetName(String localNetName) {
		this.localNetName = localNetName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getServDeptName() {
		return servDeptName;
	}
	public void setServDeptName(String servDeptName) {
		this.servDeptName = servDeptName;
	}
	public String getExchName() {
		return exchName;
	}
	public void setExchName(String exchName) {
		this.exchName = exchName;
	}

}
