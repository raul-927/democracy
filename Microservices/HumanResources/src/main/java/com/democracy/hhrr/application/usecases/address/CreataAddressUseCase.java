package com.democracy.hhrr.application.usecases.address;

import com.democracy.hhrr.domain.models.Address;
import com.democracy.hhrr.domain.ports.in.address.CreateAddressIn;
import com.democracy.hhrr.domain.ports.out.AddressOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class CreataAddressUseCase implements CreateAddressIn {

    private final AddressOut addressOut;

    public CreataAddressUseCase(AddressOut addressOut) {
        this.addressOut = addressOut;
    }

    @Override
    public Mono<Integer> createAddress(Address address) {
        address.setAddressId(UUID.randomUUID().toString());
        return this.addressOut.createAddress(address);
    }

    @Override
    public Mono<Integer> createMultipleAddress(List<Address> addressList) {
        addressList.forEach(
                a ->{
                    a.setAddressId(UUID.randomUUID().toString());
                }
        );
        return this.addressOut.createMultipleAddress(addressList);
    }
}
