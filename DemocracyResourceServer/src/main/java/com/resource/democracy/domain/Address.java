package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 			id;
	private int 			addressId;
	private Neighborhood 	neighborhood;
	private String 			geoLocation;
	private int 			adressNumber;
	private List<Street> 	streets;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Neighborhood getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}
	public int getAdressNumber() {
		return adressNumber;
	}
	public void setAdressNumber(int adressNumber) {
		this.adressNumber = adressNumber;
	}
	public List<Street> getStreets() {
		return streets;
	}
	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}
	
	
	
	
	
	

}
