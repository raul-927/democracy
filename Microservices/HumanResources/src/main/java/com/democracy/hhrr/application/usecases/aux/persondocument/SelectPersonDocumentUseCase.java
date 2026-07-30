package com.democracy.hhrr.application.usecases.aux.persondocument;

import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.domain.ports.in.aux.persondocument.SelectPersonDocumentIn;
import com.democracy.hhrr.domain.ports.out.aux.PersonDocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectPersonDocumentUseCase implements SelectPersonDocumentIn {

    private final PersonDocumentOut personDocumentOut;

    public SelectPersonDocumentUseCase(PersonDocumentOut personDocumentOut) {
        this.personDocumentOut = personDocumentOut;
    }

    @Override
    public Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument) {
        return personDocumentOut.selectPersonDocument(personDocument);
    }

    @Override
    public Flux<PersonDocument> selectAllPersonDocuments() {
        return personDocumentOut.selectAllPersonDocuments();
    }

    @Override
    public Mono<Long> selectCount() {
        return personDocumentOut.selectCount();
    }
}
