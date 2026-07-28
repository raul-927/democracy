package com.democracy.hhrr.domain.ports.reactive.in.document;

import com.democracy.hhrr.domain.models.Document;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Mono;

public interface CreateDocumentIn {

    Mono<Document> createDocument(FilePart filePart, Document document);
}
