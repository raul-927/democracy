package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SelectStreetIn {

    Flux<Street> selectStreet(Street street);
    Mono<Long> selectCount();
    List<Street> selectStreetSecuencia(Street street);
}
