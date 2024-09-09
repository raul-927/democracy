package com.democracy.hhrr.domain.ports.in.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import reactor.core.publisher.Mono;

public interface UpdateNeighborhoodIn {

    Mono<Integer>updateNeighborhood(Neighborhood neighborhood);
}
