package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.StreetDynamicMapper;
import reactor.core.publisher.Mono;

public interface StreetMapper extends StreetDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
