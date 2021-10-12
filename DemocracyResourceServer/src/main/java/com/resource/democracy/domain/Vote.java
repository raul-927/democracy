package com.resource.democracy.domain;

import java.io.Serializable;

public class Vote implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	 id;
	private int 	 voteId;
	private Law 	 law;
	private Envelope envelope;
	private boolean  approved;
	
	
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
	public Law getLaw() {
		return law;
	}
	public void setLaw(Law law) {
		this.law = law;
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
	
	

}
