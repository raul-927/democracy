package co.com.delibolis.products.domain.ports.in;

import co.com.delibolis.products.domain.models.Product;
import reactor.core.publisher.Flux;

import java.util.List;

public interface SelectProductIn {
    Flux<Product> selectProduct(Product product);

}
