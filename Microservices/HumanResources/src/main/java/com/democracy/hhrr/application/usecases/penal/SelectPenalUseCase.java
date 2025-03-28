package com.democracy.hhrr.application.usecases.penal;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.in.penal.SelectPenalIn;
import com.democracy.hhrr.domain.ports.out.PenalOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectPenalUseCase implements SelectPenalIn {
    private final PenalOut penalOut;

    public SelectPenalUseCase(PenalOut penalOut) {
        this.penalOut = penalOut;
    }

    @Override
    public Flux<Penal> selectPenal(Penal penal) {
        return this.penalOut.selectPenal(penal);
    }

    @Override
    public Flux<Penal> selectAllPenals() {
        return this.penalOut.selectAllPenals();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.penalOut.selectCount();
    }
}
