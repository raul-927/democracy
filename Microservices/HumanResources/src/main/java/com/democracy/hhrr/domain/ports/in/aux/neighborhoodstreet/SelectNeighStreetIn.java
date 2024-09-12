package com.democracy.hhrr.domain.ports.in.aux.neighborhoodstreet;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import reactor.core.publisher.Flux;

public interface SelectNeighStreetIn {

    Flux<NeighborhoodStreet> selectNeighStreet(NeighborhoodStreet neighborhoodStreet);
}
