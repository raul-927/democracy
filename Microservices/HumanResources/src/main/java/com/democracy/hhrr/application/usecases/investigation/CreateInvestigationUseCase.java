package com.democracy.hhrr.application.usecases.investigation;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.in.investigation.CreateInvestigationIn;
import com.democracy.hhrr.domain.ports.out.InvestigationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateInvestigationUseCase implements CreateInvestigationIn {

    private final InvestigationOut investigationOut;

    public CreateInvestigationUseCase(InvestigationOut investigationOut) {
        this.investigationOut = investigationOut;
    }

    @Override
    public Mono<Integer> createInvestigation(Investigation investigation) {
        return this.investigationOut.createInvestigation(investigation);
    }
}
