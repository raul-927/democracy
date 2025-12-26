package com.democracy.electoral_court.application.services;


import com.democracy.electoral_court.domain.models.InvestigationResult;
import com.democracy.electoral_court.domain.ports.in.investigationresult.CreateInvestigationResultIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class InvestigationResultServiceImpl implements InvestigationResultService{

    private final CreateInvestigationResultIn createInvestigationResultIn;

    public InvestigationResultServiceImpl(CreateInvestigationResultIn createInvestigationResultIn) {
        this.createInvestigationResultIn = createInvestigationResultIn;
    }

    @Override
    public Mono<Integer> createInvestigationResult(InvestigationResult investigationResult) {
        return this.createInvestigationResultIn.createInvestigationResult(investigationResult);
    }
}
