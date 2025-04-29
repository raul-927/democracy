package com.democracy.hhrr.infrastructure.web.handlers;


import com.democracy.hhrr.application.services.StreetService;
import com.democracy.hhrr.application.services.aux.InstituteService;
import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.models.Street;
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
public class InstituteHandler {

    @Autowired
    private InstituteService instituteService;

    public Mono<ServerResponse> selectInstitute(ServerRequest request){
        var obtainInstitute = request.bodyToMono(Institute.class);
        Institute sendInstitute  = new Institute();
        obtainInstitute.map( inst ->{
            sendInstitute.setInstituteId(inst.getInstituteId());
            sendInstitute.setAddress(inst.getAddress());

            return sendInstitute;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(instituteService.selectInstitute(sendInstitute), Institute.class);
    }

    public Mono<ServerResponse> createInstitute(ServerRequest request){
        Mono<Institute> instituteMono = request.bodyToMono(Institute.class);

        return instituteMono.flatMap(
                i ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(instituteService.createInstitute(i), Institute.class));
    }

    /*public Mono<ServerResponse> createMultipleInstitute(ServerRequest request){
        List<Institute>instituteList = new ArrayList<>();

        var obtainListInstitute= request.bodyToFlux(Institute.class);
        obtainListInstitute.collectList().map(
                inst ->{
                    instituteList.addAll(inst);

                    return instituteList;
                }
        ).subscribe(System.out::println).dispose();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(instituteService.createMultipleInstitute(streetList), Street.class);
    }*/

    public Mono<ServerResponse> updateInstitute(ServerRequest request){
        Mono<Institute> instituteMono = request.bodyToMono(Institute.class);
        return instituteMono.flatMap(
                i ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(instituteService.updateInstitute(i), Institute.class));
    }

    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = instituteService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Integer.class);
    }
}