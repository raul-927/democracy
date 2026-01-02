package com.democracy.electoral_court.infrastructure.adapters;

import com.democracy.electoral_court.domain.models.InvestigationResult;
import com.democracy.electoral_court.domain.ports.out.InvestigationResultOut;
import com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.mappers.InvestigationResultMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InvestigationResultAdapter implements InvestigationResultOut {

    @Autowired
    private InvestigationResultMapper investigationResultMapper;

    @Override
    public Mono<Integer> createInvestigationResult(InvestigationResult investigationResult) {
        return investigationResultMapper.insertInvestigationResult(investigationResult);
    }

    @Override
    public Flux<InvestigationResult> obtainInvestigationResult(int cedula) {
        InvestigationResult result = new InvestigationResult();
        result.setCedula(cedula);
        return investigationResultMapper.selectInvestigationResult(result);
    }
}
