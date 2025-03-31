package com.democracy.hhrr.domain.ports.in.profession;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.models.Profession;
import reactor.core.publisher.Mono;

public interface UpdateProfessionIn {

    Mono<Integer> updateProfession(Profession profession);
}
