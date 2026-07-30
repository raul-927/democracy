package com.democracy.hhrr.domain.ports.in.aux.departmentcity;

import reactor.core.publisher.Mono;

public interface DeleteDepartmentCityIn {

    Mono<Integer> deleteDepartmentCity(String id);

}
