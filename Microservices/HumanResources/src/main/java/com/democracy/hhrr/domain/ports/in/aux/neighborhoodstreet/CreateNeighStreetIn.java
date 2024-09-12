package com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.models.City;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateNeighStreetIn {

    Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet);
    Mono<Integer> createMultipleNeighStreet(List<NeighborhoodStreet> neighborhoodStreetList);
}
