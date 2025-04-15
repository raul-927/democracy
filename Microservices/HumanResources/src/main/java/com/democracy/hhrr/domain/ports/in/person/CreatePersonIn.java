package com.democracy.hhrr.domain.ports.in.person;

import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreatePersonIn {

    Mono<?> createPerson(Person person);
    Mono<?>createMultiplePersons(List<Person> personList);
}
