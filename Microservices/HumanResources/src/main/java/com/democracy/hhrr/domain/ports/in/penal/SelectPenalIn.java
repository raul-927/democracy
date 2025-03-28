package com.democracy.hhrr.domain.ports.in.penal;

import com.democracy.hhrr.domain.models.Penal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectPenalIn {

    Flux<Penal> selectPenal(Penal penal);
    Flux<Penal> selectAllPenals();
    Mono<Long> selectCount();
}
