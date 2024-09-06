package com.democracy.hhrr.application.usecases.street;

import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.UpdateStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class UpdateStreetUseCase implements UpdateStreetIn {

    private final StreetOut streetOut;

    public UpdateStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Integer> updateStreet(Street street) {
        return streetOut.updateStreet(street);
    }
}
