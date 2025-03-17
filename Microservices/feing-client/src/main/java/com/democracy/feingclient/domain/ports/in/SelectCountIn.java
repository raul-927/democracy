package com.democracy.feingclient.domain.ports.in;

import reactor.core.publisher.Mono;

public interface SelectCountIn {
    Mono<Long> selectCount();
}
