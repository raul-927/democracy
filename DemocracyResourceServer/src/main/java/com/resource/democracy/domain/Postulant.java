package com.resource.democracy.domain;

import java.io.Serializable;
import java.util.List;

public class Postulant implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int 		id;
	private int 		postulantId;
	private List<Score> scores;
	private Charge 		charge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostulantId() {
		return postulantId;
	}
	public void setPostulantId(int postulantId) {
		this.postulantId = postulantId;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public Charge getCharge() {
		return charge;
	}
	public void setCharge(Charge charge) {
		this.charge = charge;
	}
	
}
