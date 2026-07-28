package com.democracy.hhrr.domain.ports.reactive.in.institute;

import com.democracy.hhrr.domain.models.Institute;
import reactor.core.publisher.Mono;

public interface UpdateInstituteIn {

    Mono<Integer> updateInstitute(Institute institute);
}
