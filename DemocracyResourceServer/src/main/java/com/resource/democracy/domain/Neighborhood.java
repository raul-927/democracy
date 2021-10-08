package com.resource.democracy.domain;

import java.io.Serializable;

public class Neighborhood implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 		id;
	private int 		neighborhoodId;
	private String 		neighborhoodName;
	private Department 	department;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNeighborhoodId() {
		return neighborhoodId;
	}
	public void setNeighborhoodId(int neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}
	public String getNeighborhoodName() {
		return neighborhoodName;
	}
	public void setNeighborhoodName(String neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
