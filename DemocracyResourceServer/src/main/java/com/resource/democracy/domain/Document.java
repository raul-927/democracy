package com.resource.democracy.domain;

import java.io.Serializable;
import java.sql.Blob;

public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 	id;
	private int 	documentId;
	private String 	documentName;
	private boolean verified;
	private boolean	approved;
	private String 	observation;
	private Blob 	attached;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public Blob getAttached() {
		return attached;
	}
	public void setAttached(Blob attached) {
		this.attached = attached;
	}
	/**
	 * @return the approved
	 */
	public boolean isApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
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
	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}
	/**
	 * @param verified the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

}
