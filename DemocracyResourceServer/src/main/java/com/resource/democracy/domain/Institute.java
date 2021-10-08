package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

public class Institute implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		   instituteId;
	private String 		   instituteName;
	private Address 	   adress;
	
	
	public int getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
}
