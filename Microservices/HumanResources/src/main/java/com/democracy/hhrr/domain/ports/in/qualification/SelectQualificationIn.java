package com.democracy.hhrr.domain.ports.in.qualification;

import com.democracy.hhrr.domain.models.Qualification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectQualificationIn {

    Flux<Qualification> selectQualification(Qualification qualification);
    Flux<Qualification> selectAllQualifications();
    Mono<Long> selectCount();
}
