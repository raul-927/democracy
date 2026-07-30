package com.democracy.hhrr.application.usecases.penal;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.in.penal.UpdatePenalIn;
import com.democracy.hhrr.domain.ports.out.PenalOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdatePenalUseCase implements UpdatePenalIn {
    private final PenalOut penalOut;

    public UpdatePenalUseCase(PenalOut penalOut) {
        this.penalOut = penalOut;
    }

    @Override
    public Mono<Integer> updatePenal(Penal penal) {
        return this.penalOut.updateDocument(penal);
    }
}
