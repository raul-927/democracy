package com.democracy.hhrr.domain.ports.in.penal;

import reactor.core.publisher.Mono;

public interface DeletePenalIn {
    Mono<Integer> deletePenal(String penalId);
}
