package com.democracy.hhrr.domain.ports.in.qualification;

import com.democracy.hhrr.domain.models.Qualification;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateQualificationIn {

    Mono<?> createQualification(Qualification qualification);
    Mono<?>createMultipleQualifications(List<Qualification> qualificationList);
}
