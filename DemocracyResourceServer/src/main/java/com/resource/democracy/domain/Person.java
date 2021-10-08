package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

import com.resource.democracy.enumerator.PersonType;

public class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 	   			id;
	private int 	   			personId;
	private int 	   			cedula;
	private int					civicCredential;
	private String 	   			firstName;
	private String 	   			secondName;
	private String 	   			firstLastName;
	private String 	   			secondLastName;
	private List<Qualification> qualifications;
	private Address    			adress;
	private Profession 			profession;

	private PersonType 			personType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public PersonType getPersonType() {
		return personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}


	/**
	 * @return the civicCredential
	 */
	public int getCivicCredential() {
		return civicCredential;
	}

	/**
	 * @param civicCredential the civicCredential to set
	 */
	public void setCivicCredential(int civicCredential) {
		this.civicCredential = civicCredential;
	}

	/**
	 * @return the qualifications
	 */
	public List<Qualification> getQualifications() {
		return qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	
	
}
