package com.democracy.hhrr.domain.ports.in.aux.persondocument;

import com.democracy.hhrr.domain.aux.PersonDocument;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectPersonDocumentIn {
    Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument);
    Flux<PersonDocument> selectAllPersonDocuments();
    Mono<Long> selectCount();
}
