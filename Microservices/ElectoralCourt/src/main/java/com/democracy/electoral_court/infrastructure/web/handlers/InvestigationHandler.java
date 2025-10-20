package com.democracy.electoral_court.infrastructure.web.handlers;

import com.democracy.electoral_court.domain.models.Investigation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Component
//@Slf4j
public class InvestigationHandler {

    public Mono<ServerResponse> selectInvestigation(ServerRequest request){
        var obtainInvestigation = request.bodyToMono(Investigation.class);
        var returnInvestigation = request.bodyToFlux(Investigation.class);
        Investigation sendInvestigation  = new Investigation();
        returnInvestigation.map( inv ->{
            sendInvestigation.setInvestigationId(inv.getInvestigationId());
            sendInvestigation.setPerson(inv.getPerson());
            sendInvestigation.setObservation(inv.getObservation());
            sendInvestigation.setQualifications(inv.getQualifications());
            sendInvestigation.setCriminalRecords(inv.getCriminalRecords());
            sendInvestigation.setId(inv.getId());
            System.out.println("INVESTIGATION HANDLER: "+sendInvestigation);
            return sendInvestigation;
        });
        Mono<ServerResponse> responseServerMono = ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(returnInvestigation, Investigation.class);
        responseServerMono.subscribe(rep->{
            System.out.println("RESPONSE: "+rep);
        });
        return responseServerMono;
    }

    public Mono<ServerResponse> createInvestigation(ServerRequest request){
        Mono<Investigation> investigation = request.bodyToMono(Investigation.class);

        return investigation.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(s, Investigation.class));
    }
}
