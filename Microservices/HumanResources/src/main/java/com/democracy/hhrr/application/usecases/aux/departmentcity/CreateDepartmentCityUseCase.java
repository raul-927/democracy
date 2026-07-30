package com.democracy.hhrr.application.usecases.aux.departmentcity;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.CreateDepartmentCityIn;
import com.democracy.hhrr.domain.ports.out.aux.DepartmentCityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateDepartmentCityUseCase implements CreateDepartmentCityIn {

    private final DepartmentCityOut departmentCityOut;

    public CreateDepartmentCityUseCase(DepartmentCityOut departmentCityOut) {
        this.departmentCityOut = departmentCityOut;
    }


    @Override
    public Mono<Integer> createDepartmentCity(DepartmentCity departmentCity) {
        return departmentCityOut.createDepartmentCity(departmentCity);
    }

    @Override
    public Mono<Integer> createMultipleDepartmentCity(List<DepartmentCity> departmentCities) {
        return departmentCityOut.createMultipleDepartmentCity(departmentCities);
    }
}
