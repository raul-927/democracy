package com.democracy.hhrr.domain.ports.reactive.in.qualification;

import com.democracy.hhrr.domain.models.Qualification;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateQualificationIn {

    Mono<Integer> createQualification(Qualification qualification);
    Mono<Integer>createMultipleQualifications(List<Qualification> qualificationList);
}
