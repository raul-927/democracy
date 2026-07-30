package com.democracy.hhrr.domain.ports.in.person;

import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectPersonIn {

    Flux<Person> selectPerson(Person person);
    Flux<Person> selectAllPersons();
    Mono<Long> selectCountPersonIsNotProcessed();
}
