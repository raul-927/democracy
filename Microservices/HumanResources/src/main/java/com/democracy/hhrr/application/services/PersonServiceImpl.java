package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.ports.in.person.CreatePersonIn;
import com.democracy.hhrr.domain.ports.in.person.DeletePersonIn;
import com.democracy.hhrr.domain.ports.in.person.SelectPersonIn;
import com.democracy.hhrr.domain.ports.in.person.UpdatePersonIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private final CreatePersonIn createPersonIn;
    private final DeletePersonIn deletePersonIn;
    private final SelectPersonIn selectPersonIn;
    private final UpdatePersonIn updatePersonIn;

    public PersonServiceImpl(CreatePersonIn createPersonIn, DeletePersonIn deletePersonIn, SelectPersonIn selectPersonIn, UpdatePersonIn updatePersonIn) {
        this.createPersonIn = createPersonIn;
        this.deletePersonIn = deletePersonIn;
        this.selectPersonIn = selectPersonIn;
        this.updatePersonIn = updatePersonIn;
    }

    @Override
    public Mono<?> createPerson(Person person) {
        return this.createPersonIn.createPerson(person);
    }

    @Override
    public Mono<?> createMultiplePersons(List<Person> personList) {
        return this.createPersonIn.createMultiplePersons(personList);
    }

    @Override
    public Mono<Integer> deletePerson(String personId) {
        return this.deletePersonIn.deletePerson(personId);
    }

    @Override
    public Flux<Person> selectPerson(Person person) {
        return this.selectPersonIn.selectPerson(person);
    }

    @Override
    public Flux<Person> selectAllPersons() {
        return this.selectPersonIn.selectAllPersons();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectPersonIn.selectCount();
    }

    @Override
    public Mono<Integer> updatePerson(Person person) {
        return this.updatePersonIn.updatePerson(person);
    }
}
