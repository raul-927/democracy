package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

public class Investigation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 				  id;
	private int 				  investigationId;
	private Person 				  person;
	private List<CriminalRecord>  criminalRecords;
	private List<Qualification>   qualifications;
	private String 				  observation;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvestigationId() {
		return investigationId;
	}
	public void setInvestigationId(int investigationId) {
		this.investigationId = investigationId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<CriminalRecord> getCriminalRecords() {
		return criminalRecords;
	}
	public void setCriminalRecords(List<CriminalRecord> criminalRecords) {
		this.criminalRecords = criminalRecords;
	}
	public List<Qualification> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}
	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	} 

}
