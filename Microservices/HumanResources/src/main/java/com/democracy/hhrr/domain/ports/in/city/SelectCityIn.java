package com.democracy.hhrr.domain.ports.in.city;

import com.democracy.hhrr.domain.models.City;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectCityIn {

    Flux<City> selectCity(City city);
    Mono<Long> selectCount();
    Flux<City> selectAllCity();
}
