package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.out.PenalOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.PenalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PenalAdapter implements PenalOut {

    @Autowired
    private PenalMapper penalMapper;

    @Override
    public Mono<?> createPenal(Penal penal) {
        return penalMapper.insert(penal);
    }

    @Override
    public Mono<?> createMultiplePenals(List<Penal> penalList) {
        return this.penalMapper.insertMultiple(penalList);
    }

    @Override
    public Mono<Integer> deletePenal(String penalId) {
        return this.penalMapper.deletePenal(penalId);
    }

    @Override
    public Flux<Penal> selectPenal(Penal penal) {
        return this.penalMapper.selectPenal(penal);
    }

    @Override
    public Flux<Penal> selectAllPenals() {
        return this.penalMapper.selectAllPenals();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.penalMapper.count();
    }

    @Override
    public Mono<Integer> updateDocument(Penal penal) {
        return this.penalMapper.updateSelectiveByPrimaryKey(penal);
    }
}
