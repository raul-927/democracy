package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.Date;

public class Law implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;
	private int 	lawId;
	private int		lawNumber;
	private String  lawText;
	private Date	promulgation;
	private String 	lawDescription;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLawId() {
		return lawId;
	}
	public void setLawId(int lawId) {
		this.lawId = lawId;
	}
	public int getLawNumber() {
		return lawNumber;
	}
	public void setLawNumber(int lawNumber) {
		this.lawNumber = lawNumber;
	}
	public String getLawText() {
		return lawText;
	}
	public void setLawText(String lawText) {
		this.lawText = lawText;
	}
	public Date getPromulgation() {
		return promulgation;
	}
	public void setPromulgation(Date promulgation) {
		this.promulgation = promulgation;
	}
	public String getLawDescription() {
		return lawDescription;
	}
	public void setLawDescription(String lawDescription) {
		this.lawDescription = lawDescription;
	}

}
