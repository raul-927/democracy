package com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import reactor.core.publisher.Mono;

public interface CreateNeighStreetIn {

    Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet);
}
