package com.democracy.infrastructure.adapters;


import com.democracy.domain.models.Street;
import com.democracy.domain.ports.out.StreetOut;
import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class StreetAdapter implements StreetOut {



    @Override
    public Street callStreet(Street street) {
        System.out.println("EVENT in adapter: "+EventEnum.DRY);

       return street;


    }
}
