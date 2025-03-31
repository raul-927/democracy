package com.democracy.hhrr.application.usecases.qualification;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.in.qualification.UpdateQualificationIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import com.democracy.hhrr.domain.ports.out.QualificationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateQualificationUseCase implements UpdateQualificationIn {

    private final QualificationOut qualificationOut;

    public UpdateQualificationUseCase(QualificationOut qualificationOut) {
        this.qualificationOut = qualificationOut;
    }

    @Override
    public Mono<Integer> updateQualification(Qualification qualification) {
        return qualificationOut.updateQualification(qualification);
    }
}
