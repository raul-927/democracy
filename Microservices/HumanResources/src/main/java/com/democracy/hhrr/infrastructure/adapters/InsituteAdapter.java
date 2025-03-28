package com.democracy.hhrr.infrastructure.adapters;

import com.democracy.hhrr.domain.models.Institute;
import com.democracy.hhrr.domain.ports.out.InstituteOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InsituteAdapter implements InstituteOut {

    @Override
    public Mono<Integer> createInstitute(Institute institute) {
        return null;
    }

    @Override
    public Mono<Integer> deleteInstitute(String documentId) {
        return null;
    }

    @Override
    public Flux<Institute> selectInstitute(Institute institute) {
        return null;
    }

    @Override
    public Flux<Institute> selectAllInstitutes() {
        return null;
    }

    @Override
    public Mono<Long> selectCount() {
        return null;
    }

    @Override
    public Mono<Integer> updateInstitute(Institute institute) {
        return null;
    }
}
