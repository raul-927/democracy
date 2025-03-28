package com.democracy.hhrr.domain.ports.in.institute;

import com.democracy.hhrr.domain.models.Institute;
import reactor.core.publisher.Mono;

public interface CreateInstituteIn {

    Mono<Integer> createInstitute(Institute institute);
}
