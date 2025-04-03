package com.democracy.hhrr.infrastructure.web.handlers;


import com.democracy.hhrr.application.services.PenalService;
import com.democracy.hhrr.domain.models.Penal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class PenalHandler {

    @Autowired
    private  PenalService penalService;

    public Mono<ServerResponse> selectPenal(ServerRequest request){
        var obtainStreet = request.bodyToMono(Penal.class);
        Penal sendPenal  = new Penal();
        obtainStreet.map( pnl ->{
            sendPenal.setPenalId(pnl.getPenalId());
            sendPenal.setPenalName(pnl.getPenalName());
            return sendPenal;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(penalService.selectPenal(sendPenal), Penal.class);
    }

    public Mono<ServerResponse> createPenal(ServerRequest request){
        Mono<Penal> penal = request.bodyToMono(Penal.class);

        return penal.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(penalService.createPenal(s), Penal.class));
    }

    public Mono<ServerResponse> createMultiplePenals(ServerRequest request){
        List<Penal>penalList = new ArrayList<>();

        var obtainListStreets = request.bodyToFlux(Penal.class);
        obtainListStreets.collectList().map(
                strc ->{
                    System.out.println("STRC: "+strc);
                    penalList.addAll(strc);
                    System.out.println("STREET_LIST: "+penalList);
                    return penalList;
                }
        ).subscribe(System.out::println).dispose();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(penalService.createMultiplePenals(penalList), Penal.class);
    }

    public Mono<ServerResponse> updatePenal(ServerRequest request){
        Mono<Penal> penal = request.bodyToMono(Penal.class);
        return penal.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(penalService.updatePenal(s), Penal.class));
    }

    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = penalService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Integer.class);
    }
}