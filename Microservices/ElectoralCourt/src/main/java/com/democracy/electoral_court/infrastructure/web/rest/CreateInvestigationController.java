package com.democracy.electoral_court.infrastructure.web.rest;


import com.democracy.electoral_court.domain.models.Investigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/electoralcourt/investigation")
@RefreshScope
public class CreateInvestigationController {

    @PostMapping(
            value = "/insert",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})

    public Investigation insertInvestigation(/*@RequestBody*/ Investigation investigation){
        System.out.println("INVESTIGATION: "+investigation);
        return investigation;
    }


}
