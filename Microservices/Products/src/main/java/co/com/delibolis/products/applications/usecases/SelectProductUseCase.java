package co.com.delibolis.products.applications.usecases;

import co.com.delibolis.products.domain.models.Product;
import co.com.delibolis.products.domain.ports.in.SelectCountIn;
import co.com.delibolis.products.domain.ports.in.SelectProductIn;
import co.com.delibolis.products.domain.ports.out.ProductOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class SelectProductUseCase implements SelectProductIn, SelectCountIn {
    private final ProductOut productOut;


    public SelectProductUseCase(ProductOut productOut){
        this.productOut =productOut;
    }

    @Override
    public Flux<Product> selectProduct(Product product) {
        return this.productOut.selectProduct(product);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.productOut.selectCount();
    }
}
