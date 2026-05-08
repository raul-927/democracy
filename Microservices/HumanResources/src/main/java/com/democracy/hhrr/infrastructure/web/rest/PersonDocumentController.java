package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.PersonService;
import com.democracy.hhrr.application.services.aux.PersonDocumentService;
import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/humanresources/person-document")
@RefreshScope
public class PersonDocumentController {

    @Autowired
    private PersonDocumentService personDocumentService;

    @PostMapping(
           value = "/select",
          consumes = {MediaType.APPLICATION_JSON_VALUE},
          produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<PersonDocument> selectPersonDocument(@RequestBody PersonDocument personDocument){
        return this.personDocumentService.selectPersonDocument(personDocument);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Integer> createPersonDocument(@RequestBody PersonDocument personDocument) {
        return personDocumentService.createPersonDocument(personDocument);
    }
}
