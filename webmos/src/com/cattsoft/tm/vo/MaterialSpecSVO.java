package com.cattsoft.tm.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * MaterialSpecSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class MaterialSpecSVO extends GenericVO {
	private String brand = null;
	private String capacity = null;
	private String managePattern = null;
	private String materialCode = null;
	private String materialModel = null;
	private String materialSpecId = null;
	private String materialType = null;
	private String meterialSnCode = null;
	private String name = null;
	private String needFlag = null;
	private String remarks = null;
	private String sts = null;
	private Date stsDate = null;
	private String unitId = null;
	private String usedUnitId = null;
	private int flagBrand = 0;
	private int flagCapacity = 0;
	private int flagManagePattern = 0;
	private int flagMaterialCode = 0;
	private int flagMaterialModel = 0;
	private int flagMaterialSpecId = 0;
	private int flagMaterialType = 0;
	private int flagMeterialSnCode = 0;
	private int flagName = 0;
	private int flagNeedFlag = 0;
	private int flagRemarks = 0;
	private int flagSts = 0;
	private int flagStsDate = 0;
	private int flagUnitId = 0;
	private int flagUsedUnitId = 0;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String newValue) {
		this.brand = newValue;
		flagBrand = 1;
	}

	public int getFlagBrand() {
		return flagBrand;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String newValue) {
		this.capacity = newValue;
		flagCapacity = 1;
	}

	public int getFlagCapacity() {
		return flagCapacity;
	}

	public String getManagePattern() {
		return managePattern;
	}

	public void setManagePattern(String newValue) {
		this.managePattern = newValue;
		flagManagePattern = 1;
	}

	public int getFlagManagePattern() {
		return flagManagePattern;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String newValue) {
		this.materialCode = newValue;
		flagMaterialCode = 1;
	}

	public int getFlagMaterialCode() {
		return flagMaterialCode;
	}

	public String getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(String newValue) {
		this.materialModel = newValue;
		flagMaterialModel = 1;
	}

	public int getFlagMaterialModel() {
		return flagMaterialModel;
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

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String newValue) {
		this.materialType = newValue;
		flagMaterialType = 1;
	}

	public int getFlagMaterialType() {
		return flagMaterialType;
	}

	public String getMeterialSnCode() {
		return meterialSnCode;
	}

	public void setMeterialSnCode(String newValue) {
		this.meterialSnCode = newValue;
		flagMeterialSnCode = 1;
	}

	public int getFlagMeterialSnCode() {
		return flagMeterialSnCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String newValue) {
		this.name = newValue;
		flagName = 1;
	}

	public int getFlagName() {
		return flagName;
	}

	public String getNeedFlag() {
		return needFlag;
	}

	public void setNeedFlag(String newValue) {
		this.needFlag = newValue;
		flagNeedFlag = 1;
	}

	public int getFlagNeedFlag() {
		return flagNeedFlag;
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

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String newValue) {
		this.unitId = newValue;
		flagUnitId = 1;
	}

	public int getFlagUnitId() {
		return flagUnitId;
	}

	public String getUsedUnitId() {
		return usedUnitId;
	}

	public void setUsedUnitId(String newValue) {
		this.usedUnitId = newValue;
		flagUsedUnitId = 1;
	}

	public int getFlagUsedUnitId() {
		return flagUsedUnitId;
	}

	public void clearFlagBrand() {
		flagBrand = 0;
	}

	public void clearFlagCapacity() {
		flagCapacity = 0;
	}

	public void clearFlagManagePattern() {
		flagManagePattern = 0;
	}

	public void clearFlagMaterialCode() {
		flagMaterialCode = 0;
	}

	public void clearFlagMaterialModel() {
		flagMaterialModel = 0;
	}

	public void clearFlagMaterialSpecId() {
		flagMaterialSpecId = 0;
	}

	public void clearFlagMaterialType() {
		flagMaterialType = 0;
	}

	public void clearFlagMeterialSnCode() {
		flagMeterialSnCode = 0;
	}

	public void clearFlagName() {
		flagName = 0;
	}

	public void clearFlagNeedFlag() {
		flagNeedFlag = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagSts() {
		flagSts = 0;
	}

	public void clearFlagStsDate() {
		flagStsDate = 0;
	}

	public void clearFlagUnitId() {
		flagUnitId = 0;
	}

	public void clearFlagUsedUnitId() {
		flagUsedUnitId = 0;
	}

	public void clearAll() {
		flagBrand = 0;
		flagCapacity = 0;
		flagManagePattern = 0;
		flagMaterialCode = 0;
		flagMaterialModel = 0;
		flagMaterialSpecId = 0;
		flagMaterialType = 0;
		flagMeterialSnCode = 0;
		flagName = 0;
		flagNeedFlag = 0;
		flagRemarks = 0;
		flagSts = 0;
		flagStsDate = 0;
		flagUnitId = 0;
		flagUsedUnitId = 0;

	}
}
