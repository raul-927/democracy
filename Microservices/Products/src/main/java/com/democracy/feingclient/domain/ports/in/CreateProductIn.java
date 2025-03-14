package com.democracy.feingclient.domain.ports.in;

import com.democracy.feingclient.domain.models.Product;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CreateProductIn {

    Mono<Integer> createProduct(Product product);
    Mono<Integer> createMultipleProduct(List<Product> products);

}
