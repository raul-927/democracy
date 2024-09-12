package com.democracy.hhrr.domain.ports.in.city;

import com.democracy.hhrr.domain.models.City;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateCityIn {

    Mono<Integer> createCity(City city);
    Mono<Integer> createMultipleCity(List<City> cityList);
}
