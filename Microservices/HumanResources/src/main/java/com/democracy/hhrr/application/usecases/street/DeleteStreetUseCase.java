package com.democracy.hhrr.application.usecases.street;


import com.democracy.hhrr.domain.ports.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteStreetUseCase implements DeleteStreetIn {

    private final StreetOut streetOut;

    public DeleteStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Integer> deleteStreet(String streetId) {
        return this.streetOut.deleteStreet(streetId);
    }
}
