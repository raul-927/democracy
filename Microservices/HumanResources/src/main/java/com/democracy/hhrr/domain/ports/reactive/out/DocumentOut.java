package com.democracy.hhrr.domain.ports.reactive.out;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentOut {

    Mono<Integer> createDocument(Document document);
    Mono<Integer> deleteDocument(String documentId);
    Flux<Document> selectDocument(Document document);
    Flux<Document> selectAllDDocuments();
    Mono<Long> selectCount();
    Mono<Integer> updateDocument(Document document);
    Flux<Document> selectDocumentByCedula(Person person);
}
