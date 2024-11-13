package com.democracy.hhrr.infrastructure.web.handlers;


import com.democracy.hhrr.application.services.StreetService;
import com.democracy.hhrr.domain.models.Street;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Slf4j
public class StreetHandler {

    private Mono<ServerResponse> responseMono;

    @Autowired
    private  StreetService streetService;

    public Mono<ServerResponse> selectStreet(ServerRequest request){
        var obtainStreet = request.bodyToMono(Street.class);
        Street sendStreet  = new Street();
        obtainStreet.map( str ->{
            sendStreet.setStreetId(str.getStreetId());
            sendStreet.setStreetType(str.getStreetType());
            sendStreet.setStreetName(str.getStreetName());
            return sendStreet;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(streetService.selectStreet(sendStreet), Street.class);
    }

    public Mono<ServerResponse> createStreet(ServerRequest request){
        Mono<Street> street = request.bodyToMono(Street.class);

        return street.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(streetService.createStreet(s), Street.class));
    }

    public Mono<ServerResponse> createMultipleStreet(ServerRequest request){
        List<Street>streetList = new ArrayList<>();

        var obtainListStreets = request.bodyToFlux(Street.class);
        obtainListStreets.collectList().map(
                strc ->{
                    System.out.println("STRC: "+strc);
                    streetList.addAll(strc);
                    System.out.println("STREET_LIST: "+streetList);
                    return streetList;
                }
        ).subscribe(System.out::println);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(streetService.createMultipleStreet(streetList), Street.class);
    }

    public Mono<ServerResponse> updateStreet(ServerRequest request){
        Mono<Street> street = request.bodyToMono(Street.class);
        return street.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(streetService.updateStreet(s), Street.class));
    }


    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = streetService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Street.class);
    }
}
