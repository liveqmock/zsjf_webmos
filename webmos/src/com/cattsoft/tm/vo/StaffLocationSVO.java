package com.cattsoft.tm.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * StaffLocationSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class StaffLocationSVO extends GenericVO {
	private static final long serialVersionUID = 6518553128315431131L;
	private Date createTime = null;
	private String location = null;
	private String remarks = null;
	private String staffId = null;
	private String staffLocatioinId = null;
	private String sts = null;
	private Date stsDate = null;
	private int flagCreateTime = 0;
	private int flagLocation = 0;
	private int flagRemarks = 0;
	private int flagStaffId = 0;
	private int flagStaffLocatioinId = 0;
	private int flagSts = 0;
	private int flagStsDate = 0;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date newValue) {
		this.createTime = newValue;
		flagCreateTime = 1;
	}

	public int getFlagCreateTime() {
		return flagCreateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String newValue) {
		this.location = newValue;
		flagLocation = 1;
	}

	public int getFlagLocation() {
		return flagLocation;
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

	public String getStaffLocatioinId() {
		return staffLocatioinId;
	}

	public void setStaffLocatioinId(String newValue) {
		this.staffLocatioinId = newValue;
		flagStaffLocatioinId = 1;
	}

	public int getFlagStaffLocatioinId() {
		return flagStaffLocatioinId;
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

	public void clearFlagCreateTime() {
		flagCreateTime = 0;
	}

	public void clearFlagLocation() {
		flagLocation = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagStaffId() {
		flagStaffId = 0;
	}

	public void clearFlagStaffLocatioinId() {
		flagStaffLocatioinId = 0;
	}

	public void clearFlagSts() {
		flagSts = 0;
	}

	public void clearFlagStsDate() {
		flagStsDate = 0;
	}

	public void clearAll() {
		flagCreateTime = 0;
		flagLocation = 0;
		flagRemarks = 0;
		flagStaffId = 0;
		flagStaffLocatioinId = 0;
		flagSts = 0;
		flagStsDate = 0;

	}
}
