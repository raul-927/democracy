package com.democracy.feingtarget.domain.ports.in;

import reactor.core.publisher.Mono;

public interface SelectCountIn {
    Mono<Long> selectCount();
}
