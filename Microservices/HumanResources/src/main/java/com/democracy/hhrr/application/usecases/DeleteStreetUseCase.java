package com.democracy.hhrr.application.usecases;


import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.domain.ports.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class DeleteStreetUseCase implements DeleteStreetIn {

    private final StreetOut streetOut;

    public DeleteStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public Mono<Integer> deleteStreet(String streetId) {
        Street street = new Street();
        AtomicReference<Long> res = new AtomicReference<>(Long.getLong("0"));
        street.setStreetId(streetId);
       this.streetOut.selectStreet(street).count().map(r ->{
           res.set(r);
           System.out.println("RESULT: "+res);
           return r;
       });

        return this.streetOut.deleteStreet(streetId);
    }
}
