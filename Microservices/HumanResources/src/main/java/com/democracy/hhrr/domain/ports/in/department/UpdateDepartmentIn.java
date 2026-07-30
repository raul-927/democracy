package com.democracy.hhrr.domain.ports.in.department;

import com.democracy.hhrr.domain.models.Department;
import reactor.core.publisher.Mono;

public interface UpdateDepartmentIn {
    Mono<Integer> updateDepartment(Department department);
}
