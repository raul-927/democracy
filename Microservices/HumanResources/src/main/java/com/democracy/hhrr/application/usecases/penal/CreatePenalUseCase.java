package com.democracy.hhrr.application.usecases.penal;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.in.penal.CreatePenalIn;
import com.democracy.hhrr.domain.ports.out.PenalOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreatePenalUseCase implements CreatePenalIn {
    private final PenalOut penalOut;

    public CreatePenalUseCase(PenalOut penalOut) {
        this.penalOut = penalOut;
    }

    @Override
    public Mono<?> createPenal(Penal penal) {
        return this.penalOut.createPenal(penal);
    }

    @Override
    public Mono<?> createMultiplePenals(List<Penal> penalList) {
        return this.penalOut.createMultiplePenals(penalList);
    }
}
