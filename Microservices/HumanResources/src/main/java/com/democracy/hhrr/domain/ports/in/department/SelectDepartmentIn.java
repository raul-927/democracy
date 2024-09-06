package com.democracy.hhrr.domain.ports.in.department;

import com.democracy.hhrr.domain.models.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectDepartmentIn {

    Flux<Department> selectDepartment(Department department);
    Mono<Long> selectCount();

}
