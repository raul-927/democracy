package com.resource.democracy.domain;

import java.io.Serializable;

public class Penal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int penalId;
	private String penalName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPenalId() {
		return penalId;
	}
	public void setPenalId(int penalId) {
		this.penalId = penalId;
	}
	public String getPenalName() {
		return penalName;
	}
	public void setPenalName(String penalName) {
		this.penalName = penalName;
	}
	

}
