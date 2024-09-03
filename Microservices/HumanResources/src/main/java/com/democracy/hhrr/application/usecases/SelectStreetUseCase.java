package com.democracy.hhrr.application.usecases;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.SelectStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SelectStreetUseCase implements SelectStreetIn {

    private final StreetOut streetOut;

    public SelectStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Flux<Street> selectStreet(Street street) {
        return streetOut.selectStreet(street);
    }

    @Override
    public Mono<Long> selectCount() {
        return streetOut.selectCount();
    }
}
