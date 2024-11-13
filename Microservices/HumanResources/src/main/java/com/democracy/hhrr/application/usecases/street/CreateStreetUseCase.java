package com.democracy.hhrr.application.usecases.street;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.CreateStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreateStreetUseCase implements CreateStreetIn {

    private final StreetOut streetOut;

    public CreateStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Integer> createStreet(Street street) {
        street.setStreetId(UUID.randomUUID().toString());
        return streetOut.createStreet(street);
    }

    @Override
    public Mono<Integer> createMultipleStreet(List<Street> streetList) {
        streetList.forEach(
                e ->{
                    e.setStreetId(UUID.randomUUID().toString());
                }
        );

        return streetOut.createMultipleStreet(streetList);
    }
}
