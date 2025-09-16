package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Investigation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InvestigationOut {
    Flux<Investigation> selectInvestigation(Investigation investigation);
    Mono<Integer> createInvestigation(Investigation investigation);
}
