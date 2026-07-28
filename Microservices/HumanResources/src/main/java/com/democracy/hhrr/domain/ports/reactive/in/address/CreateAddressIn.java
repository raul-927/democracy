package com.democracy.hhrr.domain.ports.reactive.in.address;

import com.democracy.hhrr.domain.models.Address;

import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateAddressIn {

    Mono<Integer> createAddress(Address address);
    Mono<Integer> createMultipleAddress(List<Address> addressList);

}
