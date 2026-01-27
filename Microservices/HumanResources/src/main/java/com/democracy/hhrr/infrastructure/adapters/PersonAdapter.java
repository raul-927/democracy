package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.ports.out.PersonOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Component
public class PersonAdapter implements PersonOut {

    @Autowired
    private PersonMapper personMapper;


    @Override
    public Mono<?> createPerson(Person person) {
        return personMapper.insert(person);
    }

    @Override
    public Mono<?> createMultiplePersons(List<Person> personList) {
        return personMapper.insertMultiple(personList);
    }

    @Override
    public Mono<Integer> deletePerson(String personId) {
        return personMapper.deletePerson(personId);
    }

    @Override
    public Flux<Person> selectPerson(Person person) {
        return personMapper.selectPerson(person);
    }

    @Override
    public Flux<Person> selectAllPersons() {
        return personMapper.selectAllPersons();
    }

    @Override
    public Mono<Long> selectCount() {
        return personMapper.count();
    }

    @Override
    public Mono<Integer> updatePerson(Person person) {
        return personMapper.updateAllByPrimaryKey(person);
    }
}
