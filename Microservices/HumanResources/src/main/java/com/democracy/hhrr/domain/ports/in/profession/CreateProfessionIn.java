package com.democracy.hhrr.domain.ports.in.profession;

import com.democracy.hhrr.domain.models.Profession;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateProfessionIn {

    Mono<?> createProfession(Profession profession);
    Mono<?>createMultipleProfessions(List<Profession> professionList);
}
