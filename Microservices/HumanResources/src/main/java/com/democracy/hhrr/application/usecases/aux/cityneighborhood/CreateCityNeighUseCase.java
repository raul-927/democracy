package com.democracy.hhrr.application.usecases.aux.cityneighborhood;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.ports.in.aux.cityneighborhood.CreateCityNeighborhoodIn;
import com.democracy.hhrr.domain.ports.out.aux.CityNeighborhoodOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateCityNeighUseCase implements CreateCityNeighborhoodIn {

    private final CityNeighborhoodOut cityNeighborhoodOut;

    public CreateCityNeighUseCase(CityNeighborhoodOut cityNeighborhoodOut) {
        this.cityNeighborhoodOut = cityNeighborhoodOut;
    }

    @Override
    public Mono<Integer> createCityNeigh(CityNeighborhood cityNeighborhood) {
        return this.cityNeighborhoodOut.createCityNeigh(cityNeighborhood);
    }

    @Override
    public Mono<Integer> createMultipleCityNeigh(List<CityNeighborhood> cityNeighborhoodList) {
        return this.cityNeighborhoodOut.createMultipleCityNeigh(cityNeighborhoodList);
    }
}
