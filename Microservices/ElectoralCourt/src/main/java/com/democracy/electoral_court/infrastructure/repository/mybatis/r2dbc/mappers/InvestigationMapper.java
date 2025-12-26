package com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.mappers;


import com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.dynamic.InvestigationDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Mono;

@Mapper
public interface InvestigationMapper extends InvestigationDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
