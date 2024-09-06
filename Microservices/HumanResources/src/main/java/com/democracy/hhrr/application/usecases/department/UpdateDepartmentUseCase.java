package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.UpdateDepartmentIn;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class UpdateDepartmentUseCase implements UpdateDepartmentIn {

    private final DepartmentOut departmentOut;

    public UpdateDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }


    @Override
    public Mono<Integer> updateDepartment(Department department) {
        return departmentOut.updateDepartment(department);
    }
}
