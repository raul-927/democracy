package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.ProfessionDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;


@Mapper
public interface ProfessionMapper extends ProfessionDynamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
