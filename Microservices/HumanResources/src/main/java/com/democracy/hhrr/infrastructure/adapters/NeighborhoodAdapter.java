package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.domain.ports.out.NeighborhoodOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.NeighborhoodMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux.NeighborhoodStreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class NeighborhoodAdapter implements NeighborhoodOut {

    @Autowired
    private NeighborhoodMapper neighborhoodMapper;



    @Autowired
    private NeighborhoodStreetMapper neighborhoodStreetMapper;

    @Override
    public Mono<Integer> createNeighborhood(Neighborhood neighborhood) {
        return neighborhoodMapper.insert(neighborhood);
    }

    @Override
    public Mono<Integer> createMultipleNeighborhood(List<Neighborhood> neighborhoodList) {
        return neighborhoodMapper.insertMultiple(neighborhoodList);
    }

    @Override
    public Mono<Integer> deleteNeighborhood(String neighborhoodId) {
        return neighborhoodMapper.deleteNeighborhood(neighborhoodId);
    }

    @Override
    public Flux<Neighborhood> selectAllNeighborhood() {
        return neighborhoodMapper.selectAllNeighborhood();
    }

    @Override
    public Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood) {
        return neighborhoodMapper.selectNeighborhood(neighborhood);
    }

    @Override
    public Mono<Long> selectCount() {
        return neighborhoodMapper.count();
    }

    @Override
    public Mono<Integer> updateNeighborhood(Neighborhood neighborhood) {
        return neighborhoodMapper.updateSelectiveByPrimaryKey(neighborhood);
    }
}
