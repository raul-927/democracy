package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.QualificationDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;


@Mapper
public interface QualificationMapper extends QualificationDynamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
