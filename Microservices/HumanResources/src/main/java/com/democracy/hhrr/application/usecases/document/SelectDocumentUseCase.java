package com.democracy.hhrr.application.usecases.document;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.ports.in.document.SelectDocumentIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectDocumentUseCase implements SelectDocumentIn {
    private final DocumentOut documentOut;

    public SelectDocumentUseCase(DocumentOut documentOut) {
        this.documentOut = documentOut;
    }

    @Override
    public Flux<Document> selectDocument(Document document) {
        return this.documentOut.selectDocument(document);
    }

    @Override
    public Flux<Document> selectAllDDocuments() {
        return this.documentOut.selectAllDDocuments();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.documentOut.selectCount();
    }
}
