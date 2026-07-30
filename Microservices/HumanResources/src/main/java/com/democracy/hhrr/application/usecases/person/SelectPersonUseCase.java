package com.democracy.hhrr.application.usecases.person;

import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.ports.in.person.SelectPersonIn;
import com.democracy.hhrr.domain.ports.out.PersonOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectPersonUseCase implements SelectPersonIn {
    private final PersonOut personOut;

    public SelectPersonUseCase(PersonOut personOut) {
        this.personOut = personOut;
    }

    @Override
    public Flux<Person> selectPerson(Person person) {
        return this.personOut.selectPerson(person);
    }

    @Override
    public Flux<Person> selectAllPersons() {
        return this.personOut.selectAllPersons();
    }

    @Override
    public Mono<Long> selectCountPersonIsNotProcessed() {
        return this.personOut.selectCountPersonIsNotProcessed();
    }
}
