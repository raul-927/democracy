package com.democracy.feingtarget.domain.ports.in;

import com.democracy.feingtarget.domain.models.Product;
import reactor.core.publisher.Flux;

public interface SelectProductIn {
    Flux<Product> selectProduct(Product product);

}
