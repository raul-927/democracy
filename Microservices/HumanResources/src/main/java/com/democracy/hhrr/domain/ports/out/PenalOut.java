package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Penal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PenalOut {

    Mono<?> createPenal(Penal penal);
    Mono<?>createMultiplePenals(List<Penal> penalList);
    Mono<Integer> deletePenal(String penalId);
    Flux<Penal> selectPenal(Penal penal);
    Flux<Penal> selectAllPenals();
    Mono<Long> selectCount();
    Mono<Integer> updateDocument(Penal penal);
}
