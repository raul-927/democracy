package com.democracy.hhrr.application.usecases.aux.neighborhoodstreet;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet.CreateNeighStreetIn;
import com.democracy.hhrr.domain.ports.out.aux.neighborhoodstreet.NeighborhoodStreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateNeighStreetUseCase implements CreateNeighStreetIn {

    private final NeighborhoodStreetOut neighborhoodStreetOut;

    public CreateNeighStreetUseCase(NeighborhoodStreetOut neighborhoodStreetOut) {
        this.neighborhoodStreetOut = neighborhoodStreetOut;
    }


    @Override
    public Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return this.neighborhoodStreetOut.createNeighStreet(neighborhoodStreet);
    }

    @Override
    public Mono<Integer> createMultipleNeighStreet(List<NeighborhoodStreet> neighborhoodStreetList) {
        return null;
    }
}
