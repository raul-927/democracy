package com.democracy.hhrr.domain.ports.in.penal;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.models.Street;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreatePenalIn {

    Mono<?> createPenal(Penal penal);
    Mono<?>createMultiplePenals(List<Penal> penalList);
}
