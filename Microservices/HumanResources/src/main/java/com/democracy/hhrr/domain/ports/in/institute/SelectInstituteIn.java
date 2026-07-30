package com.democracy.hhrr.domain.ports.in.institute;

import com.democracy.hhrr.domain.models.Institute;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectInstituteIn {

    Flux<Institute> selectInstitute(Institute institute);
    Flux<Institute> selectAllInstitutes();
    Mono<Long> selectCount();
}
