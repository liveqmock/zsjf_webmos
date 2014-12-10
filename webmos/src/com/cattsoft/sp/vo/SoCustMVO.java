package com.cattsoft.sp.vo;

public class SoCustMVO extends SoCustSVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7957195580427210163L;
	private String qryFlag=null;
	public String getQryFlag() {
		return qryFlag;
	}
	public void setQryFlag(String qryFlag) {
		this.qryFlag = qryFlag;
	}
	private String stsName=null;
	private String azFlagName=null;
	private String importFlagName=null;
	private String custLevelName=null;
	private String custVocaName=null;
	private String custCatName=null;
	private String certTypeName=null;
	private String importFlagDesc;
	public String getImportFlagDesc() {
		return importFlagDesc;
	}
	public void setImportFlagDesc(String importFlagDesc) {
		this.importFlagDesc = importFlagDesc;
	}
	public String getCustLevelName() {
		return custLevelName;
	}
	public void setCustLevelName(String custLevelName) {
		this.custLevelName = custLevelName;
	}
	public String getCustVocaName() {
		return custVocaName;
	}
	public void setCustVocaName(String custVocaName) {
		this.custVocaName = custVocaName;
	}
	public String getCustCatName() {
		return custCatName;
	}
	public void setCustCatName(String custCatName) {
		this.custCatName = custCatName;
	}
	public String getCertTypeName() {
		return certTypeName;
	}
	public void setCertTypeName(String certTypeName) {
		this.certTypeName = certTypeName;
	}
	public String getStsName() {
		return stsName;
	}
	public void setStsName(String stsName) {
		this.stsName = stsName;
	}
	public String getAzFlagName() {
		return azFlagName;
	}
	public void setAzFlagName(String azFlagName) {
		this.azFlagName = azFlagName;
	}
	public String getImportFlagName() {
		return importFlagName;
	}
	public void setImportFlagName(String importFlagName) {
		this.importFlagName = importFlagName;
	}
	
}
