package com.democracy.hhrr.application.usecases.profession;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.in.profession.UpdateProfessionIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateProfessionUseCase implements UpdateProfessionIn {

    private final ProfessionOut professionOut;

    public UpdateProfessionUseCase(ProfessionOut professionOut) {
        this.professionOut = professionOut;
    }

    @Override
    public Mono<Integer> updateProfession(Profession profession) {
        return this.professionOut.updateProfession(profession);
    }
}
