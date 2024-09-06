package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DepartmentOut {

    Mono<Integer> createDepartment(Department department);
    Mono<Integer>createMultipleDepartment(List<Department> departmentList);
    Mono<Integer> deleteDepartment(String departmentId);
    Flux<Department> selectDepartment(Department department);
    Mono<Long> selectCount();
    Mono<Integer> updateDepartment(Department department);
}
