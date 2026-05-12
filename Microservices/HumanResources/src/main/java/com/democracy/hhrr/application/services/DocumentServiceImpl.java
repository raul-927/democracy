package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.domain.ports.in.document.CreateDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.DeleteDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.SelectDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.UpdateDocumentIn;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DocumentServiceImpl implements DocumentService{
    private final CreateDocumentIn createDocumentIn;
    private final DeleteDocumentIn deleteDocumentIn;
    private final SelectDocumentIn selectDocumentIn;
    private final UpdateDocumentIn updateDocumentIn;

    public DocumentServiceImpl(CreateDocumentIn createDocumentIn, DeleteDocumentIn deleteDocumentIn, SelectDocumentIn selectDocumentIn, UpdateDocumentIn updateDocumentIn) {
        this.createDocumentIn = createDocumentIn;
        this.deleteDocumentIn = deleteDocumentIn;
        this.selectDocumentIn = selectDocumentIn;
        this.updateDocumentIn = updateDocumentIn;
    }

    @Override
    public Mono<Document> createDocument(FilePart filePart, Document document) {
        return this.createDocumentIn.createDocument(filePart, document);
    }

    @Override
    public Mono<Integer> deleteDocument(String documentId) {
        return this.deleteDocumentIn.deleteDocument(documentId);
    }

    @Override
    public Flux<Document> selectDocument(Document document) {
        return this.selectDocumentIn.selectDocument(document);
    }

    @Override
    public Flux<Document> selectAllDocuments() {
        return this.selectDocumentIn.selectAllDocuments();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectDocumentIn.selectCount();
    }

    @Override
    public Flux<Document> selectDocumentByCedula(Person person) {
        return this.selectDocumentIn.selectDocumentByCedula(person);
    }

    @Override
    public Mono<Document> updateDocument(FilePart filePart, Document document) {
        return this.updateDocumentIn.updateDocument(filePart,document);
    }
}
