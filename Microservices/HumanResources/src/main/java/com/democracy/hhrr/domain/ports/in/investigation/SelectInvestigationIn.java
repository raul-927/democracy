package com.democracy.hhrr.domain.ports.in.investigation;

import com.democracy.hhrr.domain.models.Investigation;

public interface SelectInvestigationIn {

    Investigation selectInvestigation(Investigation investigation);
}
