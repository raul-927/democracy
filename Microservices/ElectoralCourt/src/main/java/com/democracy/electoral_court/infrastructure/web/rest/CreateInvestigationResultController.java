package com.democracy.electoral_court.infrastructure.web.rest;


import com.democracy.electoral_court.application.services.InvestigationResultService;
import com.democracy.electoral_court.domain.models.Investigation;
import com.democracy.electoral_court.domain.models.InvestigationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/electoralcourt/investigationresult")
@RefreshScope
public class CreateInvestigationResultController {

    @Autowired
    private InvestigationResultService investigationResultService;

    @PostMapping(
            value = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertInvestigation(@RequestBody InvestigationResult investigation){
        Flux<InvestigationResult> investigationFlux = Flux.just(investigation);
        investigationFlux.subscribe( ret ->{
            System.out.println("INVESTIGATION_RESULT: "+ret);
        });
        return  investigationResultService.createInvestigationResult(investigation);
    }

}
