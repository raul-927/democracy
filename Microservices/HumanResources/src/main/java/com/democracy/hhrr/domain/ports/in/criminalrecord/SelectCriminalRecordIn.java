package com.democracy.hhrr.domain.ports.in.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectCriminalRecordIn {

    Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord);
    Flux<CriminalRecord> selectAllDCriminalRecords();
    Mono<Long> selectCount();
}
