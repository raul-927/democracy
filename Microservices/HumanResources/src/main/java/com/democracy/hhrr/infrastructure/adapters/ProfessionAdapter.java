package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.ProfessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ProfessionAdapter implements ProfessionOut {

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public Mono<?> createProfession(Profession profession) {
        return professionMapper.insert(profession);
    }

    @Override
    public Mono<?> createMultipleProfessions(List<Profession> professionList) {
        return professionMapper.insertMultiple(professionList);
    }

    @Override
    public Mono<Integer> deleteProfession(String professionId) {
        return professionMapper.deleteProfession(professionId);
    }

    @Override
    public Flux<Profession> selectProfession(Profession profession) {
        return professionMapper.selectProfession(profession);
    }

    @Override
    public Flux<Profession> selectAllProfessions() {
        return professionMapper.selectAllProfessions();
    }

    @Override
    public Mono<Long> selectCount() {
        return professionMapper.count();
    }

    @Override
    public Mono<Integer> updateProfession(Profession profession) {
        return professionMapper.updateAllByPrimaryKey(profession);
    }
}
