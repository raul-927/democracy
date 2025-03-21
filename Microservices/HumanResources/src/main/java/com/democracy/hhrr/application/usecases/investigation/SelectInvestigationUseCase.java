package com.democracy.hhrr.application.usecases.investigation;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.in.investigation.SelectInvestigationIn;
import com.democracy.hhrr.domain.ports.out.InvestigationOut;
import org.springframework.stereotype.Component;

@Component
public class SelectInvestigationUseCase implements SelectInvestigationIn {

    private final InvestigationOut investigationOut;

    public SelectInvestigationUseCase(InvestigationOut investigationOut) {
        this.investigationOut = investigationOut;
    }

    @Override
    public Investigation selectInvestigation(Investigation investigation) {
        return this.investigationOut.selectInvestigation(investigation);
    }
}
