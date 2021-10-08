package com.resource.democracy.domain;

import java.io.Serializable;

import com.resource.democracy.enumerator.ChargeType;

public class Charge implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		chargeId;
	private String 		chargeNom;
	private ChargeType 	chargeType;
	
	public int getChargeId() {
		return chargeId;
	}
	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
	public String getChargeNom() {
		return chargeNom;
	}
	public void setChargeNom(String chargeNom) {
		this.chargeNom = chargeNom;
	}
	public ChargeType getChargeType() {
		return chargeType;
	}
	public void setChargeType(ChargeType chargeType) {
		this.chargeType = chargeType;
	}

}
