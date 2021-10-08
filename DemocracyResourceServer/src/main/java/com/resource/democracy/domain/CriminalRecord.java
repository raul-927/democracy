package com.resource.democracy.domain;

import java.io.Serializable;

public class CriminalRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;
	private int 	criminalRecordId;
	private String 	criminalRecordName;
	private String 	criminalRecordDescription;
	private Penal 	penal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCriminalRecordId() {
		return criminalRecordId;
	}
	public void setCriminalRecordId(int criminalRecordId) {
		this.criminalRecordId = criminalRecordId;
	}
	public String getCriminalRecordName() {
		return criminalRecordName;
	}
	public void setCriminalRecordName(String criminalRecordName) {
		this.criminalRecordName = criminalRecordName;
	}
	public String getCriminalRecordDescription() {
		return criminalRecordDescription;
	}
	public void setCriminalRecordDescription(String criminalRecordDescription) {
		this.criminalRecordDescription = criminalRecordDescription;
	}
	public Penal getPenal() {
		return penal;
	}
	public void setPenal(Penal penal) {
		this.penal = penal;
	}
	

}
