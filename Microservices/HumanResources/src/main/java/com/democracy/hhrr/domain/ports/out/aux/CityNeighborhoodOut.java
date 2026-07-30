package com.democracy.hhrr.domain.ports.out.aux;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CityNeighborhoodOut {

    Mono<Integer> createCityNeigh(CityNeighborhood cityNeighborhood);
    Mono<Integer> createMultipleCityNeigh(List<CityNeighborhood> cityNeighborhoodList);
}
