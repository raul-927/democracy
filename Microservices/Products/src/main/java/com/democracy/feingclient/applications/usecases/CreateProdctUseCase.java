package com.democracy.feingclient.applications.usecases;

import com.democracy.feingclient.domain.models.Product;
import com.democracy.feingclient.domain.ports.in.CreateProductIn;
import com.democracy.feingclient.domain.ports.out.ProductOut;
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
