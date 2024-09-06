package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.CreateDepartmentIn;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateDepartmentUseCase implements CreateDepartmentIn {

    private final DepartmentOut departmentOut;

    public CreateDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }

    @Override
    public Mono<Integer> createDepartment(Department department) {
        return departmentOut.createDepartment(department);
    }

    @Override
    public Mono<Integer> createMultipleDepartment(List<Department> departmentList) {
        return departmentOut.createMultipleDepartment(departmentList);
    }
}
