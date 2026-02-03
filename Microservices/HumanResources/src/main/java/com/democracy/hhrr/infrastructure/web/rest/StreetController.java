package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.StreetService;
import com.democracy.hhrr.domain.models.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/humanresources/street")
@RefreshScope
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping(
            value = "/select",
            produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Street> selectStreet(){

        return this.streetService.selectStreet(new Street())
                .delayElements(Duration.ofSeconds(1))
                .map(m -> new Street(m.getStreetId(), m.getStreetName(), m.getStreetType()))
                .doOnNext(d->{
                    System.out.println("STREET: "+d);
        });
    }


    @GetMapping(
            value = "/selectp", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<String> selectStreetp(){
        return Flux.interval(Duration.ofSeconds(1))
                .doOnNext(index ->System.out.println("Event " + (index + 1) +", "))
                .map(index -> "Event " + (index + 1) +", ")
                .take(10);
    }

    //@PostMapping(
      //      value="/save",
      //      consumes ={MediaType.APPLICATION_JSON_VALUE},
      //      produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<?> createStreet(@RequestBody Street street){
        return this.streetService.createStreet(street);
    }

    /*@PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Mono<?> insertMultiple(@RequestBody List<Street> street){
        return streetService.createMultipleStreet(street);
    }

    //@PutMapping(
     //       value="/update",
      //      consumes ={MediaType.APPLICATION_JSON_VALUE},
     //       produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateStreet(@RequestBody Street street){
        return this.streetService.updateStreet(street);
    }

    //@GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCount(){
        return this.streetService.selectCount();
    }

   // @DeleteMapping(value="/delete/{streetId}")
    public Mono<Integer> deleteStreet(@PathVariable String streetId){
        return this.streetService.deleteStreet(streetId);
    }
}
