package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.DocumentService;
import com.democracy.hhrr.domain.models.Document;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/humanresources/document")
@RefreshScope
public class DocumentController {

    @Autowired
    private DocumentService documentService;


    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Document> uploadPdf(@RequestPart("filePart") FilePart filePart, @RequestPart("data") Document data) {
        return documentService.createDocument(filePart, data);
    }

}
