package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.in.department.CreateDepartmentIn;
import com.democracy.hhrr.domain.ports.in.department.DeleteDepartmentIn;
import com.democracy.hhrr.domain.ports.in.department.SelectDepartmentIn;
import com.democracy.hhrr.domain.ports.in.department.UpdateDepartmentIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final CreateDepartmentIn createDepartmentIn;
    private final DeleteDepartmentIn deleteDepartmentIn;
    private final SelectDepartmentIn selectDepartmentIn;
    private final UpdateDepartmentIn updateDepartmentIn;

    public DepartmentServiceImpl(CreateDepartmentIn createDepartmentIn,
                                 DeleteDepartmentIn deleteDepartmentIn,
                                 SelectDepartmentIn selectDepartmentIn,
                                 UpdateDepartmentIn updateDepartmentIn) {
        this.createDepartmentIn = createDepartmentIn;
        this.deleteDepartmentIn = deleteDepartmentIn;
        this.selectDepartmentIn = selectDepartmentIn;
        this.updateDepartmentIn = updateDepartmentIn;
    }


    @Override
    public Mono<Integer> createDepartment(Department department) {
        return this.createDepartmentIn.createDepartment(department);
    }

    @Override
    public Mono<Integer> createMultipleDepartment(List<Department> departmentList) {
        return this.createDepartmentIn.createMultipleDepartment(departmentList);
    }

    @Override
    public Mono<Integer> deleteDepartment(String departmentId) {
        return this.deleteDepartmentIn.deleteDepartment(departmentId);
    }

    @Override
    public Flux<Department> selectDepartment(Department department) {
        return this.selectDepartmentIn.selectDepartment(department);
    }

    @Override
    public Flux<Department> selectAllDepartment() {
        return this.selectDepartmentIn.selectAllDepartment();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectDepartmentIn.selectCount();
    }

    @Override
    public Mono<Integer> updateDepartment(Department department) {
        return this.updateDepartmentIn.updateDepartment(department);
    }
}
