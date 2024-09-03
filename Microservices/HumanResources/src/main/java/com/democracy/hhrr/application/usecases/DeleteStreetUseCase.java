package com.democracy.hhrr.application.usecases;


import com.democracy.hhrr.domain.ports.in.street.DeleteStreetIn;
import com.democracy.hhrr.domain.ports.out.StreetOut;
import org.springframework.stereotype.Component;

@Component
public class DeleteStreetUseCase implements DeleteStreetIn {

    private final StreetOut streetOut;

    public DeleteStreetUseCase(StreetOut streetOut) {
        this.streetOut = streetOut;
    }

    @Override
    public void deleteStreet(String streetId) {
        this.streetOut.deleteStreet(streetId);
    }
}
