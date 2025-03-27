package com.democracy.hhrr.domain.ports.in.document;

import com.democracy.hhrr.domain.models.Document;
import reactor.core.publisher.Mono;

public interface UpdateDocumentIn {

    Mono<Integer> updateDocument(Document document);
}
