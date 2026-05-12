package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Person;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;

public interface DocumentOut {

    Mono<Integer> createDocument(Document document);
    Mono<Integer> deleteDocument(String documentId);
    Flux<Document> selectDocument(Document document);
    Flux<Document> selectAllDDocuments();
    Mono<Long> selectCount();
    Mono<Integer> updateDocument(Document document);
    Flux<Document> selectDocumentByCedula(Person person);
}
