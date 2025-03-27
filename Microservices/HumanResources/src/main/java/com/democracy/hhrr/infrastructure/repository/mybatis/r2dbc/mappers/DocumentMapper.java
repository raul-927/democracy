package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.DocumentDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;


@Mapper
public interface DocumentMapper extends DocumentDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }


}
