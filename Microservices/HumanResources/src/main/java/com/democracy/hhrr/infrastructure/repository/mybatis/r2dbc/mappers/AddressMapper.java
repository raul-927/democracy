package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;


import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.AddressDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface AddressMapper extends AddressDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
