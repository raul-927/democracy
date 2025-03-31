package com.democracy.hhrr.domain.ports.in.profession;

import com.democracy.hhrr.domain.models.Profession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectProfessionIn {

    Flux<Profession> selectProfession(Profession profession);
    Flux<Profession> selectAllProfessions();
    Mono<Long> selectCount();
}
