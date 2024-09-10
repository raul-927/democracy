package com.democracy.hhrr.domain.ports.in.address;

import reactor.core.publisher.Mono;

public interface DeleteAddressIn {

    Mono<Integer> deleteAddress(String id);

}
