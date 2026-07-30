package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Institute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InstituteOut {

    Mono<Integer> createInstitute(Institute institute);
    Mono<Integer> deleteInstitute(String documentId);
    Flux<Institute> selectInstitute(Institute institute);
    Flux<Institute> selectAllInstitutes();
    Mono<Long> selectCount();
    Mono<Integer> updateInstitute(Institute institute);
}
