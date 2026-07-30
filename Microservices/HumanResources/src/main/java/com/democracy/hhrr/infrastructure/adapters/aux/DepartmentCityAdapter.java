package com.democracy.hhrr.infrastructure.adapters.aux;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.domain.ports.out.aux.DepartmentCityOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux.DepartmentCityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class DepartmentCityAdapter implements DepartmentCityOut {

    @Autowired
    private DepartmentCityMapper departmentCityMapper;

    @Override
    public Mono<Integer> createDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityMapper.insert(departmentCity);
    }

    @Override
    public Mono<Integer> createMultipleDepartmentCity(List<DepartmentCity> departmentCities) {
        return departmentCityMapper.insertMultiple(departmentCities);
    }

    @Override
    public Mono<Integer> deleteDepartmentCity(String id) {
        return departmentCityMapper.deleteDepartmentCity(id);
    }

    @Override
    public Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityMapper.selectDepartmentCity(departmentCity);
    }

    @Override
    public Mono<Integer> updateDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityMapper.updateSelectiveByPrimaryKey(departmentCity);
    }
}
