package com.resource.democracy.enumerator;

public enum PersonType {
	POSTULANT(1,"Postulant"),
	VOTER(2, "Voter");
	
	private int id;
	private String description;
	
	
	private PersonType(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}

}
