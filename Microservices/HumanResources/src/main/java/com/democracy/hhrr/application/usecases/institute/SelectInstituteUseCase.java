package com.democracy.hhrr.application.usecases.institute;

import com.democracy.hhrr.domain.models.Document;
import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.in.document.SelectDocumentIn;
import com.democracy.hhrr.domain.ports.in.institute.SelectInstituteIn;
import com.democracy.hhrr.domain.ports.out.DocumentOut;
import com.democracy.hhrr.domain.ports.out.InstituteOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectInstituteUseCase implements SelectInstituteIn {
    private final InstituteOut instituteOut;

    public SelectInstituteUseCase(InstituteOut instituteOut) {
        this.instituteOut = instituteOut;
    }

    @Override
    public Flux<Institute> selectInstitute(Institute institute) {
        return this.instituteOut.selectInstitute(institute);
    }

    @Override
    public Flux<Institute> selectAllInstitutes() {
        return this.instituteOut.selectAllInstitutes();
    }

    @Override
    public Mono<Long> selectCount() {
        return this.instituteOut.selectCount();
    }
}
