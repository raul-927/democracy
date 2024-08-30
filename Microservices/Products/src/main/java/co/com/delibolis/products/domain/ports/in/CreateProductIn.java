package co.com.delibolis.products.domain.ports.in;

import co.com.delibolis.products.domain.models.Product;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

public interface CreateProductIn {

    Mono<Integer> createProduct(Product product);
    Mono<Integer> createMultipleProduct(List<Product> products);

}
