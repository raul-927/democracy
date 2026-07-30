package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Investigation;
import com.democracy.hhrr.domain.ports.out.InvestigationOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.InvestigationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class InvestigationAdapter implements InvestigationOut {

    @Autowired
    private InvestigationMapper investigationMapper;

    @Override
    public Flux<Investigation> selectInvestigation(Investigation investigation) {
        return null;
    }

    @Override
    public Mono<Integer> createInvestigation(Investigation investigation) {
        return investigationMapper.insert(investigation);
    }
}
