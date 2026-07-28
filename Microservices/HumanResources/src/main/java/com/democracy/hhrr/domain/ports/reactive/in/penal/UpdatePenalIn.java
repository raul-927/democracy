package com.democracy.hhrr.domain.ports.reactive.in.penal;

import com.democracy.hhrr.domain.models.Penal;
import reactor.core.publisher.Mono;

public interface UpdatePenalIn {

    Mono<Integer> updatePenal(Penal penal);
}
