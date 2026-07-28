package com.democracy.hhrr.domain.ports.reactive.in.street;

import reactor.core.publisher.Mono;

public interface DeleteStreetIn {

    Mono<Integer> deleteStreet(String streetId);
}
