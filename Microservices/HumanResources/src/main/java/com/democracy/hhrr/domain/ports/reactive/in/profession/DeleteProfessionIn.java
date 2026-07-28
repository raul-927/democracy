package com.democracy.hhrr.domain.ports.reactive.in.profession;

import reactor.core.publisher.Mono;

public interface DeleteProfessionIn {
    Mono<Integer> deleteProfession(String professionId);
}
