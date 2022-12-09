package com.resource.democracy.domain;

import java.io.Serializable;

public class Score implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int    id;
	private int    scoreId;
	private int    score;
	private Person person;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

}
