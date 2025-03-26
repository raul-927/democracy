package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;


import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.CriminalRecordDynamicMapper;
import reactor.core.publisher.Mono;

public interface CriminalRecordMapper extends CriminalRecordDynamicMapper {

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
