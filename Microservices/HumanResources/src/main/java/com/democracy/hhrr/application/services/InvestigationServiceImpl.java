package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.in.investigation.SelectInvestigationIn;
import org.springframework.stereotype.Service;

@Service
public class InvestigationServiceImpl implements InvestigationService{

    private final SelectInvestigationIn selectInvestigationIn;

    public InvestigationServiceImpl(SelectInvestigationIn selectInvestigationIn) {
        this.selectInvestigationIn = selectInvestigationIn;
    }

    @Override
    public Investigation selectInvestigation(Investigation investigation) {
        return this.selectInvestigationIn.selectInvestigation(investigation);
    }
}
