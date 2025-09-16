package com.democracy.hhrr.domain.ports.in.investigation;

import com.democracy.hhrr.domain.models.Investigation;
import reactor.core.publisher.Mono;

public interface CreateInvestigationIn {

    Mono<Integer> createInvestigation(Investigation investigation);
}
