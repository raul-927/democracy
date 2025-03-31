package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.DeleteProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.SelectProfessionIn;
import com.democracy.hhrr.domain.ports.in.profession.UpdateProfessionIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService{

    private final CreateProfessionIn createProfessionIn;
    private final DeleteProfessionIn deleteProfessionIn;
    private final SelectProfessionIn selectProfessionIn;
    private final UpdateProfessionIn updateProfessionIn;

    public ProfessionServiceImpl(CreateProfessionIn createProfessionIn, DeleteProfessionIn deleteProfessionIn, SelectProfessionIn selectProfessionIn, UpdateProfessionIn updateProfessionIn) {
        this.createProfessionIn = createProfessionIn;
        this.deleteProfessionIn = deleteProfessionIn;
        this.selectProfessionIn = selectProfessionIn;
        this.updateProfessionIn = updateProfessionIn;
    }


    @Override
    public Mono<?> createProfession(Profession profession) {
        return this.createProfessionIn.createProfession(profession);
    }

    @Override
    public Mono<?> createMultipleProfessions(List<Profession> professionList) {
        return this.createProfessionIn.createMultipleProfessions(professionList);
    }

    @Override
    public Mono<Integer> deleteProfession(String professionId) {
        return this.deleteProfessionIn.deleteProfession(professionId);
    }

    @Override
    public Flux<Profession> selectProfession(Profession profession) {
        return this.selectProfessionIn.selectProfession(profession);
    }

    @Override
    public Flux<Profession> selectAllProfessions() {
        return this.selectProfessionIn.selectAllProfessions();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectProfessionIn.selectCount();
    }

    @Override
    public Mono<Integer> updateProfession(Profession profession) {
        return this.updateProfessionIn.updateProfession(profession);
    }
}
