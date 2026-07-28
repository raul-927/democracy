package com.democracy.hhrr.domain.ports.reactive.in.institute;

import reactor.core.publisher.Mono;

public interface DeleteInstituteIn {

    Mono<Integer> deleteInstitute(String instituteId);
}
