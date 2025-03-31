package com.democracy.hhrr.application.usecases.qualification;

import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.ports.in.profession.SelectProfessionIn;
import com.democracy.hhrr.domain.ports.in.qualification.SelectQualificationIn;
import com.democracy.hhrr.domain.ports.out.ProfessionOut;
import com.democracy.hhrr.domain.ports.out.QualificationOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectQualificationUseCase implements SelectQualificationIn {
    private final QualificationOut qualificationOut;

    public SelectQualificationUseCase(QualificationOut qualificationOut) {
        this.qualificationOut = qualificationOut;
    }


    @Override
    public Flux<Qualification> selectQualification(Qualification qualification) {
        return qualificationOut.selectQualification(qualification);
    }

    @Override
    public Flux<Qualification> selectAllQualifications() {
        return qualificationOut.selectAllQualifications();
    }

    @Override
    public Mono<Long> selectCount() {
        return qualificationOut.selectCount();
    }
}
