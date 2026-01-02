package com.democracy.electoral_court.application.usecases.investigationresult;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import com.democracy.electoral_court.domain.ports.in.investigationresult.ObtainInvestigationResultIn;
import com.democracy.electoral_court.domain.ports.out.InvestigationResultOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ObtainInvestigationResultUseCase implements ObtainInvestigationResultIn {

    private final InvestigationResultOut investigationResultOut;

    public ObtainInvestigationResultUseCase(InvestigationResultOut investigationResultOut) {
        this.investigationResultOut = investigationResultOut;
    }

    @Override
    public Flux<InvestigationResult> obtainInvestigationResult(int cedula) {
        return investigationResultOut.obtainInvestigationResult(cedula);
    }
}
