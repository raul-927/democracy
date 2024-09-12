package com.democracy.hhrr.domain.ports.in.city;

import com.democracy.hhrr.domain.models.City;
import reactor.core.publisher.Mono;

public interface UpdateCityIn {

    Mono<Integer> updateCity(City city);
}
