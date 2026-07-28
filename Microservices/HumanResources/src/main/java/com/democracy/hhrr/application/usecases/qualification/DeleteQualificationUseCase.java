package com.democracy.hhrr.application.usecases.qualification;

import com.democracy.hhrr.domain.ports.reactive.in.qualification.DeleteQualificationIn;
import com.democracy.hhrr.domain.ports.reactive.out.QualificationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteQualificationUseCase implements DeleteQualificationIn {

    private final QualificationOut qualificationOut;

    public DeleteQualificationUseCase(QualificationOut qualificationOut) {
        this.qualificationOut = qualificationOut;
    }

    @Override
    public Mono<Integer> deleteQualification(String qualificationId) {
        return qualificationOut.deleteQualification(qualificationId);
    }
}
