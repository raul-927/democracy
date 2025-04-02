package com.democracy.hhrr.domain.ports.in.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import reactor.core.publisher.Flux;

public interface SelectDepartmentCityIn {

    Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity);
}
