package com.cattsoft.tm.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * ChgServSpecMaterialSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class ChgServSpecMaterialSVO extends GenericVO {
	private String areaId = null;
	private String chgServSpecId = null;
	private String chgSpecMateId = null;
	private String localNetId = null;
	private String materialId = null;
	private String prodId = null;
	private String remarks = null;
	private String sts = null;
	private Date stsDate = null;
	private int flagAreaId = 0;
	private int flagChgServSpecId = 0;
	private int flagChgSpecMateId = 0;
	private int flagLocalNetId = 0;
	private int flagMaterialId = 0;
	private int flagProdId = 0;
	private int flagRemarks = 0;
	private int flagSts = 0;
	private int flagStsDate = 0;

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

	public String getChgServSpecId() {
		return chgServSpecId;
	}

	public void setChgServSpecId(String newValue) {
		this.chgServSpecId = newValue;
		flagChgServSpecId = 1;
	}

	public int getFlagChgServSpecId() {
		return flagChgServSpecId;
	}

	public String getChgSpecMateId() {
		return chgSpecMateId;
	}

	public void setChgSpecMateId(String newValue) {
		this.chgSpecMateId = newValue;
		flagChgSpecMateId = 1;
	}

	public int getFlagChgSpecMateId() {
		return flagChgSpecMateId;
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

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String newValue) {
		this.prodId = newValue;
		flagProdId = 1;
	}

	public int getFlagProdId() {
		return flagProdId;
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

	public void clearFlagAreaId() {
		flagAreaId = 0;
	}

	public void clearFlagChgServSpecId() {
		flagChgServSpecId = 0;
	}

	public void clearFlagChgSpecMateId() {
		flagChgSpecMateId = 0;
	}

	public void clearFlagLocalNetId() {
		flagLocalNetId = 0;
	}

	public void clearFlagMaterialId() {
		flagMaterialId = 0;
	}

	public void clearFlagProdId() {
		flagProdId = 0;
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

	public void clearAll() {
		flagAreaId = 0;
		flagChgServSpecId = 0;
		flagChgSpecMateId = 0;
		flagLocalNetId = 0;
		flagMaterialId = 0;
		flagProdId = 0;
		flagRemarks = 0;
		flagSts = 0;
		flagStsDate = 0;

	}
}
