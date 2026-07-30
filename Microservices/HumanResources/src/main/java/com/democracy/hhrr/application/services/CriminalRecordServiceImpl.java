package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.in.criminalrecord.CreateCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.DeleteCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.SelectCriminalRecordIn;
import com.democracy.hhrr.domain.ports.in.criminalrecord.UpdateCriminalRecordIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CriminalRecordServiceImpl implements CriminalRecordService{
    private final CreateCriminalRecordIn createCriminalRecordIn;
    private final DeleteCriminalRecordIn deleteCriminalRecordIn;
    private final SelectCriminalRecordIn selectCriminalRecordIn;
    private final UpdateCriminalRecordIn updateCriminalRecordIn;

    public CriminalRecordServiceImpl(CreateCriminalRecordIn createCriminalRecordIn, DeleteCriminalRecordIn deleteCriminalRecordIn, SelectCriminalRecordIn selectCriminalRecordIn, UpdateCriminalRecordIn updateCriminalRecordIn) {
        this.createCriminalRecordIn = createCriminalRecordIn;
        this.deleteCriminalRecordIn = deleteCriminalRecordIn;
        this.selectCriminalRecordIn = selectCriminalRecordIn;
        this.updateCriminalRecordIn = updateCriminalRecordIn;
    }

    @Override
    public Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord) {
        return this.createCriminalRecordIn.createCriminalRecord(criminalRecord);
    }

    @Override
    public Mono<Integer> deleteCriminalRecord(String criminalRecordId) {
        return this.deleteCriminalRecordIn.deleteCriminalRecord(criminalRecordId);
    }

    @Override
    public Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord) {
        return this.selectCriminalRecordIn.selectCriminalRecord(criminalRecord);
    }

    @Override
    public Flux<CriminalRecord> selectAllDCriminalRecords() {
        return this.selectCriminalRecordIn.selectAllDCriminalRecords();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectCriminalRecordIn.selectCount();
    }

    @Override
    public Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord) {
        return this.updateCriminalRecordIn.updateCriminalRecord(criminalRecord);
    }
}
