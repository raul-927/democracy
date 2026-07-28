package com.democracy.hhrr.application.services.aux;

import com.democracy.hhrr.domain.ports.reactive.in.aux.persondocument.CreatePersonDocumentIn;
import com.democracy.hhrr.domain.ports.reactive.in.aux.persondocument.SelectPersonDocumentIn;

public interface PersonDocumentService extends CreatePersonDocumentIn, SelectPersonDocumentIn {
}
