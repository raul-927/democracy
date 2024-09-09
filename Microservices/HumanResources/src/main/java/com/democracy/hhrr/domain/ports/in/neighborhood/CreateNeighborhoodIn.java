package com.democracy.hhrr.domain.ports.in.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateNeighborhoodIn {

    Mono<Integer> createNeighborhood(Neighborhood neighborhood);
    Mono<Integer>createMultipleNeighborhood(List<Neighborhood> neighborhoodList);
}
