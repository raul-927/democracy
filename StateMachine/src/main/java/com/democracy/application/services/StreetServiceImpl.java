package com.democracy.application.services;

import com.democracy.domain.models.Street;
import com.democracy.domain.ports.in.CallStreetIn;
import com.democracy.infrastructure.events.EventEnum;
import com.democracy.infrastructure.satates.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreetServiceImpl implements StreetService{
    private final CallStreetIn callStreetIn;


    public StreetServiceImpl(CallStreetIn callStreetIn) {
        this.callStreetIn = callStreetIn;
    }
    @Override
    public Street callStreet(Street street) {
         return this.callStreetIn.callStreet(street);
    }

}
