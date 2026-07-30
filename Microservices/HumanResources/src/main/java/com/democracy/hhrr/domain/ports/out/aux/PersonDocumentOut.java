package com.democracy.hhrr.domain.ports.out.aux;

import com.democracy.hhrr.domain.aux.PersonDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PersonDocumentOut {
    Mono<Integer> createPersonDocument(PersonDocument personDocument);
    Mono<?>createMultiplePersonDocuments(List<PersonDocument> personDocuments);
    Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument);
    Flux<PersonDocument> selectAllPersonDocuments();
    Mono<Long> selectCount();
}
