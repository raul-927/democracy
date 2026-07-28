package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.reactive.in.investigation.CreateInvestigationIn;
import com.democracy.hhrr.domain.ports.reactive.in.investigation.SelectInvestigationIn;

public interface InvestigationService extends SelectInvestigationIn, CreateInvestigationIn {
}
