package com.democracy.hhrr.application.usecases.profession;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.ports.in.profession.SelectProfessionIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectProfessionUseCase implements SelectProfessionIn {

    private final ProfessionOut professionOut;

    public SelectProfessionUseCase(ProfessionOut professionOut) {
        this.professionOut = professionOut;
    }

    @Override
    public Flux<Profession> selectProfession(Profession profession) {
        return this.professionOut.selectProfession(profession);
    }

    @Override
    public Flux<Profession> selectAllProfessions() {
        return this.professionOut.selectAllProfessions();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.professionOut.selectCount();
    }
}
