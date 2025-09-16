package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.InvestigationService;
import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.Investigation;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping("/humanresources/investigation")
//@RefreshScope
public class InvestigationController {


    //@Autowired
    private InvestigationService investigationService;

    /*@PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Mono<Integer> createInvestigation(@RequestBody Investigation investigation){
        return this.investigationService.createInvestigation(investigation);
    }
}
