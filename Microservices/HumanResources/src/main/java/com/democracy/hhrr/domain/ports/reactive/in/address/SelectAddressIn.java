package com.democracy.hhrr.domain.ports.reactive.in.address;


import com.democracy.hhrr.domain.models.Address;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SelectAddressIn {

    Flux<Address> selectAddress(Address address);
    Mono<Long> selectCount();

}
