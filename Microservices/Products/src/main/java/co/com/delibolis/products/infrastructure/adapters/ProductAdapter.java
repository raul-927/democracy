package co.com.delibolis.products.infrastructure.adapters;

import co.com.delibolis.products.domain.models.Product;
import co.com.delibolis.products.domain.ports.out.ProductOut;
import co.com.delibolis.products.infrastructure.mappers.ProductEntityMapper;
import co.com.delibolis.products.infrastructure.repository.mybatis.r2dbc.mappers.ProductMapper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static co.com.delibolis.products.infrastructure.repository.mybatis.r2dbc.support.ProductDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

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
