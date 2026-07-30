package com.democracy.hhrr.application.usecases.penal;

import com.democracy.hhrr.domain.ports.in.penal.DeletePenalIn;
import com.democracy.hhrr.domain.ports.out.PenalOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeletePenalUseCase implements DeletePenalIn {

    private final PenalOut penalOut;

    public DeletePenalUseCase(PenalOut penalOut) {
        this.penalOut = penalOut;
    }

    @Override
    public Mono<Integer> deletePenal(String penalId) {
        return this.penalOut.deletePenal(penalId);
    }
}
