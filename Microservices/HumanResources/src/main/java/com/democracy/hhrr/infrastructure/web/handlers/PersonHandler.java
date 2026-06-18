package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.PersonService;
import com.democracy.hhrr.application.services.ProfessionService;
import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.models.Profession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PersonHandler {

    @Autowired
    private PersonService personService;


    public Mono<ServerResponse> selectPerson(ServerRequest request){
        var obtainPerson = request.bodyToFlux(Person.class);
        Person sendPerson  = new Person();
        obtainPerson.map( pers ->{
            sendPerson.setPersonId(pers.getPersonId());
            sendPerson.setCedula(pers.getCedula());
            sendPerson.setCivicCredential(pers.getCivicCredential());
            sendPerson.setFirstName(pers.getFirstName());
            sendPerson.setSecondName(pers.getSecondName());
            sendPerson.setFirstLastName(pers.getFirstLastName());
            sendPerson.setSecondLastName(pers.getSecondLastName());
            sendPerson.setIsProcessed(pers.getIsProcessed());
            sendPerson.setAddress(pers.getAddress());
            sendPerson.setProfession(pers.getProfession());

            return sendPerson;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.selectPerson(sendPerson), Person.class);
    }

    public Mono<ServerResponse> createPerson(ServerRequest request){
        Mono<Person> person = request.bodyToMono(Person.class);

        return person.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(personService.createPerson(s), Person.class));
    }

    public Mono<ServerResponse> updatePerson(ServerRequest request){
        Mono<Person> person = request.bodyToMono(Person.class);

        return person.flatMap(
                s ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(personService.updatePerson(s), Person.class));
    }

    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = personService.selectCountPersonIsNotProcessed();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Person.class);
    }
}
