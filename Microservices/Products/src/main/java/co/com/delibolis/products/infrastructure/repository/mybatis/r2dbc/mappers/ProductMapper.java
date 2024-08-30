package co.com.delibolis.products.infrastructure.repository.mybatis.r2dbc.mappers;


import co.com.delibolis.products.infrastructure.repository.mybatis.r2dbc.dynamic.ProductDinamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface ProductMapper extends ProductDinamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }

}
