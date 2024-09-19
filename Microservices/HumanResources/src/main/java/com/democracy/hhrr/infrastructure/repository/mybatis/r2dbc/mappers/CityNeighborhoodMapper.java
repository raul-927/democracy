package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux.CityNeighDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux.NeighBorhoodStreetDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.DerivedColumn;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.where.WhereApplier;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport.cityId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport.cityNeighId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface CityNeighborhoodMapper extends CityNeighDynamicMapper {

    default Mono<Integer> insert(CityNeighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neighStreetTable, c ->
                c
                        .map(neighborhoodId).toProperty("neighborhoodId")
                        .map(cityId).toProperty("cityId")


        );
    }

    default Mono<Integer> insertMultiple(Collection<CityNeighborhood> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, neighStreetTable, c ->
                c

                        .map(neighborhoodId).toProperty("neighborhoodId")
                        .map(cityId).toProperty("cityId")
        );
    }

    default Mono<Integer> insertSelective(CityNeighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neighStreetTable, c ->
                c
                        .map(cityNeighId).toPropertyWhenPresent("cityNeighId", record::getCityNeighId)
                        .map(neighborhoodId).toPropertyWhenPresent("neighborhoodId", record::getNeighborhoodId)
                        .map(cityId).toPropertyWhenPresent("cityId", record::getCityId)


        );
    }

    default Mono<Integer> deleteNeighStreet(String id){
        return this.delete(
                d -> d.where(CityNeighDynamicSqlSupport.cityNeighId, isEqualTo(id))
        );
    }

    default Flux<CityNeighborhood> selectNeighborhood(CityNeighborhood cityNeighborhood) {
        return select(str ->{
            if(cityNeighborhood.getCityNeighId() != null ||
                    cityNeighborhood.getNeighborhoodId() != null ||
                    cityNeighborhood.getCityId()!=null){
                if(cityNeighborhood.getNeighborhoodId()!=null && !cityNeighborhood.getNeighborhoodId().isEmpty()){
                    str.where(cityNeighId,isEqualToWhenPresent(cityNeighborhood.getNeighborhoodId()));
                }else{
                    str
                            .where(cityNeighId,isLikeWhenPresent(cityNeighborhood::getCityNeighId).map(s -> "%" + s + "%"))

                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(neighborhoodId);
            }
            return str;
        });
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(CityNeighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .where(cityNeighId, isEqualTo(record::getCityNeighId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(CityNeighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .where(cityNeighId, isEqualTo(record::getCityNeighId))
        );
    }

    default Mono<Integer> updateAll(CityNeighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c
                .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                .set(cityId).equalToWhenPresent(record::getCityId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(CityNeighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
