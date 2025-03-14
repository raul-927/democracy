package com.democracy.feingclient.domain.ports.in;

import com.democracy.feingclient.domain.models.Product;
import reactor.core.publisher.Flux;

public interface SelectProductIn {
    Flux<Product> selectProduct(Product product);

}
