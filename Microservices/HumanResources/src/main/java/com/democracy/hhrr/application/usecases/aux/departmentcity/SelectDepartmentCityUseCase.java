package com.democracy.hhrr.application.usecases.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.SelectDepartmentCityIn;
import com.democracy.hhrr.domain.ports.out.aux.DepartmentCityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectDepartmentCityUseCase implements SelectDepartmentCityIn {

    private final DepartmentCityOut departmentCityOut;

    public SelectDepartmentCityUseCase(DepartmentCityOut departmentCityOut) {
        this.departmentCityOut = departmentCityOut;
    }

    @Override
    public Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityOut.selectDepartmentCity(departmentCity);
    }
}
