package com.democracy.hhrr.application.usecases;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateStreetUseCase implements CreateStreetIn {

    private final StreetOut streetOut;

    public CreateStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Integer> createStreet(Street street) {
        return streetOut.createStreet(street);
    }

    @Override
    public Mono<Integer> createMultipleStreet(List<Street> streetList) {
        return streetOut.createMultipleStreet(streetList);
    }
}
