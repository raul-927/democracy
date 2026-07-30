package com.democracy.hhrr.domain.ports.in.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateDepartmentCityIn {

    Mono<Integer> createDepartmentCity(DepartmentCity departmentCity);
    Mono<Integer> createMultipleDepartmentCity(List<DepartmentCity> departmentCities);
}
