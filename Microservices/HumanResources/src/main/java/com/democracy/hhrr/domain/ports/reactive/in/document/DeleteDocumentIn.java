package com.democracy.hhrr.domain.ports.reactive.in.document;

import reactor.core.publisher.Mono;

public interface DeleteDocumentIn {

    Mono<Integer> deleteDocument(String documentId);
}
