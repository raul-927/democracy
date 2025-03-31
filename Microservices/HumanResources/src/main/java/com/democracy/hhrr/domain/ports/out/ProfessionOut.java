package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Profession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProfessionOut {

    Mono<?> createProfession(Profession profession);
    Mono<?>createMultipleProfessions(List<Profession> professionList);
    Mono<Integer> deleteProfession(String professionId);
    Flux<Profession> selectProfession(Profession profession);
    Flux<Profession> selectAllProfessions();
    Mono<Long> selectCount();
    Mono<Integer> updateProfession(Profession profession);
}
