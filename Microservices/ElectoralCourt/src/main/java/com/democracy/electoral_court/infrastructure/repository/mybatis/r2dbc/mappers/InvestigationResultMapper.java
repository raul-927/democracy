package com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.mappers;


import com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.dynamic.InvestigationResultDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface InvestigationResultMapper extends InvestigationResultDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
