package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.StreetDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;


@Mapper
public interface StreetMapper extends StreetDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
