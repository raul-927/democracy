package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class StreetAdapter implements StreetOut {

    @Autowired
    private StreetMapper streetMapper;




    @Override
    public Mono<Integer> createStreet(Street street) {
        return streetMapper.insert(street);
    }

    @Override
    public Mono<Integer> createMultipleStreet(List<Street> streetList) {
        return streetMapper.insertMultiple(streetList);
    }

    @Override
    public Mono<Integer> deleteStreet(String streetId) {
        return this.streetMapper.deleteStreet(streetId);
    }

    @Override
    public Flux<Street> selectStreet(Street street) {
        return this.streetMapper.selectStreet(street);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.streetMapper.count();
    }

    @Override
    public Mono<Integer> updateStreet(Street street) {
        return this.streetMapper.updateSelectiveByPrimaryKey(street);
    }
}
