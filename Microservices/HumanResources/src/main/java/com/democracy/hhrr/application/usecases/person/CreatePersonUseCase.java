package com.democracy.hhrr.application.usecases.person;

import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.ports.in.person.CreatePersonIn;
import com.democracy.hhrr.domain.ports.in.profession.CreateProfessionIn;
import com.democracy.hhrr.domain.ports.out.PersonOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreatePersonUseCase implements CreatePersonIn {
    private final PersonOut personOut;

    public CreatePersonUseCase(PersonOut personOut) {
        this.personOut = personOut;
    }

    @Override
    public Mono<?> createPerson(Person person) {
        person.setPersonId(UUID.randomUUID().toString());
        return this.personOut.createPerson(person);
    }

    @Override
    public Mono<?> createMultiplePersons(List<Person> personList) {
        personList.forEach(per->{
            per.setPersonId(UUID.randomUUID().toString());
        });
        return this.personOut.createMultiplePersons(personList);
    }
}
