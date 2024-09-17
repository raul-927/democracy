package com.democracy.hhrr.infrastructure.adapters.aux;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.domain.ports.out.aux.neighborhoodstreet.NeighborhoodStreetOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.NeighborhoodStreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class NeighborhoodStreetAdapter implements NeighborhoodStreetOut {

    @Autowired
    private NeighborhoodStreetMapper neighborhoodStreetMapper;

    @Override
    public Mono<Integer> createNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }

    @Override
    public Mono<Integer> createMultipleNeighStreet(List<NeighborhoodStreet> neighborhoodStreetList) {
        return this.neighborhoodStreetMapper.insertMultiple(neighborhoodStreetList);
    }

    @Override
    public Mono<Integer> deleteNeighStreet(String id) {
        return null;
    }

    @Override
    public Flux<NeighborhoodStreet> selectNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }

    @Override
    public Mono<Integer> updateNeighStreet(NeighborhoodStreet neighborhoodStreet) {
        return null;
    }
}
