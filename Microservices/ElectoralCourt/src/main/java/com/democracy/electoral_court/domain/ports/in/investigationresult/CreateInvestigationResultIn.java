package com.democracy.electoral_court.domain.ports.in.investigationresult;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import reactor.core.publisher.Mono;

public interface CreateInvestigationResultIn {
    Mono<Integer> createInvestigationResult(InvestigationResult investigationResult);
}
