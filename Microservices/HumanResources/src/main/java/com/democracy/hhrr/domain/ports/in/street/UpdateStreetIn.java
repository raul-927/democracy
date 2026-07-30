package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Mono;

public interface UpdateStreetIn {
    Mono<Integer> updateStreet(Street street);
}
