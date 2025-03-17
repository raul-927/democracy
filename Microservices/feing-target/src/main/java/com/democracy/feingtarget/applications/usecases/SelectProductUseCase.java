package com.democracy.feingtarget.applications.usecases;

import com.democracy.feingtarget.domain.models.Product;
import com.democracy.feingtarget.domain.ports.in.SelectCountIn;
import com.democracy.feingtarget.domain.ports.in.SelectProductIn;
import com.democracy.feingtarget.domain.ports.out.ProductOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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
