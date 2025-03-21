package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.out.InvestigationOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.InvestigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class InvestigationAdapter implements InvestigationOut {

    //@Autowired
    private InvestigationMapper investigationMapper;

    @Override
    public Investigation selectInvestigation(Investigation investigation) {
        return null;
    }
}
