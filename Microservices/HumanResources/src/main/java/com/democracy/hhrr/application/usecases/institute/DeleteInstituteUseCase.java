package com.democracy.hhrr.application.usecases.institute;

import com.democracy.hhrr.domain.ports.reactive.in.institute.DeleteInstituteIn;
import com.democracy.hhrr.domain.ports.reactive.out.InstituteOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteInstituteUseCase implements DeleteInstituteIn {
    private final InstituteOut instituteOut;

    public DeleteInstituteUseCase(InstituteOut instituteOut) {
        this.instituteOut = instituteOut;
    }

    @Override
    public Mono<Integer> deleteInstitute(String instituteId) {
        return this.instituteOut.deleteInstitute(instituteId);
    }
}
