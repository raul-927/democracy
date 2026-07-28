package com.democracy.hhrr.domain.ports.reactive.in.city;

import reactor.core.publisher.Mono;

public interface DeleteCityIn {

    Mono<Integer> deleteCity(String id);
}
