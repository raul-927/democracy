package com.democracy.person.events;

public class ChallengeSolvedEvent {

    long attemptId;
    boolean correct;
    int factorA;
    int factorB;
    long userId;
    String userAlias;

    public ChallengeSolvedEvent(Long iattemptId, boolean correct, int factorA, int factorB, Long userId, String alias) {
        this.attemptId = attemptId;
        this.correct = correct;
        this.factorA = factorA;
        this.factorB = factorB;
        this.userId = userId;
        this.userAlias = userAlias;
    }

    public long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(long attemptId) {
        this.attemptId = attemptId;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }
}
