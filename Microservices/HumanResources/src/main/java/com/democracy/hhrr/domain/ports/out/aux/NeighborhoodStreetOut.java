package com.democracy.hhrr.domain.ports.out.aux;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NeighborhoodStreetOut {

    Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet);
    Mono<Integer> createMultipleNeighStreet(List<NeighborhoodStreet> neighborhoodStreetList);
    Mono<Integer> deleteNeighStreet(String id);
    Flux<NeighborhoodStreet> selectNeighStreet(NeighborhoodStreet neighborhoodStreet);
    Mono<Integer> updateNeighStreet(NeighborhoodStreet neighborhoodStreet);
}
