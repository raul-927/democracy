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

}
