package com.democracy.hhrr.application.usecases.penal;

import com.democracy.hhrr.domain.models.Penal;
import com.democracy.hhrr.domain.ports.reactive.in.penal.CreatePenalIn;
import com.democracy.hhrr.domain.ports.reactive.out.PenalOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreatePenalUseCase implements CreatePenalIn {
    private final PenalOut penalOut;

    public CreatePenalUseCase(PenalOut penalOut) {
        this.penalOut = penalOut;
    }

    @Override
    public Mono<?> createPenal(Penal penal) {
        penal.setPenalId(UUID.randomUUID().toString());
        return this.penalOut.createPenal(penal);
    }

    @Override
    public Mono<?> createMultiplePenals(List<Penal> penalList) {
        penalList.forEach(penal -> {
            penal.setPenalId(UUID.randomUUID().toString());
        });
        return this.penalOut.createMultiplePenals(penalList);
    }
}
