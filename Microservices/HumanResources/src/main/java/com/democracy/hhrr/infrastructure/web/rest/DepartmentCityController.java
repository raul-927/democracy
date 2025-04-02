package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.aux.DepartmentCityService;
import com.democracy.hhrr.domain.aux.DepartmentCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/depcity")
@RefreshScope
public class DepartmentCityController {

    @Autowired
    private DepartmentCityService departmentCityService;

   @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<DepartmentCity> selectDepartmentCity(@RequestBody DepartmentCity departmentCity){
        return this.departmentCityService.selectDepartmentCity(departmentCity);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createDepartmentCity(@RequestBody DepartmentCity departmentCity){
        return this.departmentCityService.createDepartmentCity(departmentCity);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<DepartmentCity> departmentCities){
        return departmentCityService.createMultipleDepartmentCity(departmentCities);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateDepartmentCity(@RequestBody DepartmentCity departmentCity){
        return this.departmentCityService.updateDepartmentCity(departmentCity);
    }

    @DeleteMapping(value="/delete/{departmentId}")
    public Mono<Integer> deleteDepartmentCity(@PathVariable String departmentCityId){
        return this.departmentCityService.deleteDepartmentCity(departmentCityId);
    }
}
