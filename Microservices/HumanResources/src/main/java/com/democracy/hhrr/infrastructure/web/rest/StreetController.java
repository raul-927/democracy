package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.StreetService;
import com.democracy.hhrr.domain.models.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/humanresources/street")
@RefreshScope
public class StreetController {

    @Autowired
    private StreetService streetService;

    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Street> selectStreet(@RequestBody Street street){
        return this.streetService.selectStreet(street);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createStreet(@RequestBody Street street){
        return this.streetService.createStreet(street);
    }

    @GetMapping(value="/select-count")
    public Mono<Long> selectCount(){
        return this.streetService.selectCount();
    }
    @DeleteMapping(value="/delete/{streetId}")
    public void deleteStreet(@PathVariable String streetId){
        this.streetService.deleteStreet(streetId);
    }
}
