package com.democracy.hhrr.domain.ports.in.document;

import com.democracy.hhrr.domain.models.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectDocumentIn {

    Flux<Document> selectDocument(Document document);
    Flux<Document> selectAllDocuments();
    Mono<Long> selectCount();
}
