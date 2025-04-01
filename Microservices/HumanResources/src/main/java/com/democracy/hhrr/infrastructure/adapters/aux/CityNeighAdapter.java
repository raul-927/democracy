package com.democracy.hhrr.infrastructure.adapters.aux;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.ports.out.aux.cityneighborhood.CityNeighborhoodOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux.CityNeighborhoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class CityNeighAdapter implements CityNeighborhoodOut {


    @Autowired
    private CityNeighborhoodMapper  cityNeighborhoodMapper;


    @Override
    public Mono<Integer> createCityNeigh(CityNeighborhood cityNeighborhood) {
        return this.cityNeighborhoodMapper.insert(cityNeighborhood);
    }

    @Override
    public Mono<Integer> createMultipleCityNeigh(List<CityNeighborhood> cityNeighborhoodList) {
        return this.cityNeighborhoodMapper.insertMultiple(cityNeighborhoodList);
    }
}
