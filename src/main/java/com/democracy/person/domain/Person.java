package com.democracy.person.domain;

import com.democracy.person.enumerator.DocumentTypeEnum;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private int personId;
    private DocumentTypeEnum documentType;
    private int cedula;
    private int civicCredential;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Address address;
    private Profession profession;
    private List<Qualification> qualifications;

    //private PersonType 			personType;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
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

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }
}
