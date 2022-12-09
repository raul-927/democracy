package com.democracy.person.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

public class Document implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private int documentId;
    private String documentName;
    private boolean verified;
    private boolean approved;
    private String observation;
    private List<Attached> attacheds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * @return the approved
     */
    public boolean isApproved() {
        return approved;
    }

    /**
     * @param approved the approved to set
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * @return the verified
     */
    public boolean isVerified() {
        return verified;
    }

    /**
     * @param verified the verified to set
     */
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    /**
     * @return the attacheds
     */
    public List<Attached> getAttacheds() {
        return attacheds;
    }

    /**
     * @param attacheds the attacheds to set
     */
    public void setAttacheds(List<Attached> attacheds) {
        this.attacheds = attacheds;
    }
}
