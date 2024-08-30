package com.democracy.acl.domain.models.enums;

import java.io.Serializable;

public enum RolesEnum implements Serializable{
	ADMIN(1, "ROLE_ADMIN"),
	USER(2, "ROLE_USER"),
	COUNTER(3, "ROLE_COUNTER"),
	SALES(4, "ROLE_SALES"),
	GUESS(5,"ROLE_GUESS"),
	ANONIMOUS(6,"ROLE_ANONIMOUS"),
	MARKETING(7, "ROLE_MARKETING"),
	RRHH(8,"ROLE_RRHH"),
	PROMOUTION(9, "ROLE_PROMOUTION"),
	CONFIG(10, "ROLE_CONFIG");
	
	private int rolId;
	private final String descripcion;
	
	
	private RolesEnum(int rolId, final String descripcion) {
		this.rolId = rolId;
		this.descripcion = descripcion;
	}
	
	
	public int getRolId() {
		return this.rolId;
	}
	
	public final String getDescripcion() {
		return this.descripcion;
	}


	public String getAsString() {
		return this.rolId+"-"+this.descripcion;
	}

}
