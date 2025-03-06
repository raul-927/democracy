package com.democracy.infrastructure.adapters;


import com.democracy.domain.models.Street;
import com.democracy.domain.ports.out.StreetOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class StreetAdapter implements StreetOut {



    @Override
    public Mono<?> callStreet(Street street) {
       return  Mono.just(street);


    }
}
