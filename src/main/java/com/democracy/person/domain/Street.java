package com.democracy.person.domain;

import com.democracy.person.enumerator.StreetType;
import java.io.Serializable;

public class Street implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int streetId;
    private String streetName;
    private StreetType streetType;

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public StreetType getStreetType() {
        return streetType;
    }

    public void setStreetType(StreetType streetType) {
        this.streetType = streetType;
    }
}
