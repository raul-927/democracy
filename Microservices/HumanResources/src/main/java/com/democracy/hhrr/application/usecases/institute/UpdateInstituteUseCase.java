package com.democracy.hhrr.application.usecases.institute;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.in.document.UpdateDocumentIn;
import com.democracy.hhrr.domain.ports.in.institute.UpdateInstituteIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import com.democracy.hhrr.domain.ports.out.InstituteOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateInstituteUseCase implements UpdateInstituteIn {
    private final InstituteOut instituteOut;

    public UpdateInstituteUseCase(InstituteOut instituteOut) {
        this.instituteOut = instituteOut;
    }

    @Override
    public Mono<Integer> updateInstitute(Institute institute) {
        return this.instituteOut.updateInstitute(institute);
    }
}
