package com.democracy.person.domain;

import java.io.Serializable;
import java.sql.Blob;

public class Attached implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private int attachedId;
    private Blob attachedFile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttachedId() {
        return attachedId;
    }

    public void setAttachedId(int attachedId) {
        this.attachedId = attachedId;
    }

    public Blob getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(Blob attachedFile) {
        this.attachedFile = attachedFile;
    }
}
