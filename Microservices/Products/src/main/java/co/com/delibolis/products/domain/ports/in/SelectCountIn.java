package co.com.delibolis.products.domain.ports.in;

import reactor.core.publisher.Mono;

public interface SelectCountIn {
    Mono<Long> selectCount();
}
