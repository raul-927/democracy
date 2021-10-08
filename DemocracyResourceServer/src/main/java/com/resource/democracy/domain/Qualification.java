package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

public class Qualification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 			id;
	private int 			qualificationId;
	private Institute 		institute;
	private Person 			person;
	private List<Document> 	documents;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	
	


}
