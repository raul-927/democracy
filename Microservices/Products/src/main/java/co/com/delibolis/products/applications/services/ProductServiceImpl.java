package co.com.delibolis.products.applications.services;

import co.com.delibolis.products.domain.models.Product;
import co.com.delibolis.products.domain.ports.in.CreateProductIn;
import co.com.delibolis.products.domain.ports.in.SelectCountIn;
import co.com.delibolis.products.domain.ports.in.SelectProductIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{


    @Autowired
    private CreateProductIn createProductIn;

    @Autowired
    private SelectProductIn selectProductIn;

    @Autowired
    private SelectCountIn selectCountIn;
    @Override
    public Mono<Integer> createProduct(Product product) {
        return createProductIn.createProduct(product);
    }

    @Override
    public Mono<Integer> createMultipleProduct(List<Product> products) {
        return createProductIn.createMultipleProduct(products);
    }

    @Override
    public Flux<Product> selectProduct(Product product) {
        return selectProductIn.selectProduct(product);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectCountIn.selectCount();
    }
}
