package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.CriminalRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CriminalRecordOut {
    Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord);
    Mono<Integer> deleteCriminalRecord(String criminalRecordId);
    Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord);
    Flux<CriminalRecord> selectAllDCriminalRecords();
    Mono<Long> selectCount();
    Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord);
}
