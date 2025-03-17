package com.democracy.feingtarget.applications.usecases;

import com.democracy.feingtarget.domain.models.Product;
import com.democracy.feingtarget.domain.ports.in.CreateProductIn;
import com.democracy.feingtarget.domain.ports.out.ProductOut;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class CreateProdctUseCase implements CreateProductIn {

    private final ProductOut productOut;

    public CreateProdctUseCase(ProductOut productOut){
        this.productOut = productOut;
    }


    @Override
    public Mono<Integer> createProduct(Product product) {
        return productOut.createProduct(product);
    }

    @Override
    public Mono<Integer> createMultipleProduct(List<Product> products) {
        return productOut.createMultipleProduct(products);
    }
}
