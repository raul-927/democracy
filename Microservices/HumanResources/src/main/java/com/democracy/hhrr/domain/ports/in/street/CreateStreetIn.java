package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateStreetIn {

    Mono<?> createStreet(Street street);
    Mono<?>createMultipleStreet(List<Street> streetList);


}
