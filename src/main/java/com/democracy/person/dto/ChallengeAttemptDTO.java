package com.democracy.person.dto;

import javax.validation.constraints.*;

/**
 * Attempt coming from the user
 */

public class ChallengeAttemptDTO {

    Long id;

    @Min(1)
    @Max(99)
    int factorA, factorB;

    @NotBlank
    String userAlias;

    @Positive(message = "How could you possibly get a negative result here? Try again.")
    int guess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}
