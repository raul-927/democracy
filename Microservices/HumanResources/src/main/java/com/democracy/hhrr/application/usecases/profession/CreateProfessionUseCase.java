package com.democracy.hhrr.application.usecases.profession;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreateProfessionUseCase implements CreateProfessionIn {
    private final ProfessionOut professionOut;

    public CreateProfessionUseCase(ProfessionOut professionOut) {
        this.professionOut = professionOut;
    }

    @Override
    public Mono<?> createProfession(Profession profession) {
        profession.setProfessionId(UUID.randomUUID().toString());
        return this.professionOut.createProfession(profession);
    }

    @Override
    public Mono<?> createMultipleProfessions(List<Profession> professionList) {
        professionList.forEach(prof->{
            prof.setProfessionId(UUID.randomUUID().toString());
        });
        return this.professionOut.createMultipleProfessions(professionList);
    }
}
