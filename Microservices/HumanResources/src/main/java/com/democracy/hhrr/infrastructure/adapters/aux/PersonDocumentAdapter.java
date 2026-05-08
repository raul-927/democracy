package com.democracy.hhrr.infrastructure.adapters.aux;

import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.domain.ports.out.aux.PersonDocumentOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux.PersonDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PersonDocumentAdapter implements PersonDocumentOut {

    @Autowired
    private PersonDocumentMapper mapper;


    @Override
    public Mono<Integer> createPersonDocument(PersonDocument personDocument) {
        return mapper.insert(personDocument);
    }

    @Override
    public Mono<?> createMultiplePersonDocuments(List<PersonDocument> personDocuments) {
        return mapper.insertMultiple(personDocuments);
    }

    @Override
    public Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument) {
        return mapper.selectPersonDocument(personDocument);
    }

    @Override
    public Flux<PersonDocument> selectAllPersonDocuments() {
        return null;
    }

    @Override
    public Mono<Long> selectCount() {
        return mapper.count();
    }
}
