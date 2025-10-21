package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.CreateDepartmentIn;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreateDepartmentUseCase implements CreateDepartmentIn {

    private final DepartmentOut departmentOut;

    public CreateDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }

    @Override
    public Mono<Integer> createDepartment(Department department) {
        department.setDepartmentId(UUID.randomUUID().toString());
        return departmentOut.createDepartment(department);
    }

    @Override
    public Mono<Integer> createMultipleDepartment(List<Department> departmentList) {
        departmentList.forEach(dep ->{
            dep.setDepartmentId(UUID.randomUUID().toString());
        });
        return departmentOut.createMultipleDepartment(departmentList);
    }
}
