package com.democracy.hhrr.domain.ports.reactive.in.person;

import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Mono;

public interface UpdatePersonIn {

    Mono<Integer> updatePerson(Person person);
}
