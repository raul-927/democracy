package com.democracy.hhrr.application.usecases.institute;

import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.in.document.CreateDocumentIn;

import com.democracy.hhrr.domain.ports.in.institute.CreateInstituteIn;
import com.democracy.hhrr.domain.ports.out.InstituteOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateInstituteUseCase implements CreateInstituteIn {
    private final InstituteOut instituteOut;

    public CreateInstituteUseCase(InstituteOut instituteOut) {
        this.instituteOut = instituteOut;
    }

    @Override
    public Mono<Integer> createInstitute(Institute institute) {
        return this.instituteOut.createInstitute(institute);
    }
}
