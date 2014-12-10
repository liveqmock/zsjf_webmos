package com.cattsoft.tm.vo;

import java.sql.Blob;

import com.cattsoft.pub.vo.GenericVO;

/**
 * MosSurveySVO
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.0  2007-5-14
 * <p>Company: ´óÌÆÈí¼þ</p>
 */
public class MosSurveySVO extends GenericVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5372223801092893814L;
	private String extSoNbr = null;
	private String isExplanation = null;
	private String isFinished = null;
	private String isReverseInTime = null;
	private String isSatisfaction = null;
	private String isVisitInTime = null;
	private String mosSurveyId = null;
	private String remarks = null;
	private Blob signature = null;
	private int flagExtSoNbr = 0;
	private int flagIsExplanation = 0;
	private int flagIsFinished = 0;
	private int flagIsReverseInTime = 0;
	private int flagIsSatisfaction = 0;
	private int flagIsVisitInTime = 0;
	private int flagMosSurveyId = 0;
	private int flagRemarks = 0;
	private int flagSignature = 0;

	public String getExtSoNbr() {
		return extSoNbr;
	}

	public void setExtSoNbr(String newValue) {
		this.extSoNbr = newValue;
		flagExtSoNbr = 1;
	}

	public int getFlagExtSoNbr() {
		return flagExtSoNbr;
	}

	public String getIsExplanation() {
		return isExplanation;
	}

	public void setIsExplanation(String newValue) {
		this.isExplanation = newValue;
		flagIsExplanation = 1;
	}

	public int getFlagIsExplanation() {
		return flagIsExplanation;
	}

	public String getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(String newValue) {
		this.isFinished = newValue;
		flagIsFinished = 1;
	}

	public int getFlagIsFinished() {
		return flagIsFinished;
	}

	public String getIsReverseInTime() {
		return isReverseInTime;
	}

	public void setIsReverseInTime(String newValue) {
		this.isReverseInTime = newValue;
		flagIsReverseInTime = 1;
	}

	public int getFlagIsReverseInTime() {
		return flagIsReverseInTime;
	}

	public String getIsSatisfaction() {
		return isSatisfaction;
	}

	public void setIsSatisfaction(String newValue) {
		this.isSatisfaction = newValue;
		flagIsSatisfaction = 1;
	}

	public int getFlagIsSatisfaction() {
		return flagIsSatisfaction;
	}

	public String getIsVisitInTime() {
		return isVisitInTime;
	}

	public void setIsVisitInTime(String newValue) {
		this.isVisitInTime = newValue;
		flagIsVisitInTime = 1;
	}

	public int getFlagIsVisitInTime() {
		return flagIsVisitInTime;
	}

	public String getMosSurveyId() {
		return mosSurveyId;
	}

	public void setMosSurveyId(String newValue) {
		this.mosSurveyId = newValue;
		flagMosSurveyId = 1;
	}

	public int getFlagMosSurveyId() {
		return flagMosSurveyId;
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

	public Blob getSignature() {
		return signature;
	}

	public void setSignature(Blob newValue) {
		this.signature = newValue;
		flagSignature = 1;
	}

	public int getFlagSignature() {
		return flagSignature;
	}

	public void clearFlagExtSoNbr() {
		flagExtSoNbr = 0;
	}

	public void clearFlagIsExplanation() {
		flagIsExplanation = 0;
	}

	public void clearFlagIsFinished() {
		flagIsFinished = 0;
	}

	public void clearFlagIsReverseInTime() {
		flagIsReverseInTime = 0;
	}

	public void clearFlagIsSatisfaction() {
		flagIsSatisfaction = 0;
	}

	public void clearFlagIsVisitInTime() {
		flagIsVisitInTime = 0;
	}

	public void clearFlagMosSurveyId() {
		flagMosSurveyId = 0;
	}

	public void clearFlagRemarks() {
		flagRemarks = 0;
	}

	public void clearFlagSignature() {
		flagSignature = 0;
	}

	public void clearAll() {
		flagExtSoNbr = 0;
		flagIsExplanation = 0;
		flagIsFinished = 0;
		flagIsReverseInTime = 0;
		flagIsSatisfaction = 0;
		flagIsVisitInTime = 0;
		flagMosSurveyId = 0;
		flagRemarks = 0;
		flagSignature = 0;

	}
}
