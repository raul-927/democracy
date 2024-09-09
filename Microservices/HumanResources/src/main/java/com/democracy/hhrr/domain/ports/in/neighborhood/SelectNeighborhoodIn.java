package com.democracy.hhrr.domain.ports.in.neighborhood;

import com.democracy.hhrr.domain.models.Neighborhood;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectNeighborhoodIn {

    Flux<Neighborhood>selectNeighborhood(Neighborhood neighborhood);
    Mono<Long>selectCount();
}
