package com.democracy.hhrr.application.usecases.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.in.criminalrecord.CreateCriminalRecordIn;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateCriminalRecordUseCase implements CreateCriminalRecordIn {
    private final CriminalRecordOut criminalRecordOut;

    public CreateCriminalRecordUseCase(CriminalRecordOut criminalRecordOut) {
        this.criminalRecordOut = criminalRecordOut;
    }

    @Override
    public Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord) {
        return this.criminalRecordOut.createCriminalRecord(criminalRecord);
    }
}
