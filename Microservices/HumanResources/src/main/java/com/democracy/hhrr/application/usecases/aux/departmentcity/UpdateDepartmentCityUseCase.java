package com.democracy.hhrr.application.usecases.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.UpdateDepartmentCityIn;
import com.democracy.hhrr.domain.ports.out.aux.DepartmentCityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UpdateDepartmentCityUseCase implements UpdateDepartmentCityIn {

    private final DepartmentCityOut departmentCityOut;

    public UpdateDepartmentCityUseCase(DepartmentCityOut departmentCityOut) {
        this.departmentCityOut = departmentCityOut;
    }


    @Override
    public Mono<Integer> updateDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityOut.updateDepartmentCity(departmentCity);
    }
}
