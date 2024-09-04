package com.democracy.hhrr.domain.ports.in.street;

import reactor.core.publisher.Mono;

public interface DeleteStreetIn {

    Mono<Integer> deleteStreet(String streetId);
}
