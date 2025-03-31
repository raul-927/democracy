package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.models.Qualification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface QualificationOut {

    Mono<?> createQualification(Qualification qualification);
    Mono<?>createMultipleQualifications(List<Qualification> qualificationList);
    Mono<Integer> deleteQualification(String qualificationId);
    Flux<Qualification> selectQualification(Qualification qualification);
    Flux<Qualification> selectAllQualifications();
    Mono<Long> selectCount();
    Mono<Integer> updateQualification(Qualification qualification);
}
