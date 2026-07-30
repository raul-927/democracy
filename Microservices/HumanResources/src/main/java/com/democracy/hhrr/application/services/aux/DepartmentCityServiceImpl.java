package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.CreateDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.DeleteDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.SelectDepartmentCityIn;
import com.democracy.hhrr.domain.ports.in.aux.departmentcity.UpdateDepartmentCityIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DepartmentCityServiceImpl implements DepartmentCityService{
    private final CreateDepartmentCityIn createDepartmentCityIn;
    private final DeleteDepartmentCityIn deleteDepartmentCityIn;
    private final SelectDepartmentCityIn selectDepartmentCityIn;
    private final UpdateDepartmentCityIn updateDepartmentCityIn;

    public DepartmentCityServiceImpl(CreateDepartmentCityIn createDepartmentCityIn, DeleteDepartmentCityIn deleteDepartmentCityIn, SelectDepartmentCityIn selectDepartmentCityIn, UpdateDepartmentCityIn updateDepartmentCityIn) {
        this.createDepartmentCityIn = createDepartmentCityIn;
        this.deleteDepartmentCityIn = deleteDepartmentCityIn;
        this.selectDepartmentCityIn = selectDepartmentCityIn;
        this.updateDepartmentCityIn = updateDepartmentCityIn;
    }

    @Override
    public Mono<Integer> createDepartmentCity(DepartmentCity departmentCity) {
        return this.createDepartmentCityIn.createDepartmentCity(departmentCity);
    }

    @Override
    public Mono<Integer> createMultipleDepartmentCity(List<DepartmentCity> departmentCities) {
        return this.createDepartmentCityIn.createMultipleDepartmentCity(departmentCities);
    }

    @Override
    public Mono<Integer> deleteDepartmentCity(String id) {
        return this.deleteDepartmentCityIn.deleteDepartmentCity(id);
    }

    @Override
    public Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity) {
        return this.selectDepartmentCityIn.selectDepartmentCity(departmentCity);
    }

    @Override
    public Mono<Integer> updateDepartmentCity(DepartmentCity departmentCity) {
        return this.updateDepartmentCityIn.updateDepartmentCity(departmentCity);
    }
}
