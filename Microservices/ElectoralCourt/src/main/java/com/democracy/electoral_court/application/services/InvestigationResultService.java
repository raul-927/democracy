package com.democracy.electoral_court.application.services;

import com.democracy.electoral_court.domain.ports.in.investigationresult.CreateInvestigationResultIn;
import com.democracy.electoral_court.domain.ports.in.investigationresult.ObtainInvestigationResultIn;

public interface InvestigationResultService extends CreateInvestigationResultIn, ObtainInvestigationResultIn {
}
