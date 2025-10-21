package com.democracy.hhrr.application.usecases.document;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.ports.in.document.CreateDocumentIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class CreateDocumentUseCase implements CreateDocumentIn {
    private final DocumentOut documentOut;

    public CreateDocumentUseCase(DocumentOut documentOut) {
        this.documentOut = documentOut;
    }

    @Override
    public Mono<Integer> createDocument(Document document) {
        document.setDocumentId(UUID.randomUUID().toString());
        return this.documentOut.createDocument(document);
    }
}
