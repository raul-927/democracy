package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.out.CityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CityAdapter implements CityOut {
    @Override
    public Mono<Integer> createCity(City city) {
        return null;
    }

    @Override
    public Mono<Integer> createMultipleCity(List<City> cityList) {
        return null;
    }

    @Override
    public Mono<Integer> deleteCity(String id) {
        return null;
    }

    @Override
    public Flux<City> selectCity(City city) {
        return null;
    }

    @Override
    public Mono<Long> selectCount() {
        return null;
    }

    @Override
    public Mono<Integer> updateCity(City city) {
        return null;
    }
}
