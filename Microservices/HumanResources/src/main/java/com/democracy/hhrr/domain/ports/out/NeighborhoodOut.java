package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.models.Street;
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
