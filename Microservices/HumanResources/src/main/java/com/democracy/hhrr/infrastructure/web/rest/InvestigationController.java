package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.InvestigationService;
import com.democracy.hhrr.domain.models.Investigation;
import org.springframework.web.bind.annotation.RequestBody;
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
