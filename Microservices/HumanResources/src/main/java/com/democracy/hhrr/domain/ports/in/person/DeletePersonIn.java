package com.democracy.hhrr.domain.ports.in.person;

import reactor.core.publisher.Mono;

public interface DeletePersonIn {
    Mono<Integer> deletePerson(String personId);
}
