package com.democracy.hhrr.application.usecases.document;

import com.democracy.hhrr.domain.ports.in.document.DeleteDocumentIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteDocumentUseCase implements DeleteDocumentIn {
    private final DocumentOut documentOut;

    public DeleteDocumentUseCase(DocumentOut documentOut) {
        this.documentOut = documentOut;
    }

    @Override
    public Mono<Integer> deleteDocument(String documentId) {
        return this.documentOut.deleteDocument(documentId);
    }
}
