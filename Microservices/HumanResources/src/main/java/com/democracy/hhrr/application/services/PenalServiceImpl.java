package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.in.penal.CreatePenalIn;
import com.democracy.hhrr.domain.ports.in.penal.DeletePenalIn;
import com.democracy.hhrr.domain.ports.in.penal.SelectPenalIn;
import com.democracy.hhrr.domain.ports.in.penal.UpdatePenalIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PenalServiceImpl implements PenalService{
    private final CreatePenalIn createPenalIn;
    private final DeletePenalIn deletePenalIn;
    private final SelectPenalIn selectPenalIn;
    private final UpdatePenalIn updatePenalIn;

    public PenalServiceImpl(CreatePenalIn createPenalIn, DeletePenalIn deletePenalIn, SelectPenalIn selectPenalIn, UpdatePenalIn updatePenalIn) {
        this.createPenalIn = createPenalIn;
        this.deletePenalIn = deletePenalIn;
        this.selectPenalIn = selectPenalIn;
        this.updatePenalIn = updatePenalIn;
    }

    @Override
    public Mono<?> createPenal(Penal penal) {
        return this.createPenalIn.createPenal(penal);
    }

    @Override
    public Mono<?> createMultiplePenals(List<Penal> penalList) {
        return this.createPenalIn.createMultiplePenals(penalList);
    }

    @Override
    public Mono<Integer> deletePenal(String penalId) {
        return this.deletePenalIn.deletePenal(penalId);
    }

    @Override
    public Flux<Penal> selectPenal(Penal penal) {
        return this.selectPenalIn.selectPenal(penal);
    }

    @Override
    public Flux<Penal> selectAllPenals() {
        return this.selectPenalIn.selectAllPenals();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectPenalIn.selectCount();
    }

    @Override
    public Mono<Integer> updateDocument(Penal penal) {
        return this.updatePenalIn.updateDocument(penal);
    }
}
