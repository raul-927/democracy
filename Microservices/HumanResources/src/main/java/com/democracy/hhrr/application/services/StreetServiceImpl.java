package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Street;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StreetServiceImpl implements StreetService{

    


    @Override
    public Mono<Street> createStreet(Street street) {
        return null;
    }

    @Override
    public void deleteStreet(String streetId) {

    }

    @Override
    public Flux<Street> selectStreet(Street street) {
        return null;
    }

    @Override
    public Mono<Street> updateStreet(Street street) {
        return null;
    }
}
