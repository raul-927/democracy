package com.democracy.hhrr.application.usecases.document;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.ports.in.document.UpdateDocumentIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateDocumentUseCase implements UpdateDocumentIn {
    private final DocumentOut documentOut;

    public UpdateDocumentUseCase(DocumentOut documentOut) {
        this.documentOut = documentOut;
    }

    @Override
    public Mono<Integer> updateDocument(Document document) {
        return this.documentOut.updateDocument(document);
    }
}
