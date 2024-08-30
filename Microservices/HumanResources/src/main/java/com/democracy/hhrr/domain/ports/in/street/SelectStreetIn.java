package com.democracy.hhrr.domain.ports.in.street;

import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Flux;

public interface SelectStreetIn {

    Flux<Street> selectStreet(Street street);
}
