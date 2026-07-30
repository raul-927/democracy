package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.ports.out.DepartmentOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class DepartmentAdapter implements DepartmentOut {


    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public Mono<Integer> createDepartment(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public Mono<Integer> createMultipleDepartment(List<Department> departmentList) {
        return departmentMapper.insertMultiple(departmentList);
    }

    @Override
    public Mono<Integer> deleteDepartment(String departmentId) {
        return departmentMapper.deleteDepartment(departmentId);
    }

    @Override
    public Flux<Department> selectDepartment(Department department) {
        return departmentMapper.selectFullDepartment(department);
    }

    @Override
    public Flux<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public Mono<Long> selectCount() {
        return departmentMapper.count();
    }

    @Override
    public Mono<Integer> updateDepartment(Department department) {
        return departmentMapper.updateAllByPrimaryKey(department);
    }
}
