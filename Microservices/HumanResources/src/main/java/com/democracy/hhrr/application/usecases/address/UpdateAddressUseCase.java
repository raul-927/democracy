package com.democracy.hhrr.application.usecases.address;

import com.democracy.hhrr.domain.models.Address;
import com.democracy.hhrr.domain.ports.in.address.UpdateAddressIn;
import com.democracy.hhrr.domain.ports.out.AddressOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateAddressUseCase implements UpdateAddressIn {

    private final AddressOut addressOut;

    public UpdateAddressUseCase(AddressOut addressOut) {
        this.addressOut = addressOut;
    }

    @Override
    public Mono<Integer> updateAddress(Address address) {
        return this.addressOut.updateAddress(address);
    }
}
