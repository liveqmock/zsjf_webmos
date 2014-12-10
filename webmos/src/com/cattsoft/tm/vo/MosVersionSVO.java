package com.cattsoft.tm.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * MosVersionSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class MosVersionSVO extends GenericVO {
	private String isForce = null;
	private Date publishDate = null;
	private String publishPath = null;
	private String remarks = null;
	private String versionDesc = null;
	private String versionId = null;
	private String versionNum = null;
	private int flagIsForce = 0;
	private int flagPublishDate = 0;
	private int flagPublishPath = 0;
	private int flagRemarks = 0;
	private int flagVersionDesc = 0;
	private int flagVersionId = 0;
	private int flagVersionNum = 0;

	public String getIsForce() {
		return isForce;
	}

	public void setIsForce(String newValue) {
		this.isForce = newValue;
		flagIsForce = 1;
	}

	public int getFlagIsForce() {
		return flagIsForce;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date newValue) {
		this.publishDate = newValue;
		flagPublishDate = 1;
	}

	public int getFlagPublishDate() {
		return flagPublishDate;
	}

	public String getPublishPath() {
		return publishPath;
	}

	public void setPublishPath(String newValue) {
		this.publishPath = newValue;
		flagPublishPath = 1;
	}

	public int getFlagPublishPath() {
		return flagPublishPath;
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

	public String getVersionDesc() {
		return versionDesc;
	}

	public void setVersionDesc(String newValue) {
		this.versionDesc = newValue;
		flagVersionDesc = 1;
	}

	public int getFlagVersionDesc() {
		return flagVersionDesc;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String newValue) {
		this.versionId = newValue;
		flagVersionId = 1;
	}

	public int getFlagVersionId() {
		return flagVersionId;
	}

	public String getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(String newValue) {
		this.versionNum = newValue;
		flagVersionNum = 1;
	}

	public int getFlagVersionNum() {
		return flagVersionNum;
	}

	public void clearFlagIsForce() {
		flagIsForce = 0;
	}

	public void clearFlagPublishDate() {
		flagPublishDate = 0;
	}

	public void clearFlagPublishPath() {
		flagPublishPath = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagVersionDesc() {
		flagVersionDesc = 0;
	}

	public void clearFlagVersionId() {
		flagVersionId = 0;
	}

	public void clearFlagVersionNum() {
		flagVersionNum = 0;
	}

	public void clearAll() {
		flagIsForce = 0;
		flagPublishDate = 0;
		flagPublishPath = 0;
		flagRemarks = 0;
		flagVersionDesc = 0;
		flagVersionId = 0;
		flagVersionNum = 0;

	}
}
