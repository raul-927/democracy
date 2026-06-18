package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonOut {
    Mono<?> createPerson(Person person);
    Mono<?>createMultiplePersons(List<Person> personList);
    Mono<Integer> deletePerson(String personId);
    Flux<Person> selectPerson(Person person);
    Flux<Person> selectAllPersons();
    Mono<Long> selectCountPersonIsNotProcessed();
    Mono<Integer> updatePerson(Person person);
}
