package com.cattsoft.tm.vo;

public class ChgServSpecMaterialMVO extends ChgServSpecMaterialSVO {
	
	private String   meterialSnCode;
	private String   workOrder;
	
	private int flagWorkOrder = 0;
	
	public int getFlagWorkOrder() {
		return flagWorkOrder;
	}

	public String getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(String newValue) {
		this.workOrder = newValue;
		flagWorkOrder=1;
	}

	public String getMeterialSnCode() {
		return meterialSnCode;
	}

	public void setMeterialSnCode(String meterialSnCode) {
		this.meterialSnCode = meterialSnCode;
	}

	
}
