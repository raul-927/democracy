package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.PersonService;
import com.democracy.hhrr.domain.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/humanresources/person")
@RefreshScope
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(
           value = "/select",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Person> selectPerson(@RequestBody Person person){
        return this.personService.selectPerson(person);
    }

    @GetMapping(
            value = "/count",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCountPersonIsNotProcessed(){
        return this.personService.selectCountPersonIsNotProcessed();
    }
}
