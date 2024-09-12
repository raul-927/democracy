package com.democracy.hhrr.infrastructure.adapters.aux;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.ports.out.aux.neighborhoodstreet.NeighborhoodStreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class NeighborhoodStreetAdapter implements NeighborhoodStreetOut {


    @Override
    public Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }

    @Override
    public Mono<Integer> deleteNeighStreet(String id) {
        return null;
    }

    @Override
    public Flux<NeighborhoodStreet> selectNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }

    @Override
    public Mono<Integer> updateNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }
}
