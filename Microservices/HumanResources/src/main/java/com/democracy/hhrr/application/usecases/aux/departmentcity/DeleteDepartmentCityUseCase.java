package com.democracy.hhrr.application.usecases.aux.departmentcity;

import com.democracy.hhrr.domain.ports.in.aux.departmentcity.DeleteDepartmentCityIn;
import com.democracy.hhrr.domain.ports.out.aux.DepartmentCityOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteDepartmentCityUseCase implements DeleteDepartmentCityIn {

    private final DepartmentCityOut departmentCityOut;

    public DeleteDepartmentCityUseCase(DepartmentCityOut departmentCityOut) {
        this.departmentCityOut = departmentCityOut;
    }


    @Override
    public Mono<Integer> deleteDepartmentCity(String id) {
        return departmentCityOut.deleteDepartmentCity(id);
    }
}
