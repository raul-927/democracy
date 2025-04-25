package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.out.QualificationOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.QualificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class QualificationAdapter implements QualificationOut {

    @Autowired
    private QualificationMapper qualificationMapper;

    @Override
    public Mono<?> createQualification(Qualification qualification) {
        return qualificationMapper.insert(qualification);
    }

    @Override
    public Mono<?> createMultipleQualifications(List<Qualification> qualificationList) {
        return qualificationMapper.insertMultiple(qualificationList);
    }

    @Override
    public Mono<Integer> deleteQualification(String qualificationId) {
        return qualificationMapper.deleteQualification(qualificationId);
    }

    @Override
    public Flux<Qualification> selectQualification(Qualification qualification) {
        return qualificationMapper.selectQualification(qualification);
    }

    @Override
    public Flux<Qualification> selectAllQualifications() {
        return qualificationMapper.selectAllQualifications();
    }

    @Override
    public Mono<Long> selectCount() {
        return qualificationMapper.count();
    }

    @Override
    public Mono<Integer> updateQualification(Qualification qualification) {
        return qualificationMapper.updateAllByPrimaryKey(qualification);
    }
}
