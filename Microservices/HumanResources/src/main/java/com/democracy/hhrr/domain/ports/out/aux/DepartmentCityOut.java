package com.democracy.hhrr.domain.ports.out.aux;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DepartmentCityOut {

    Mono<Integer> createDepartmentCity(DepartmentCity departmentCity);
    Mono<Integer> createMultipleDepartmentCity(List<DepartmentCity> departmentCities);
    Mono<Integer> deleteDepartmentCity(String id);
    Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity);
    Mono<Integer> updateDepartmentCity(DepartmentCity departmentCity);
}
