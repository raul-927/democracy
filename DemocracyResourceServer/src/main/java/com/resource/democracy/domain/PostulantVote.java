package com.resource.democracy.domain;

import java.io.Serializable;

public class PostulantVote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	  id;
	private int 	  voteId;
	private Postulant postulant;
	private Envelope  envelope;
	private boolean   approved;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
		public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	/**
	 * @return the envelope
	 */
	public Envelope getEnvelope() {
		return envelope;
	}
	/**
	 * @param envelope the envelope to set
	 */
	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}
	public Postulant getPostulant() {
		return postulant;
	}
	public void setPostulant(Postulant postulant) {
		this.postulant = postulant;
	}
	
	

}
