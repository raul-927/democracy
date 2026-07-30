package com.democracy.hhrr.application.usecases.profession;

import com.democracy.hhrr.domain.ports.in.profession.DeleteProfessionIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteProfessionUseCase implements DeleteProfessionIn {

    private final ProfessionOut professionOut;

    public DeleteProfessionUseCase(ProfessionOut professionOut) {
        this.professionOut = professionOut;
    }


    @Override
    public Mono<Integer> deleteProfession(String professionId) {
        return this.professionOut.deleteProfession(professionId);
    }
}
