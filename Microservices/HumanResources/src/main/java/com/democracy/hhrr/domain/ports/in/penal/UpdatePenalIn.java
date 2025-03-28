package com.democracy.hhrr.domain.ports.in.penal;

import com.democracy.hhrr.domain.models.Penal;
import reactor.core.publisher.Mono;

public interface UpdatePenalIn {

    Mono<Integer> updateDocument(Penal penal);
}
