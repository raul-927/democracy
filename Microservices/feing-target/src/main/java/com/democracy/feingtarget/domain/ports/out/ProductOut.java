package com.democracy.feingtarget.domain.ports.out;

import com.democracy.feingtarget.domain.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductOut {

    Mono<Integer> createProduct(Product product);
    Mono<Integer> createMultipleProduct(List<Product> products);
    Flux<Product> selectProduct(Product product);
    Mono<Long> selectCount();
}
