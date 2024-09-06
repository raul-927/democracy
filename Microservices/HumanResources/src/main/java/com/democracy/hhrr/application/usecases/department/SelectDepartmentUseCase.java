package com.democracy.hhrr.application.usecases.department;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.SelectDepartmentIn;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class SelectDepartmentUseCase implements SelectDepartmentIn {

    private final DepartmentOut departmentOut;

    public SelectDepartmentUseCase(DepartmentOut departmentOut) {
        this.departmentOut = departmentOut;
    }


    @Override
    public Flux<Department> selectDepartment(Department department) {
        return departmentOut.selectDepartment(department);
    }

    @Override
    public Mono<Long> selectCount() {
        return departmentOut.selectCount();
    }
}
