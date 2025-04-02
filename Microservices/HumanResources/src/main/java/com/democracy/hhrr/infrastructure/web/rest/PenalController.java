package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.PenalService;
import com.democracy.hhrr.domain.models.Penal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/penal")
@RefreshScope
public class PenalController{
    @Autowired
    private PenalService penalService;

    @PostMapping(
           value = "/select",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Penal> selectPenal(Penal penal){
        return this.penalService.selectPenal(penal);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<?> createPenal(@RequestBody Penal penal){
        return this.penalService.createPenal(penal);
    }


    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<?>createMultiplePenal(List<Penal> penalList){
        return this.penalService.createMultiplePenals(penalList);
    }

    @PostMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer>updatePenal(Penal penal){
        return this.penalService.updatePenal(penal);
    }


    @DeleteMapping(
            value="/delete/{penalId}",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer>deletePenal(@PathVariable String penalId){
        return this.penalService.deletePenal(penalId);
    }

}
