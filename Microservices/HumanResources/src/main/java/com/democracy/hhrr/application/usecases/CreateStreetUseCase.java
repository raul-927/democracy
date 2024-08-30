package com.democracy.hhrr.application.usecases;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import reactor.core.publisher.Mono;

public class CreateStreetUseCase implements CreateStreetIn {

    private final StreetOut streetOut;

    public CreateStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Street> createStreet(Street street) {
        return streetOut.createStreet(street);
    }
}
