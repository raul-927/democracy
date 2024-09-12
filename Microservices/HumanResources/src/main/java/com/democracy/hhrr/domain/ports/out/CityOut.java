package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CityOut {

    Mono<Integer> createCity(City city);
    Mono<Integer> createMultipleCity(List<City> cityList);
    Mono<Integer> deleteCity(String id);
    Flux<City> selectCity(City city);
    Mono<Long> selectCount();
    Mono<Integer> updateCity(City city);
}
