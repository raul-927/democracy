package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.out.QualificationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class QualificationAdapter implements QualificationOut {

    @Override
    public Mono<?> createQualification(Qualification qualification) {
        return null;
    }

    @Override
    public Mono<?> createMultipleQualifications(List<Qualification> qualificationList) {
        return null;
    }

    @Override
    public Mono<Integer> deleteQualification(String qualificationId) {
        return null;
    }

    @Override
    public Flux<Qualification> selectQualification(Qualification qualification) {
        return null;
    }

    @Override
    public Flux<Qualification> selectAllQualifications() {
        return null;
    }

    @Override
    public Mono<Long> selectCount() {
        return null;
    }

    @Override
    public Mono<Integer> updateQualification(Qualification qualification) {
        return null;
    }
}
