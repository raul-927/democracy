package com.democracy.hhrr.domain.ports.in.department;

import com.democracy.hhrr.domain.models.Department;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateDepartmentIn {

    Mono<Integer> createDepartment(Department department);
    Mono<Integer>createMultipleDepartment(List<Department> departmentList);
}
