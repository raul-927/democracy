package com.democracy.hhrr.application.usecases.document;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.ports.reactive.in.document.UpdateDocumentIn;
import com.democracy.hhrr.domain.ports.reactive.out.DocumentOut;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class UpdateDocumentUseCase implements UpdateDocumentIn {
    private final DocumentOut documentOut;

    public UpdateDocumentUseCase(DocumentOut documentOut) {
        this.documentOut = documentOut;
    }

    @Override
    public Mono<Document> updateDocument(FilePart filePart, Document document) {
        return filePart.content()
                .map(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);
                    return bytes;
                })
                .collectList()
                .map(list -> {
                    // Unir los fragmentos de bytes
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    list.forEach(bytes -> {
                        try { outputStream.write(bytes); } catch (IOException e) {}
                    });
                    return outputStream.toByteArray();
                })
                .flatMap(fileContent -> {
                    document.setDocumentName(filePart.filename());
                    document.setDocumentAttachment(fileContent);
                    return this.documentOut.updateDocument(document);
                })
                .thenReturn(document);
    }
}
