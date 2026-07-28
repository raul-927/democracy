package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.ports.reactive.in.department.DeleteDepartmentIn;
import com.democracy.hhrr.domain.ports.reactive.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class DeleteDepartmentUseCase implements DeleteDepartmentIn {

    private final DepartmentOut departmentOut;

    public DeleteDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }

    @Override
    public Mono<Integer> deleteDepartment(String departmentId) {
        return departmentOut.deleteDepartment(departmentId);
    }
}
