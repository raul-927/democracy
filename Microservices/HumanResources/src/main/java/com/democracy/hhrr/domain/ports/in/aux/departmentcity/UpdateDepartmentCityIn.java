package com.democracy.hhrr.domain.ports.in.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import reactor.core.publisher.Mono;

public interface UpdateDepartmentCityIn {

    Mono<Integer> updateDepartmentCity(DepartmentCity departmentCity);
}
