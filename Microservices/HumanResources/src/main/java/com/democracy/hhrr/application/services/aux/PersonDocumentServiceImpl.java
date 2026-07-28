package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.domain.ports.reactive.in.aux.persondocument.CreatePersonDocumentIn;
import com.democracy.hhrr.domain.ports.reactive.in.aux.persondocument.SelectPersonDocumentIn;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PersonDocumentServiceImpl implements PersonDocumentService{

    private final CreatePersonDocumentIn createPersonDocumentIn;
    private final SelectPersonDocumentIn selectPersonDocumentIn;

    public PersonDocumentServiceImpl(CreatePersonDocumentIn createPersonDocumentIn, SelectPersonDocumentIn selectPersonDocumentIn) {
        this.createPersonDocumentIn = createPersonDocumentIn;
        this.selectPersonDocumentIn = selectPersonDocumentIn;
    }

    @Override
    public Mono<Integer> createPersonDocument(PersonDocument personDocument) {
        return createPersonDocumentIn.createPersonDocument(personDocument);
    }

    @Override
    public Mono<?> createMultiplePersonDocuments(List<PersonDocument> personDocuments) {
        return createPersonDocumentIn.createMultiplePersonDocuments(personDocuments);
    }

    @Override
    public Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument) {
        return selectPersonDocumentIn.selectPersonDocument(personDocument);
    }

    @Override
    public Flux<PersonDocument> selectAllPersonDocuments() {
        return selectPersonDocumentIn.selectAllPersonDocuments();
    }

    @Override
    public Mono<Long> selectCount() {
        return selectPersonDocumentIn.selectCount();
    }
}
