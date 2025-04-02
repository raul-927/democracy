package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.DepartmentService;
import com.democracy.hhrr.domain.models.Department;
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
    private DepartmentService departmentService;

   /* @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Flux<Department> selectDepartment(@RequestBody Department department){
        return this.departmentService.selectDepartment(department);
    }
    /*@GetMapping(
            value = "/select-all",
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Flux<Department> selectAllDepartment(){
        System.out.println("LLEGA DEPARTMENT CONTROLLER");
        return this.departmentService.selectAllDepartment();
    }

    /*@PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Mono<Integer> createDepartment(@RequestBody Department department){
        return this.departmentService.createDepartment(department);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<Department> departmentList){
        return departmentService.createMultipleDepartment(departmentList);
    }

    /*@PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Mono<Integer> updateDepartment(@RequestBody Department department){
        return this.departmentService.updateDepartment(department);
    }

   /* @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Mono<Long> selectCountDepartment(){
        return this.departmentService.selectCount();
    }

    /*@DeleteMapping(value="/delete/{departmentId}")*/
    public Mono<Integer> deleteDepartment(@PathVariable String departmentId){
        return this.departmentService.deleteDepartment(departmentId);
    }
}
