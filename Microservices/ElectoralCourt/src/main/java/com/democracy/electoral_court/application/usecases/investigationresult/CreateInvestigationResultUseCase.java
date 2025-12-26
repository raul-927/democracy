package com.democracy.electoral_court.application.usecases.investigationresult;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import com.democracy.electoral_court.domain.ports.in.investigationresult.CreateInvestigationResultIn;
import com.democracy.electoral_court.domain.ports.out.InvestigationResultOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CreateInvestigationResultUseCase implements CreateInvestigationResultIn {

    private final InvestigationResultOut investigationResultOut;

    public CreateInvestigationResultUseCase(InvestigationResultOut investigationResultOut) {
        this.investigationResultOut = investigationResultOut;
    }

    @Override
    public Mono<Integer> createInvestigationResult(InvestigationResult investigationResult) {
        investigationResult.setInvestigationResultId(UUID.randomUUID().toString());
        return investigationResultOut.createInvestigationResult(investigationResult);
    }
}
