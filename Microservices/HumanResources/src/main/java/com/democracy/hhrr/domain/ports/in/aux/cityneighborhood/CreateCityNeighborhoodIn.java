package com.democracy.hhrr.domain.ports.in.aux.cityneighborhood;


import com.democracy.hhrr.domain.aux.CityNeighborhood;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateCityNeighborhoodIn {

    Mono<Integer> createCityNeigh(CityNeighborhood cityNeighborhood);
    Mono<Integer> createMultipleCityNeigh(List<CityNeighborhood> cityNeighborhoodList);

}
