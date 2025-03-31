package com.democracy.hhrr.application.usecases.profession;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateProfessionUseCase implements CreateProfessionIn {
    private final ProfessionOut professionOut;

    public CreateProfessionUseCase(ProfessionOut professionOut) {
        this.professionOut = professionOut;
    }

    @Override
    public Mono<?> createProfession(Profession profession) {
        return this.professionOut.createProfession(profession);
    }

    @Override
    public Mono<?> createMultipleProfessions(List<Profession> professionList) {
        return this.professionOut.createMultipleProfessions(professionList);
    }
}
