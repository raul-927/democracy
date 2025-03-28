package com.democracy.hhrr.application.usecases.criminalrecord;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.in.criminalrecord.UpdateCriminalRecordIn;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateCriminalRecordUseCase implements UpdateCriminalRecordIn {
    private final CriminalRecordOut criminalRecordOut;

    public UpdateCriminalRecordUseCase(CriminalRecordOut criminalRecordOut) {
        this.criminalRecordOut = criminalRecordOut;
    }

    @Override
    public Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord) {
        return this.criminalRecordOut.updateCriminalRecord(criminalRecord);
    }
}
