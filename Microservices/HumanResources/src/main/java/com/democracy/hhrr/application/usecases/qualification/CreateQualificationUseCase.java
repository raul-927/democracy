package com.democracy.hhrr.application.usecases.qualification;

import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.in.qualification.CreateQualificationIn;
import com.democracy.hhrr.domain.ports.out.QualificationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateQualificationUseCase implements CreateQualificationIn {
    private final QualificationOut qualificationOut;

    public CreateQualificationUseCase(QualificationOut qualificationOut) {
        this.qualificationOut = qualificationOut;
    }

    @Override
    public Mono<?> createQualification(Qualification qualification) {
        return qualificationOut.createQualification(qualification);
    }

    @Override
    public Mono<?> createMultipleQualifications(List<Qualification> qualificationList) {
        return qualificationOut.createMultipleQualifications(qualificationList);
    }
}
