package com.democracy.feingtarget.infrastructure.adapters;

import com.democracy.feingtarget.domain.models.Product;
import com.democracy.feingtarget.domain.ports.out.ProductOut;
import com.democracy.feingtarget.infrastructure.repository.mybatis.r2dbc.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Component
public class ProductAdapter implements ProductOut {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mono<Integer> createProduct(Product product) {

        return  this.productMapper.insert(product);
    }

    @Override
    public Mono<Integer> createMultipleProduct(List<Product> products) {

        return this.productMapper.insertMultiple(products);
    }

    @Override
    public Flux<Product> selectProduct(Product product) {
        return productMapper.selectProduct(product);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.productMapper.count();
    }
}
