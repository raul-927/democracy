package com.democracy.hhrr.application.usecases.address;

import com.democracy.hhrr.domain.models.Address;
import com.democracy.hhrr.domain.ports.in.address.SelectAddressIn;
import com.democracy.hhrr.domain.ports.out.AddressOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class SelectAddressUseCase implements SelectAddressIn {

    private final AddressOut addressOut;

    public SelectAddressUseCase(AddressOut addressOut) {
        this.addressOut = addressOut;
    }

    @Override
    public Flux<Address> selectAddress(Address address) {
        return this.addressOut.selectAddress(address);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.addressOut.selectCount();
    }
}
