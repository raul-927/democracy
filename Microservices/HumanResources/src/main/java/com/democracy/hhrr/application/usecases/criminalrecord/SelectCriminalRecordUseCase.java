package com.democracy.hhrr.application.usecases.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.in.criminalrecord.SelectCriminalRecordIn;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectCriminalRecordUseCase implements SelectCriminalRecordIn {
    private final CriminalRecordOut criminalRecordOut;

    public SelectCriminalRecordUseCase(CriminalRecordOut criminalRecordOut) {
        this.criminalRecordOut = criminalRecordOut;
    }

    @Override
    public Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord) {
        return this.criminalRecordOut.selectCriminalRecord(criminalRecord);
    }

    @Override
    public Flux<CriminalRecord> selectAllDCriminalRecords() {
        return this.criminalRecordOut.selectAllDCriminalRecords();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.criminalRecordOut.selectCount();
    }
}
