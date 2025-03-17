package com.democracy.feingtarget.infrastructure.repository.mybatis.r2dbc.mappers;


import com.democracy.feingtarget.infrastructure.repository.mybatis.r2dbc.dynamic.ProductDinamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface ProductMapper extends ProductDinamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }

}
