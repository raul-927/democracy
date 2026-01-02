package com.democracy.electoral_court.domain.ports.in.investigationresult;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import reactor.core.publisher.Flux;

public interface ObtainInvestigationResultIn {
    Flux<InvestigationResult> obtainInvestigationResult(int cedula);
}
