package com.democracy.hhrr.infrastructure.adapters;


import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DocumentAdapter implements DocumentOut {

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public Mono<Integer> createDocument(Document document) {
        return this.documentMapper.insert(document);
    }

    @Override
    public Mono<Integer> deleteDocument(String documentId) {
        return this.documentMapper.deleteDocument(documentId);
    }

    @Override
    public Flux<Document> selectDocument(Document document) {
        return this.documentMapper.selectDocument(document);
    }

    @Override
    public Flux<Document> selectAllDDocuments() {
        return this.documentMapper.selectAllDocuments();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.documentMapper.count();
    }

    @Override
    public Mono<Integer> updateDocument(Document document) {
        return this.documentMapper.updateSelectiveByPrimaryKey(document);
    }
}
