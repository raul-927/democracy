package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StreetOut {
    Mono<Integer> createStreet(Street street);
    Mono<Integer> createMultipleStreet(List<Street> streetFlux);
    Mono<Integer> deleteStreet(String streetId);
    Flux<Street> selectStreet(Street street);
    Mono<Long> selectCount();
    Mono<Integer> updateStreet(Street street);
}

