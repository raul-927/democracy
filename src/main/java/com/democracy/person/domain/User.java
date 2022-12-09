package com.democracy.person.domain;

import javax.persistence.*;

/**
 * Stores information to identify the user.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String alias;

    public User(final String userAlias) {
        this(null, userAlias);
    }

    public User(Object object, String userAlias) {
        // TODO Auto-generated constructor stub
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
