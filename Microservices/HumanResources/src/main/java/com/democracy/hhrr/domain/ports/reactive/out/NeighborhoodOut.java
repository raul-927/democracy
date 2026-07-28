package com.democracy.hhrr.domain.ports.reactive.out;

import com.democracy.hhrr.domain.models.Neighborhood;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NeighborhoodOut {
    Mono<Integer> createNeighborhood(Neighborhood neighborhood);
    Mono<Integer>createMultipleNeighborhood(List<Neighborhood> neighborhoodList);
    Mono<Integer>deleteNeighborhood(String neighborhoodId);
    Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood);
    Flux<Neighborhood> selectAllNeighborhood();
    Mono<Long> selectCount();
    Mono<Integer> updateNeighborhood(Neighborhood neighborhood);
}
