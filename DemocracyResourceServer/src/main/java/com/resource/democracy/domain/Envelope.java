package com.resource.democracy.domain;

import java.io.Serializable;

public class Envelope implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;
	private int 	envelopeId;
	private long 	envelopeNumber;
	private int 	credential;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnvelopeId() {
		return envelopeId;
	}
	public void setEnvelopeId(int envelopeId) {
		this.envelopeId = envelopeId;
	}
	public long getEnvelopeNumber() {
		return envelopeNumber;
	}
	public void setEnvelopeNumber(long envelopeNumber) {
		this.envelopeNumber = envelopeNumber;
	}
	public int getCredential() {
		return credential;
	}
	public void setCredential(int credential) {
		this.credential = credential;
	}
	

}
