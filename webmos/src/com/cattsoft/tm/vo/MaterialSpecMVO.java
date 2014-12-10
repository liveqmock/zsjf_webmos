package com.cattsoft.tm.vo;

public class MaterialSpecMVO extends MaterialSpecSVO {
   
	private int amount=0;
	private int flagAmount = 0;
	
	public int getFlagAmount() {
		return flagAmount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int newValue) {
		this.amount = newValue;
		flagAmount = 1;
	}
}
