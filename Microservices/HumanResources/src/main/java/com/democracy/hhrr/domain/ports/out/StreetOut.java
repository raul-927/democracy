package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StreetOut {
    Mono<Street> createStreet(Street street);
    void deleteStreet(String streetId);
    Flux<Street> selectStreet(Street street);
    Mono<Street> updateStreet(Street street);
}
