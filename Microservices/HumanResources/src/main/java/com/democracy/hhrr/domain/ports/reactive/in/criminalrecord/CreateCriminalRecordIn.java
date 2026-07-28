package com.democracy.hhrr.domain.ports.reactive.in.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import reactor.core.publisher.Mono;

public interface CreateCriminalRecordIn {

    Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord);
}
