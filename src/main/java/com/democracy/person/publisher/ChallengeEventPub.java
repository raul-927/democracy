package com.democracy.person.publisher;

import com.democracy.person.domain.ChallengeAttempt;
import com.democracy.person.events.ChallengeSolvedEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChallengeEventPub {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${amqp.exchange.attempts}")
    private String challengesTopicExchange;

    public void challengeSolved(final ChallengeAttempt challengeAttempt) {
        ChallengeSolvedEvent event = buildEvent(challengeAttempt);
        // Routing Key is 'attempt.correct' or 'attempt.wrong'
        String routingKey = "attempt." + (event.isCorrect() ? "correct" : "wrong");
        amqpTemplate.convertAndSend(challengesTopicExchange, routingKey, event);
    }

    private ChallengeSolvedEvent buildEvent(final ChallengeAttempt attempt) {
        return new ChallengeSolvedEvent(
            attempt.getId(),
            attempt.isCorrect(),
            attempt.getFactorA(),
            attempt.getFactorB(),
            attempt.getUser().getId(),
            attempt.getUser().getAlias()
        );
    }
}
