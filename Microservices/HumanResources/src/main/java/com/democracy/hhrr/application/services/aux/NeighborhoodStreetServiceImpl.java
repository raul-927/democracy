package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet.CreateNeighStreetIn;
import com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet.DeleteNeighStreetIn;
import com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet.SelectNeighStreetIn;
import com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet.UpdateNeighStreetIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class NeighborhoodStreetServiceImpl implements NeighborhoodStreetService{
    private final CreateNeighStreetIn createNeighStreetIn;

    public NeighborhoodStreetServiceImpl(CreateNeighStreetIn createNeighStreetIn) {
        this.createNeighStreetIn = createNeighStreetIn;
    }

    @Override
    public Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return this.createNeighStreetIn.createNeighStreet(neighborhoodStreet);
    }

    @Override
    public Mono<Integer> createMultipleNeighStreet(List<NeighborhoodStreet> neighborhoodStreetList) {
        return this.createNeighStreetIn.createMultipleNeighStreet(neighborhoodStreetList);
    }

}
