package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.reactive.in.investigation.CreateInvestigationIn;
import com.democracy.hhrr.domain.ports.reactive.in.investigation.SelectInvestigationIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InvestigationServiceImpl implements InvestigationService{

    private final SelectInvestigationIn selectInvestigationIn;
    private final CreateInvestigationIn createInvestigationIn;

    public InvestigationServiceImpl(SelectInvestigationIn selectInvestigationIn, CreateInvestigationIn createInvestigationIn) {
        this.selectInvestigationIn = selectInvestigationIn;
        this.createInvestigationIn = createInvestigationIn;
    }

    @Override
    public Flux<Investigation> selectInvestigation(Investigation investigation) {
        return this.selectInvestigationIn.selectInvestigation(investigation);
    }

    @Override
    public Mono<Integer> createInvestigation(Investigation investigation) {
        return this.createInvestigationIn.createInvestigation(investigation);
    }
}
