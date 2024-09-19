package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.CityDynamicMapper;
import org.apache.ibatis.annotations.Mapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Mapper
public interface CityMapper extends CityDynamicMapper {
    default Mono<Long> count(){
        return count(dsl -> dsl);
    }


}
