package com.democracy.electoral_court.application.services;


import com.democracy.electoral_court.domain.models.InvestigationResult;
import com.democracy.electoral_court.domain.ports.in.investigationresult.CreateInvestigationResultIn;
import com.democracy.electoral_court.domain.ports.in.investigationresult.ObtainInvestigationResultIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvestigationResultServiceImpl implements InvestigationResultService{

    private final CreateInvestigationResultIn createInvestigationResultIn;
    private final ObtainInvestigationResultIn obtainInvestigationResultIn;

    public InvestigationResultServiceImpl(CreateInvestigationResultIn createInvestigationResultIn, ObtainInvestigationResultIn obtainInvestigationResultIn) {
        this.createInvestigationResultIn = createInvestigationResultIn;
        this.obtainInvestigationResultIn = obtainInvestigationResultIn;
    }

    @Override
    public Mono<Integer> createInvestigationResult(InvestigationResult investigationResult) {
        return this.createInvestigationResultIn.createInvestigationResult(investigationResult);
    }

    @Override
    public Flux<InvestigationResult> obtainInvestigationResult(int cedula) {
        return obtainInvestigationResultIn.obtainInvestigationResult(cedula);
    }
}
