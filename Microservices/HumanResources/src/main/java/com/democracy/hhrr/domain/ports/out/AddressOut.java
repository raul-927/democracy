package com.democracy.hhrr.domain.ports.out;

import com.democracy.hhrr.domain.models.Address;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AddressOut {

    Mono<Integer> createAddress(Address address);
    Mono<Integer> createMultipleAddress(List<Address> addressList);
    Mono<Integer> deleteAddress(String id);
    Flux<Address> selectAddress(Address address);
    Mono<Long> selectCount();
    Mono<Integer> updateAddress(Address address);
}
