package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.CriminalRecordService;
import com.democracy.hhrr.application.services.QualificationService;
import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.models.Qualification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Component
//@Slf4j
public class QualificationHandler {

    //@Autowired
    private QualificationService qualificationService;

    public Mono<ServerResponse> selectQualification(ServerRequest request){
        var obtainQualification = request.bodyToMono(Qualification.class);
        Qualification sendQualification  = new Qualification();
        obtainQualification.map( qual ->{
            sendQualification.setQualificationId(qual.getQualificationId());
            sendQualification.setPerson(qual.getPerson());
            sendQualification.setInstitute(qual.getInstitute());
            sendQualification.setDocument(qual.getDocument());
            sendQualification.setPerson(qual.getPerson());
            sendQualification.setApproved(qual.getApproved());
            sendQualification.setVerified(qual.getVerified());
            return sendQualification;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(qualificationService.selectQualification(sendQualification), Qualification.class);
    }

    public Mono<ServerResponse> selectAllQualifications(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(qualificationService.selectAllQualifications(), Qualification.class);
    }

    public Mono<ServerResponse> createQualification(ServerRequest request){
        Mono<Qualification> qualificationMono = request.bodyToMono(Qualification.class);

        return qualificationMono.flatMap(
                qual ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(qualificationService.createQualification(qual), CriminalRecord.class));
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

    public Mono<ServerResponse> updateQualification(ServerRequest request){
        Mono<Qualification> qualificationMono = request.bodyToMono(Qualification.class);
        return qualificationMono.flatMap(
                q ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(qualificationService.updateQualification(q), Qualification.class));
    }

    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = qualificationService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Qualification.class);
    }
}