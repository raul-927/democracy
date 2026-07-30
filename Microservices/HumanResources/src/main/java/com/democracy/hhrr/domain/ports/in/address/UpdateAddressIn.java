package com.democracy.hhrr.domain.ports.in.address;


import com.democracy.hhrr.domain.models.Address;
import reactor.core.publisher.Mono;

public interface UpdateAddressIn {

    Mono<Integer> updateAddress(Address address);
}
