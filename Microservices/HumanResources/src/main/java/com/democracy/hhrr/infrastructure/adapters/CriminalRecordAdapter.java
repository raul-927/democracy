package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CriminalRecordAdapter implements CriminalRecordOut {
    @Override
    public Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord) {
        return null;
    }

    @Override
    public Mono<Integer> deleteCriminalRecord(String criminalRecordId) {
        return null;
    }

    @Override
    public Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord) {
        return null;
    }

    @Override
    public Flux<CriminalRecord> selectAllDCriminalRecords() {
        return null;
    }

    @Override
    public Mono<Long> selectCount() {
        return null;
    }

    @Override
    public Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord) {
        return null;
    }
}
