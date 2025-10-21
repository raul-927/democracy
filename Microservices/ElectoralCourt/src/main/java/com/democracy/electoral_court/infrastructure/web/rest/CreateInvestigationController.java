package com.democracy.electoral_court.infrastructure.web.rest;


import com.democracy.electoral_court.domain.models.Investigation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/electoralcourt/investigation")
@RefreshScope
public class CreateInvestigationController {

    @PostMapping(
            value = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})

    public Flux<Investigation> insertInvestigation(@RequestBody Investigation investigation){
        Flux<Investigation> investigationFlux = Flux.just(investigation);

        investigationFlux.subscribe( ret ->{
            System.out.println("INVESTIGATION: "+ret);
        });
        return investigationFlux;
    }


}
