package com.democracy.hhrr.application.usecases.person;

import com.democracy.hhrr.domain.ports.in.person.DeletePersonIn;
import com.democracy.hhrr.domain.ports.out.PersonOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeletePersonUseCase implements DeletePersonIn {

    private final PersonOut personOut;

    public DeletePersonUseCase(PersonOut personOut) {
        this.personOut = personOut;
    }

    @Override
    public Mono<Integer> deletePerson(String personId) {
        return this.personOut.deletePerson(personId);
    }
}
