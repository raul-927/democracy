package com.resource.democracy.domain;

import java.io.Serializable;

import com.resource.democracy.enumerator.StreetType;

public class Street implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 		streetId;
	private String 		streetName;
	private StreetType 	streetType;
	
	public int getStreetId() {
		return streetId;
	}
	public void setStreetId(int streetId) {
		this.streetId = streetId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public StreetType getStreetType() {
		return streetType;
	}
	public void setStreetType(StreetType streetType) {
		this.streetType = streetType;
	}
	

}
