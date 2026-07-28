package com.democracy.hhrr.domain.ports.reactive.in.document;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectDocumentIn {

    Flux<Document> selectDocument(Document document);
    Flux<Document> selectAllDocuments();
    Mono<Long> selectCount();
    Flux<Document> selectDocumentByCedula(Person person);
}
