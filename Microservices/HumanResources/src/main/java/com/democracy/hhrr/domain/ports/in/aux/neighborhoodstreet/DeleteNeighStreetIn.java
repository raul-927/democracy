package com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet;

import reactor.core.publisher.Mono;

public interface DeleteNeighStreetIn {

    Mono<Integer> deleteNeighStreet(String id);

}
