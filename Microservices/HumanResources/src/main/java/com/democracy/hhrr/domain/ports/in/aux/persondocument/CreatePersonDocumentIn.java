package com.democracy.hhrr.domain.ports.in.aux.persondocument;

import com.democracy.hhrr.domain.aux.PersonDocument;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreatePersonDocumentIn {
    Mono<Integer> createPersonDocument(PersonDocument personDocument);
    Mono<?>createMultiplePersonDocuments(List<PersonDocument> personDocuments);
}
