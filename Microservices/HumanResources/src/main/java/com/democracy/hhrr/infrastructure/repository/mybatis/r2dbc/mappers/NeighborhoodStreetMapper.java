package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux.NeighBorhoodStreetDynamicMapper;

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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface NeighborhoodStreetMapper extends NeighBorhoodStreetDynamicMapper {

    default Mono<Integer> insert(NeighborhoodStreet record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, NEIGH_STREET, c ->
                c
                        .map(neighborhoodId).toProperty("neighborhoodId")
                        .map(streetId).toProperty("streetId")


        );
    }

    default Mono<Integer> insertMultiple(Collection<NeighborhoodStreet> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, NEIGH_STREET, c ->
                c

                        .map(neighborhoodId).toProperty("neighborhoodId")
                        .map(streetId).toProperty("streetId")
        );
    }

    default Mono<Integer> insertSelective(NeighborhoodStreet record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, NEIGH_STREET, c ->
                c
                        .map(neighStreetId).toPropertyWhenPresent("neighStreetId", record::getNeighStreetId)
                        .map(neighborhoodId).toPropertyWhenPresent("neighborhoodName", record::getNeighborhoodId)
                        .map(streetId).toPropertyWhenPresent("neighborhoodName", record::getStreetId)


        );
    }

    default Mono<Integer> deleteNeighStreet(String id){
        return this.delete(
                d -> d.where(NeighborhoodStreetDynamicSqlSupport.neighStreetId, isEqualTo(id))
        );
    }

    default Flux<NeighborhoodStreet> selectNeighborhood(NeighborhoodStreet neighborhoodStreet) {
        BindableColumn<NeighborhoodStreet> joinStreetColumn = DerivedColumn.of("street_id", "STREET");
        BindableColumn<NeighborhoodStreet> joinNeighborhoodColumn = DerivedColumn.of("street1_id", "NEIGHBORHOOD");
        return select(str ->{
            if(neighborhoodStreet.getNeighStreetId() != null ||
                    neighborhoodStreet.getNeighborhoodId() != null ||
                    neighborhoodStreet.getStreetId()!=null){
                if(neighborhoodStreet.getNeighStreetId()!=null && !neighborhoodStreet.getNeighStreetId().isEmpty()){
                    str.where(neighStreetId,isEqualToWhenPresent(neighborhoodStreet.getNeighStreetId()));
                }else{
                    str
                            .where(neighborhoodId,isLikeWhenPresent(neighborhoodStreet::getNeighborhoodId).map(s -> "%" + s + "%"))

                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(neighborhoodId);
            }
            return str;
        });
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(NeighborhoodStreet record) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(streetId).equalToWhenPresent(record::getStreetId)

                        .where(neighStreetId, isEqualTo(record::getNeighStreetId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(NeighborhoodStreet record) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(streetId).equalToWhenPresent(record::getStreetId)

                        .where(neighStreetId, isEqualTo(record::getNeighStreetId))
        );
    }

    default Mono<Integer> updateAll(NeighborhoodStreet record, WhereApplier whereApplier) {
        return update(c ->
                c
                .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                .set(streetId).equalToWhenPresent(record::getStreetId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(NeighborhoodStreet record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(neighborhoodId).equalToWhenPresent(record::getNeighborhoodId)
                        .set(streetId).equalToWhenPresent(record::getStreetId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
