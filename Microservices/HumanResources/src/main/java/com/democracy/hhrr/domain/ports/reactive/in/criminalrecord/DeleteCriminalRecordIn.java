package com.democracy.hhrr.domain.ports.reactive.in.criminalrecord;

import reactor.core.publisher.Mono;

public interface DeleteCriminalRecordIn {

    Mono<Integer> deleteCriminalRecord(String criminalRecordId);
}
