package com.democracy.hhrr.domain.ports.in.qualification;

import com.democracy.hhrr.domain.models.Qualification;
import reactor.core.publisher.Mono;

public interface UpdateQualificationIn {

    Mono<Integer> updateQualification(Qualification qualification);
}
