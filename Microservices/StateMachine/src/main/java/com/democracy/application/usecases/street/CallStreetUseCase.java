package com.democracy.application.usecases.street;

import com.democracy.domain.models.Street;
import com.democracy.domain.ports.in.CallStreetIn;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import com.democracy.domain.ports.out.StreetOut;

@Component
public class CallStreetUseCase implements CallStreetIn {





    @Override
    public Mono<?> callStreet(Street street) {
        return null;
    }

}
