package com.democracy.person.domain;

import javax.persistence.*;

/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */

public class ChallengeAttempt {

    private Long id;

    private User user;

    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean isCorrect;
    private int guess;

    //private Object object;

    public ChallengeAttempt(User user, int factorA, int factorB, int guess, boolean isCorrect) {
        this.user = user;
        this.factorA = factorA;
        this.factorB = factorB;
        this.isCorrect = isCorrect;
        this.guess = guess;
        //this.object = object;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
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
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
