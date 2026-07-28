package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.reactive.out.InstituteOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.InstituteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InsituteAdapter implements InstituteOut {

    @Autowired
    private InstituteMapper instituteMapper;

    @Override
    public Mono<Integer> createInstitute(Institute institute) {
        return instituteMapper.insert(institute);
    }

    @Override
    public Mono<Integer> deleteInstitute(String instituteId) {
        return instituteMapper.deleteInstitute(instituteId);
    }

    @Override
    public Flux<Institute> selectInstitute(Institute institute) {
        return instituteMapper.selectInstitute(institute);
    }

    @Override
    public Flux<Institute> selectAllInstitutes() {
        return instituteMapper.selectAllInstitutes();
    }

    @Override
    public Mono<Long> selectCount() {
        return instituteMapper.count();
    }

    @Override
    public Mono<Integer> updateInstitute(Institute institute) {
        return instituteMapper.updateAllByPrimaryKey(institute);
    }
}
