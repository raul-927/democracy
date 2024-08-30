package co.com.delibolis.products.domain.ports.out;

import co.com.delibolis.products.domain.models.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

public interface ProductOut {

    Mono<Integer> createProduct(Product product);
    Mono<Integer> createMultipleProduct(List<Product> products);
    Flux<Product> selectProduct(Product product);
    Mono<Long> selectCount();
}
