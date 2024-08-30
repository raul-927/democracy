package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Mono;

public interface CreateStreetIn {

    Mono<Street> createStreet(Street street);


}
