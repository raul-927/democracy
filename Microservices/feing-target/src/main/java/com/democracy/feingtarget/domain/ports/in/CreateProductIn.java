package com.democracy.feingtarget.domain.ports.in;

import com.democracy.feingtarget.domain.models.Product;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateProductIn {

    Mono<Integer> createProduct(Product product);
    Mono<Integer> createMultipleProduct(List<Product> products);

}
