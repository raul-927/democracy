package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.PersonService;
import com.democracy.hhrr.application.services.ProfessionService;
import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.models.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

//@RestController
//@RequestMapping("/humanresources/profession")
//@RefreshScope
public class ProfessionController {

    //@Autowired
    private ProfessionService professionService;

    /*@PostMapping(
           value = "/select",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE})*/
    public Flux<Profession> selectPerson(@RequestBody Profession profession){
        return this.professionService.selectProfession(profession);
    }
}
