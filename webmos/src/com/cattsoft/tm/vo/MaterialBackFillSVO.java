package com.cattsoft.tm.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * MaterialBackFillSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class MaterialBackFillSVO extends GenericVO {
	private String amount = null;
	private String areaId = null;
	private String backFillType = null;
	private String localNetId = null;
	private String materialId = null;
	private String materialSpecId = null;
	private String remarks = null;
	private String staffId = null;
	private String sts = null;
	private Date stsDate = null;
	private String woNbr = null;
	private int flagAmount = 0;
	private int flagAreaId = 0;
	private int flagBackFillType = 0;
	private int flagLocalNetId = 0;
	private int flagMaterialId = 0;
	private int flagMaterialSpecId = 0;
	private int flagRemarks = 0;
	private int flagStaffId = 0;
	private int flagSts = 0;
	private int flagStsDate = 0;
	private int flagWoNbr = 0;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String newValue) {
		this.amount = newValue;
		flagAmount = 1;
	}

	public int getFlagAmount() {
		return flagAmount;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String newValue) {
		this.areaId = newValue;
		flagAreaId = 1;
	}

	public int getFlagAreaId() {
		return flagAreaId;
	}

	public String getBackFillType() {
		return backFillType;
	}

	public void setBackFillType(String newValue) {
		this.backFillType = newValue;
		flagBackFillType = 1;
	}

	public int getFlagBackFillType() {
		return flagBackFillType;
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

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String newValue) {
		this.materialId = newValue;
		flagMaterialId = 1;
	}

	public int getFlagMaterialId() {
		return flagMaterialId;
	}

	public String getMaterialSpecId() {
		return materialSpecId;
	}

	public void setMaterialSpecId(String newValue) {
		this.materialSpecId = newValue;
		flagMaterialSpecId = 1;
	}

	public int getFlagMaterialSpecId() {
		return flagMaterialSpecId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String newValue) {
		this.remarks = newValue;
		flagRemarks = 1;
	}

	public int getFlagRemarks() {
		return flagRemarks;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String newValue) {
		this.staffId = newValue;
		flagStaffId = 1;
	}

	public int getFlagStaffId() {
		return flagStaffId;
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

	public String getWoNbr() {
		return woNbr;
	}

	public void setWoNbr(String newValue) {
		this.woNbr = newValue;
		flagWoNbr = 1;
	}

	public int getFlagWoNbr() {
		return flagWoNbr;
	}

	public void clearFlagAmount() {
		flagAmount = 0;
	}

	public void clearFlagAreaId() {
		flagAreaId = 0;
	}

	public void clearFlagBackFillType() {
		flagBackFillType = 0;
	}

	public void clearFlagLocalNetId() {
		flagLocalNetId = 0;
	}

	public void clearFlagMaterialId() {
		flagMaterialId = 0;
	}

	public void clearFlagMaterialSpecId() {
		flagMaterialSpecId = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagStaffId() {
		flagStaffId = 0;
	}

	public void clearFlagSts() {
		flagSts = 0;
	}

	public void clearFlagStsDate() {
		flagStsDate = 0;
	}

	public void clearFlagWoNbr() {
		flagWoNbr = 0;
	}

	public void clearAll() {
		flagAmount = 0;
		flagAreaId = 0;
		flagBackFillType = 0;
		flagLocalNetId = 0;
		flagMaterialId = 0;
		flagMaterialSpecId = 0;
		flagRemarks = 0;
		flagStaffId = 0;
		flagSts = 0;
		flagStsDate = 0;
		flagWoNbr = 0;

	}
}
