package com.democracy.hhrr.application.usecases.aux.persondocument;

import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.domain.ports.in.aux.persondocument.CreatePersonDocumentIn;
import com.democracy.hhrr.domain.ports.out.aux.PersonDocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class CreatePersonDocumentUseCase implements CreatePersonDocumentIn {

    private final PersonDocumentOut personDocumentOut;

    public CreatePersonDocumentUseCase(PersonDocumentOut personDocumentOut) {
        this.personDocumentOut = personDocumentOut;
    }


    @Override
    public Mono<?> createPersonDocument(PersonDocument personDocument) {
        return personDocumentOut.createPersonDocument(personDocument);
    }

    @Override
    public Mono<?> createMultiplePersonDocuments(List<PersonDocument> personDocuments) {
        return personDocumentOut.createMultiplePersonDocuments(personDocuments);
    }
}
