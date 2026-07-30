package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectStreetIn {

    Flux<Street> selectStreet(Street street);
    Mono<Long> selectCount();
}
