package com.democracy.hhrr.domain.ports.reactive.in.investigation;

import com.democracy.hhrr.domain.models.Investigation;
import reactor.core.publisher.Flux;

public interface SelectInvestigationIn {

    Flux<Investigation> selectInvestigation(Investigation investigation);
}
