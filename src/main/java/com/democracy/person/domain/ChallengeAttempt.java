package com.democracy.person.domain;

import javax.persistence.*;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */

public class ChallengeAttempt {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;

    public ChallengeAttempt(Object object, User user2, int factorA2, int factorB2, int guess, boolean isCorrect) {
        // TODO Auto-generated constructor stub
    }

    public ChallengeAttempt() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFactorA() {
        return factorA;
    }

    public void setFactorA(int factorA) {
        this.factorA = factorA;
    }

    public int getFactorB() {
        return factorB;
    }

    public void setFactorB(int factorB) {
        this.factorB = factorB;
    }

    public int getResultAttempt() {
        return resultAttempt;
    }

    public void setResultAttempt(int resultAttempt) {
        this.resultAttempt = resultAttempt;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
