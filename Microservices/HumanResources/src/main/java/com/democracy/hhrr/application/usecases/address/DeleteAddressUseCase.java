package com.democracy.hhrr.application.usecases.address;

import com.democracy.hhrr.domain.ports.reactive.in.address.DeleteAddressIn;
import com.democracy.hhrr.domain.ports.reactive.out.AddressOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class DeleteAddressUseCase implements DeleteAddressIn {
    private final AddressOut addressOut;

    public DeleteAddressUseCase(AddressOut addressOut) {
        this.addressOut = addressOut;
    }

    @Override
    public Mono<Integer> deleteAddress(String id) {
        return this.addressOut.deleteAddress(id);
    }
}
