package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.InstituteDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface InstituteMapper extends InstituteDynamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
