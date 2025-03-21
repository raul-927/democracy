package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.InvestigationService;
import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.domain.models.Investigation;
import liquibase.pro.packaged.A;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class InvestigationHandler {



    @Autowired
    private InvestigationService investigationService;

    public Mono<ServerResponse> selectInvestigation(ServerRequest request){
        var obtainInvestigation = request.bodyToMono(Investigation.class);
        Investigation sendInvestigation  = new Investigation();
        obtainInvestigation.map( str ->{
            sendInvestigation.setInvestigationId(str.getInvestigationId());
            sendInvestigation.setPerson(str.getPerson());
            sendInvestigation.setQualifications(str.getQualifications());
            sendInvestigation.setCriminalRecords(str.getCriminalRecords());
            sendInvestigation.setObservation(str.getObservation());
            sendInvestigation.setId(str.getId());
            return sendInvestigation;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(investigationService.selectInvestigation(sendInvestigation), Investigation.class);
    }

}
