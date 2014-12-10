package com.cattsoft.tm.vo;

import java.io.Serializable;
import java.util.Date;

public class RealPosition implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -142096052884693316L;

	private Integer id;

	private Integer terminalId;

	private Integer terminalType;

	private String mobileNbr;

	private String receiveTime;

	private Double longTitude;// 经度

	private Double laTitude;// 纬度

	private Double altitude;// 高度

	private Double vilocity;// 速度

	private Double angle;// 方向

	private Integer state;// 状态
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Integer terminalId) {
		this.terminalId = terminalId;
	}

	public Integer getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(Integer terminalType) {
		this.terminalType = terminalType;
	}

	public String getMobileNbr() {
		return mobileNbr;
	}

	public void setMobileNbr(String mobileNbr) {
		this.mobileNbr = mobileNbr;
	}


	public Double getLongTitude() {
		return longTitude;
	}

	public void setLongTitude(Double longTitude) {
		this.longTitude = longTitude;
	}

	public Double getLaTitude() {
		return laTitude;
	}

	public void setLaTitude(Double laTitude) {
		this.laTitude = laTitude;
	}

	public Double getAltitude() {
		return altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}

	public Double getVilocity() {
		return vilocity;
	}

	public void setVilocity(Double vilocity) {
		this.vilocity = vilocity;
	}

	public Double getAngle() {
		return angle;
	}

	public void setAngle(Double angle) {
		this.angle = angle;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

}
