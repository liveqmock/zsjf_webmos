package com.cattsoft.tm.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * MosCallLogSVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class MosCallLogSVO extends GenericVO {
	private Date bookTime = null;
	private String calledPhoneNo = null;
	private String callerPhoneNo = null;
	private String callDuration = null;
	private Date endTime = null;
	private String mosCallLogId = null;
	private String remarks = null;
	private Date startTime = null;
	private String woNbr = null;
	private int flagBookTime = 0;
	private int flagCalledPhoneNo = 0;
	private int flagCallerPhoneNo = 0;
	private int flagCallDuration = 0;
	private int flagEndTime = 0;
	private int flagMosCallLogId = 0;
	private int flagRemarks = 0;
	private int flagStartTime = 0;
	private int flagWoNbr = 0;

	public Date getBookTime() {
		return bookTime;
	}

	public void setBookTime(Date newValue) {
		this.bookTime = newValue;
		flagBookTime = 1;
	}

	public int getFlagBookTime() {
		return flagBookTime;
	}

	public String getCalledPhoneNo() {
		return calledPhoneNo;
	}

	public void setCalledPhoneNo(String newValue) {
		this.calledPhoneNo = newValue;
		flagCalledPhoneNo = 1;
	}

	public int getFlagCalledPhoneNo() {
		return flagCalledPhoneNo;
	}

	public String getCallerPhoneNo() {
		return callerPhoneNo;
	}

	public void setCallerPhoneNo(String newValue) {
		this.callerPhoneNo = newValue;
		flagCallerPhoneNo = 1;
	}

	public int getFlagCallerPhoneNo() {
		return flagCallerPhoneNo;
	}

	public String getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(String newValue) {
		this.callDuration = newValue;
		flagCallDuration = 1;
	}

	public int getFlagCallDuration() {
		return flagCallDuration;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date newValue) {
		this.endTime = newValue;
		flagEndTime = 1;
	}

	public int getFlagEndTime() {
		return flagEndTime;
	}

	public String getMosCallLogId() {
		return mosCallLogId;
	}

	public void setMosCallLogId(String newValue) {
		this.mosCallLogId = newValue;
		flagMosCallLogId = 1;
	}

	public int getFlagMosCallLogId() {
		return flagMosCallLogId;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date newValue) {
		this.startTime = newValue;
		flagStartTime = 1;
	}

	public int getFlagStartTime() {
		return flagStartTime;
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

	public void clearFlagBookTime() {
		flagBookTime = 0;
	}

	public void clearFlagCalledPhoneNo() {
		flagCalledPhoneNo = 0;
	}

	public void clearFlagCallerPhoneNo() {
		flagCallerPhoneNo = 0;
	}

	public void clearFlagCallDuration() {
		flagCallDuration = 0;
	}

	public void clearFlagEndTime() {
		flagEndTime = 0;
	}

	public void clearFlagMosCallLogId() {
		flagMosCallLogId = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagStartTime() {
		flagStartTime = 0;
	}

	public void clearFlagWoNbr() {
		flagWoNbr = 0;
	}

	public void clearAll() {
		flagBookTime = 0;
		flagCalledPhoneNo = 0;
		flagCallerPhoneNo = 0;
		flagCallDuration = 0;
		flagEndTime = 0;
		flagMosCallLogId = 0;
		flagRemarks = 0;
		flagStartTime = 0;
		flagWoNbr = 0;

	}
}
