package com.democracy.hhrr.domain.ports.in.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import reactor.core.publisher.Mono;

public interface UpdateCriminalRecordIn {

    Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord);
}
