package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.CriminalRecordService;
import com.democracy.hhrr.application.services.DepartmentService;
import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.models.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Slf4j
public class CriminalRecordHandler {

    //@Autowired
    private CriminalRecordService criminalRecordService;

    public Mono<ServerResponse> selectCriminalRecord(ServerRequest request){
        var obtainCriminalRecord = request.bodyToMono(CriminalRecord.class);
        CriminalRecord sendCriminalRecord  = new CriminalRecord();
        obtainCriminalRecord.map( crrec ->{
            sendCriminalRecord.setCriminalRecordId(crrec.getCriminalRecordId());
            sendCriminalRecord.setCriminalRecordName(crrec.getCriminalRecordName());
            sendCriminalRecord.setCriminalRecordDescription(crrec.getCriminalRecordDescription());
            sendCriminalRecord.setPenal(crrec.getPenal());
            sendCriminalRecord.setPerson(crrec.getPerson());
            return sendCriminalRecord;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(criminalRecordService.selectCriminalRecord(sendCriminalRecord), CriminalRecord.class);
    }

    public Mono<ServerResponse> selectAllCriminalRecords(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(criminalRecordService.selectAllDCriminalRecords(), CriminalRecord.class);
    }

    public Mono<ServerResponse> createCriminalRecord(ServerRequest request){
        Mono<CriminalRecord> criminalRecordMono = request.bodyToMono(CriminalRecord.class);

        return criminalRecordMono.flatMap(
                crimrec ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(criminalRecordService.createCriminalRecord(crimrec), CriminalRecord.class));
    }

    /*public Mono<ServerResponse> createMultipleCriminalRecords(ServerRequest request){
        List<CriminalRecord>criminalRecordList = new ArrayList<>();

        var obtainListCriminalRecords = request.bodyToFlux(CriminalRecord.class);
        obtainListCriminalRecords.collectList().map(
                crim ->{
                    criminalRecordList.addAll(crim);
                    return criminalRecordList;
                }
        ).subscribe(System.out::println).dispose();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(criminalRecordService.createMultiple(criminalRecordList), CriminalRecord.class);
    }*/

    public Mono<ServerResponse> updateCriminalRecord(ServerRequest request){
        Mono<CriminalRecord> criminalRecordMono = request.bodyToMono(CriminalRecord.class);
        return criminalRecordMono.flatMap(
                c ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(criminalRecordService.updateCriminalRecord(c), CriminalRecord.class));
    }

    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = criminalRecordService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, CriminalRecord.class);
    }
}