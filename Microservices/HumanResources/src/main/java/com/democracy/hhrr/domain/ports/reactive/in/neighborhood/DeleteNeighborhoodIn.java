package com.democracy.hhrr.domain.ports.reactive.in.neighborhood;

import reactor.core.publisher.Mono;

public interface DeleteNeighborhoodIn {

    Mono<Integer>deleteNeighborhood(String neighborhoodId);
}
