package co.com.delibolis.products.infrastructure.web.rest;


import co.com.delibolis.products.applications.services.ProductService;
import co.com.delibolis.products.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
@RefreshScope
public class ProductController {

    @Value("${app.test}")
    private String testProperty;

    @Autowired
    private ProductService productService;

    //@Autowired
    //private AccesControlListService<Product> accesControlListService;


  
    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Product> getProduct(@RequestBody Product product){
        return productService.selectProduct(product);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> save(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<Product> product){
        return productService.createMultipleProduct(product);
    }

    @GetMapping(value="/select-count")
    public Mono<Long> selectCount(){
        System.out.println("LLEGA");
        return  this.productService.selectCount();
    }

}
