package com.democracy.hhrr.domain.ports.in.qualification;

import reactor.core.publisher.Mono;

public interface DeleteQualificationIn {
    Mono<Integer> deleteQualification(String qualificationId);
}
