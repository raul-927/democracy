package com.democracy.electoral_court.domain.ports.out;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import reactor.core.publisher.Mono;

public interface InvestigationResultOut {
    Mono<Integer> createInvestigationResult(InvestigationResult investigationResult);
}
