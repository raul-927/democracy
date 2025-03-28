package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.ports.out.CriminalRecordOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.CriminalRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CriminalRecordAdapter implements CriminalRecordOut {

    @Autowired
    private CriminalRecordMapper criminalRecordMapper;


    @Override
    public Mono<Integer> createCriminalRecord(CriminalRecord criminalRecord) {

        return criminalRecordMapper.insert(criminalRecord);
    }

    @Override
    public Mono<Integer> deleteCriminalRecord(String criminalRecordId) {

        return criminalRecordMapper.deleteCriminalRecord(criminalRecordId);
    }

    @Override
    public Flux<CriminalRecord> selectCriminalRecord(CriminalRecord criminalRecord) {

        return criminalRecordMapper.selectFullCriminalRecord(criminalRecord);
    }

    @Override
    public Flux<CriminalRecord> selectAllDCriminalRecords() {

        return null;
    }

    @Override
    public Mono<Long> selectCount() {

        return criminalRecordMapper.count();
    }

    @Override
    public Mono<Integer> updateCriminalRecord(CriminalRecord criminalRecord) {

        return criminalRecordMapper.updateSelectiveByPrimaryKey(criminalRecord);
    }
}
