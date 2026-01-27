package com.democracy.hhrr.infrastructure.web.handlers;

import com.democracy.hhrr.application.services.CriminalRecordService;
import com.democracy.hhrr.application.services.DocumentService;
import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.domain.models.Document;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Component
//@Slf4j
public class DocumentHandler {

    //@Autowired
    private DocumentService documentService;

    public Mono<ServerResponse> selectDocument(ServerRequest request){
        var obtainDocument = request.bodyToMono(Document.class);
        Document sendDocument  = new Document();
        obtainDocument.map( doc ->{
            sendDocument.setDocumentId(doc.getDocumentId());
            sendDocument.setDocumentAttachment(doc.getDocumentAttachment());
            sendDocument.setDocumentApproved(doc.isDocumentApproved());
            sendDocument.setDocumentVerified(doc.isDocumentVerified());
            sendDocument.setDocumentName(doc.getDocumentName());
            sendDocument.setDocumentObservation(doc.getDocumentObservation());
            return sendDocument;
        });
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(documentService.selectDocument(sendDocument), Document.class);
    }

    public Mono<ServerResponse> selectAllDocuments(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(documentService.selectAllDocuments(), Document.class);
    }
/*
    public Mono<ServerResponse> createDocument(ServerRequest request){
        Mono<Document> documentMono = request.bodyToMono(Document.class);

        return documentMono.flatMap(
                doc ->ServerResponse
                        .ok()
                        .body(documentService.createDocument(doc), Document.class));
    }
*/
    /*public Mono<ServerResponse> createMultipleCriminalRecords(ServerRequest request){
        List<CriminalRecord>criminalRecordList = new ArrayList<>();

        var obtainListCriminalRecords = request.bodyToFlux(CriminalRecord.class);
        obtainListCriminalRecords.collectList().map(
                crim ->{
                    System.out.println("CRIM: "+crim);
                    criminalRecordList.addAll(crim);
                    System.out.println("CRIMINAL_RECORD_LIST: "+criminalRecordList);
                    return criminalRecordList;
                }
        ).subscribe(System.out::println).dispose();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(criminalRecordService.createMultiple(criminalRecordList), CriminalRecord.class);
    }*/
/*
    public Mono<ServerResponse> updateDocument(ServerRequest request){
        Mono<Document> documentMono = request.bodyToMono(Document.class);
        return documentMono.flatMap(
                d ->ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(documentService.updateDocument(d), Document.class));
    }
*/
    public Mono<ServerResponse> selectCount(ServerRequest request){
        Mono<Long> countResult = documentService.selectCount();
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(countResult, Document.class);
    }
/*
    public Mono<ServerResponse> createDocument(ServerRequest serverRequest) {
    }

 */
}