package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.ProfessionService;
import com.democracy.hhrr.domain.models.Profession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ProfessionHandler {


    @Autowired
    private ProfessionService professionService;

    public Mono<ServerResponse> selectProfession(ServerRequest request){
        var obtainProfession = request.bodyToMono(Profession.class);
        Profession sendProfession  = new Profession();
        obtainProfession.map( prf ->{
            sendProfession.setProfessionId(prf.getProfessionId());
            sendProfession.setProfessionName(prf.getProfessionName());
            System.out.println("SEND_PROFESSION: "+sendProfession);
            return sendProfession;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(professionService.selectProfession(sendProfession), Profession.class);
    }

    public Mono<ServerResponse> createProfession(ServerRequest request){
        Mono<Profession> profession = request.bodyToMono(Profession.class);

        return profession.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(professionService.createProfession(s), Profession.class));
    }
}
