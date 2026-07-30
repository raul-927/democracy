package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.ports.in.aux.cityneighborhood.CreateCityNeighborhoodIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CityNeighborhoodServiceImpl implements CityNeighborhoodService{

    private final CreateCityNeighborhoodIn createCityNeighborhoodIn;

    public CityNeighborhoodServiceImpl(CreateCityNeighborhoodIn createCityNeighborhoodIn) {
        this.createCityNeighborhoodIn = createCityNeighborhoodIn;
    }

    @Override
    public Mono<Integer> createCityNeigh(CityNeighborhood cityNeighborhood) {
        return this.createCityNeighborhoodIn.createCityNeigh(cityNeighborhood);
    }

    @Override
    public Mono<Integer> createMultipleCityNeigh(List<CityNeighborhood> cityNeighborhoodList) {
        return this.createCityNeighborhoodIn.createMultipleCityNeigh(cityNeighborhoodList);
    }
}
