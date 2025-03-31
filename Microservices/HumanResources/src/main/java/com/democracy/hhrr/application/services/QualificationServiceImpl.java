package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.in.qualification.CreateQualificationIn;
import com.democracy.hhrr.domain.ports.in.qualification.DeleteQualificationIn;
import com.democracy.hhrr.domain.ports.in.qualification.SelectQualificationIn;
import com.democracy.hhrr.domain.ports.in.qualification.UpdateQualificationIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QualificationServiceImpl implements QualificationService{
    private final CreateQualificationIn createQualificationIn;
    private final DeleteQualificationIn deleteQualificationIn;
    private final SelectQualificationIn selectQualificationIn;
    private final UpdateQualificationIn updateQualificationIn;

    public QualificationServiceImpl(CreateQualificationIn createQualificationIn, DeleteQualificationIn deleteQualificationIn, SelectQualificationIn selectQualificationIn, UpdateQualificationIn updateQualificationIn) {
        this.createQualificationIn = createQualificationIn;
        this.deleteQualificationIn = deleteQualificationIn;
        this.selectQualificationIn = selectQualificationIn;
        this.updateQualificationIn = updateQualificationIn;
    }

    @Override
    public Mono<?> createQualification(Qualification qualification) {
        return this.createQualificationIn.createQualification(qualification);
    }

    @Override
    public Mono<?> createMultipleQualifications(List<Qualification> qualificationList) {
        return this.createQualificationIn.createMultipleQualifications(qualificationList);
    }

    @Override
    public Mono<Integer> deleteQualification(String qualificationId) {
        return this.deleteQualificationIn.deleteQualification(qualificationId);
    }

    @Override
    public Flux<Qualification> selectQualification(Qualification qualification) {
        return this.selectQualificationIn.selectQualification(qualification);
    }

    @Override
    public Flux<Qualification> selectAllQualifications() {
        return this.selectQualificationIn.selectAllQualifications();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectQualificationIn.selectCount();
    }

    @Override
    public Mono<Integer> updateQualification(Qualification qualification) {
        return this.updateQualificationIn.updateQualification(qualification);
    }
}
