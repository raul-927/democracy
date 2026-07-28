package com.democracy.hhrr.domain.ports.reactive.in.address;

import reactor.core.publisher.Mono;

public interface DeleteAddressIn {

    Mono<Integer> deleteAddress(String id);

}
