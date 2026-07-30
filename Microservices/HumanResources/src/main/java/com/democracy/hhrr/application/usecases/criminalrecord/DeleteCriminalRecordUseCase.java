package com.democracy.hhrr.application.usecases.criminalrecord;

import com.democracy.hhrr.domain.ports.in.criminalrecord.DeleteCriminalRecordIn;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteCriminalRecordUseCase implements DeleteCriminalRecordIn {
    private final CriminalRecordOut criminalRecordOut;

    public DeleteCriminalRecordUseCase(CriminalRecordOut criminalRecordOut) {
        this.criminalRecordOut = criminalRecordOut;
    }

    @Override
    public Mono<Integer> deleteCriminalRecord(String criminalRecordId) {
        return this.criminalRecordOut.deleteCriminalRecord(criminalRecordId);
    }
}
