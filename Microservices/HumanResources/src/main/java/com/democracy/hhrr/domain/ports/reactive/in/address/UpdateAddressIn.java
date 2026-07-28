package com.democracy.hhrr.domain.ports.reactive.in.address;


import com.democracy.hhrr.domain.models.Address;
import reactor.core.publisher.Mono;

public interface UpdateAddressIn {

    Mono<Integer> updateAddress(Address address);
}
