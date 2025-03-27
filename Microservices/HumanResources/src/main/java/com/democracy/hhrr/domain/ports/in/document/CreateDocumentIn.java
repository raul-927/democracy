package com.democracy.hhrr.domain.ports.in.document;

import com.democracy.hhrr.domain.models.Document;
import reactor.core.publisher.Mono;

public interface CreateDocumentIn {

    Mono<Integer> createDocument(Document document);
}
