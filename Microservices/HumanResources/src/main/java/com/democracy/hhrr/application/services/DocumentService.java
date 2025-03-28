package com.democracy.hhrr.application.services;

import com.democracy.hhrr.domain.ports.in.document.CreateDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.DeleteDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.SelectDocumentIn;
import com.democracy.hhrr.domain.ports.in.document.UpdateDocumentIn;

public interface DocumentService extends CreateDocumentIn, DeleteDocumentIn, SelectDocumentIn, UpdateDocumentIn {
}
