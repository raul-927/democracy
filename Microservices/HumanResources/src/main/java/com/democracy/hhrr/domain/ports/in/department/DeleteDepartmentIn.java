package com.democracy.hhrr.domain.ports.in.department;

import reactor.core.publisher.Mono;

public interface DeleteDepartmentIn {

    Mono<Integer> deleteDepartment(String departmentId);
}
