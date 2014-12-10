package com.cattsoft.sp.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * SoCustSVO
 * 
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.1 2007-9-23
 *          <p>
 *          Company: ´óÌÆÈí¼þ
 *          </p>
 */
public class SoCustSVO extends GenericVO {
	private static final long serialVersionUID = -1304569587175618118L;

	private String actType = null;

	private String azFlag = null;

	private String certCode = null;

	private String certTypeId = null;

	private String contactInfo = null;

	private String contactName = null;

	private String custCatId = null;

	private String custId = null;

	private String custLevelId = null;

	private String custName = null;

	private String custSource = null;

	private String custVocaId = null;

	private String importFlag = null;

	private String localNetId = null;

	private String noFlag = null;

	private String parentCustId = null;

	private String parentCustName = null;

	private String soCustId = null;

	private String soNbr = null;

	private String sts = null;

	private Date stsDate = null;

	private String woAction = null;

	private int flagActType = 0;

	private int flagAzFlag = 0;

	private int flagCertCode = 0;

	private int flagCertTypeId = 0;

	private int flagContactInfo = 0;

	private int flagContactName = 0;

	private int flagCustCatId = 0;

	private int flagCustId = 0;

	private int flagCustLevelId = 0;

	private int flagCustName = 0;

	private int flagCustSource = 0;

	private int flagCustVocaId = 0;

	private int flagImportFlag = 0;

	private int flagLocalNetId = 0;

	private int flagNoFlag = 0;

	private int flagParentCustId = 0;

	private int flagParentCustName = 0;

	private int flagSoCustId = 0;

	private int flagSoNbr = 0;

	private int flagSts = 0;

	private int flagStsDate = 0;

	private int flagWoAction = 0;

	public String getActType() {
		return actType;
	}

	public void setActType(String newValue) {
		this.actType = newValue;
		flagActType = 1;
	}

	public int getFlagActType() {
		return flagActType;
	}

	public String getAzFlag() {
		return azFlag;
	}

	public void setAzFlag(String newValue) {
		this.azFlag = newValue;
		flagAzFlag = 1;
	}

	public int getFlagAzFlag() {
		return flagAzFlag;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String newValue) {
		this.certCode = newValue;
		flagCertCode = 1;
	}

	public int getFlagCertCode() {
		return flagCertCode;
	}

	public String getCertTypeId() {
		return certTypeId;
	}

	public void setCertTypeId(String newValue) {
		this.certTypeId = newValue;
		flagCertTypeId = 1;
	}

	public int getFlagCertTypeId() {
		return flagCertTypeId;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String newValue) {
		this.contactInfo = newValue;
		flagContactInfo = 1;
	}

	public int getFlagContactInfo() {
		return flagContactInfo;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String newValue) {
		this.contactName = newValue;
		flagContactName = 1;
	}

	public int getFlagContactName() {
		return flagContactName;
	}

	public String getCustCatId() {
		return custCatId;
	}

	public void setCustCatId(String newValue) {
		this.custCatId = newValue;
		flagCustCatId = 1;
	}

	public int getFlagCustCatId() {
		return flagCustCatId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String newValue) {
		this.custId = newValue;
		flagCustId = 1;
	}

	public int getFlagCustId() {
		return flagCustId;
	}

	public String getCustLevelId() {
		return custLevelId;
	}

	public void setCustLevelId(String newValue) {
		this.custLevelId = newValue;
		flagCustLevelId = 1;
	}

	public int getFlagCustLevelId() {
		return flagCustLevelId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String newValue) {
		this.custName = newValue;
		flagCustName = 1;
	}

	public int getFlagCustName() {
		return flagCustName;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String newValue) {
		this.custSource = newValue;
		flagCustSource = 1;
	}

	public int getFlagCustSource() {
		return flagCustSource;
	}

	public String getCustVocaId() {
		return custVocaId;
	}

	public void setCustVocaId(String newValue) {
		this.custVocaId = newValue;
		flagCustVocaId = 1;
	}

	public int getFlagCustVocaId() {
		return flagCustVocaId;
	}

	public String getImportFlag() {
		return importFlag;
	}

	public void setImportFlag(String newValue) {
		this.importFlag = newValue;
		flagImportFlag = 1;
	}

	public int getFlagImportFlag() {
		return flagImportFlag;
	}

	public String getLocalNetId() {
		return localNetId;
	}

	public void setLocalNetId(String newValue) {
		this.localNetId = newValue;
		flagLocalNetId = 1;
	}

	public int getFlagLocalNetId() {
		return flagLocalNetId;
	}

	public String getNoFlag() {
		return noFlag;
	}

	public void setNoFlag(String newValue) {
		this.noFlag = newValue;
		flagNoFlag = 1;
	}

	public int getFlagNoFlag() {
		return flagNoFlag;
	}

	public String getParentCustId() {
		return parentCustId;
	}

	public void setParentCustId(String newValue) {
		this.parentCustId = newValue;
		flagParentCustId = 1;
	}

	public int getFlagParentCustId() {
		return flagParentCustId;
	}

	public String getParentCustName() {
		return parentCustName;
	}

	public void setParentCustName(String newValue) {
		this.parentCustName = newValue;
		flagParentCustName = 1;
	}

	public int getFlagParentCustName() {
		return flagParentCustName;
	}

	public String getSoCustId() {
		return soCustId;
	}

	public void setSoCustId(String newValue) {
		this.soCustId = newValue;
		flagSoCustId = 1;
	}

	public int getFlagSoCustId() {
		return flagSoCustId;
	}

	public String getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(String newValue) {
		this.soNbr = newValue;
		flagSoNbr = 1;
	}

	public int getFlagSoNbr() {
		return flagSoNbr;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String newValue) {
		this.sts = newValue;
		flagSts = 1;
	}

	public int getFlagSts() {
		return flagSts;
	}

	public Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(Date newValue) {
		this.stsDate = newValue;
		flagStsDate = 1;
	}

	public int getFlagStsDate() {
		return flagStsDate;
	}

	public String getWoAction() {
		return woAction;
	}

	public void setWoAction(String newValue) {
		this.woAction = newValue;
		flagWoAction = 1;
	}

	public int getFlagWoAction() {
		return flagWoAction;
	}

	public void clearFlagActType() {
		flagActType = 0;
	}

	public void clearFlagAzFlag() {
		flagAzFlag = 0;
	}

	public void clearFlagCertCode() {
		flagCertCode = 0;
	}

	public void clearFlagCertTypeId() {
		flagCertTypeId = 0;
	}

	public void clearFlagContactInfo() {
		flagContactInfo = 0;
	}

	public void clearFlagContactName() {
		flagContactName = 0;
	}

	public void clearFlagCustCatId() {
		flagCustCatId = 0;
	}

	public void clearFlagCustId() {
		flagCustId = 0;
	}

	public void clearFlagCustLevelId() {
		flagCustLevelId = 0;
	}

	public void clearFlagCustName() {
		flagCustName = 0;
	}

	public void clearFlagCustSource() {
		flagCustSource = 0;
	}

	public void clearFlagCustVocaId() {
		flagCustVocaId = 0;
	}

	public void clearFlagImportFlag() {
		flagImportFlag = 0;
	}

	public void clearFlagLocalNetId() {
		flagLocalNetId = 0;
	}

	public void clearFlagNoFlag() {
		flagNoFlag = 0;
	}

	public void clearFlagParentCustId() {
		flagParentCustId = 0;
	}

	public void clearFlagParentCustName() {
		flagParentCustName = 0;
	}

	public void clearFlagSoCustId() {
		flagSoCustId = 0;
	}

	public void clearFlagSoNbr() {
		flagSoNbr = 0;
	}

	public void clearFlagSts() {
		flagSts = 0;
	}

	public void clearFlagStsDate() {
		flagStsDate = 0;
	}

	public void clearFlagWoAction() {
		flagWoAction = 0;
	}

	public void clearAll() {
		flagActType = 0;
		flagAzFlag = 0;
		flagCertCode = 0;
		flagCertTypeId = 0;
		flagContactInfo = 0;
		flagContactName = 0;
		flagCustCatId = 0;
		flagCustId = 0;
		flagCustLevelId = 0;
		flagCustName = 0;
		flagCustSource = 0;
		flagCustVocaId = 0;
		flagImportFlag = 0;
		flagLocalNetId = 0;
		flagNoFlag = 0;
		flagParentCustId = 0;
		flagParentCustName = 0;
		flagSoCustId = 0;
		flagSoNbr = 0;
		flagSts = 0;
		flagStsDate = 0;
		flagWoAction = 0;

	}
}
