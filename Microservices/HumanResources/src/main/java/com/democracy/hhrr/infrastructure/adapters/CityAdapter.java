package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.ports.out.CityOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.CityMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CityAdapter implements CityOut {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public Mono<Integer> createCity(City city) {
        return this.cityMapper.insert(city);
    }

    @Override
    public Mono<Integer> createMultipleCity(List<City> cityList) {
        return this.cityMapper.insertMultiple(cityList);
    }

    @Override
    public Mono<Integer> deleteCity(String id) {
        return this.cityMapper.deleteCity(id);
    }

    @Override
    public Flux<City> selectCity(City city) {
        return this.cityMapper.selectCity(city);
    }

    @Override
    public Flux<City> selectAllCity() {
        return this.cityMapper.selectAllCity();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.cityMapper.count();
    }

    @Override
    public Mono<Integer> updateCity(City city) {
        return this.cityMapper.updateSelectiveByPrimaryKey(city);
    }
}
