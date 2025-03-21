package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Investigation;

public interface InvestigationOut {
    Investigation selectInvestigation(Investigation investigation);
}
