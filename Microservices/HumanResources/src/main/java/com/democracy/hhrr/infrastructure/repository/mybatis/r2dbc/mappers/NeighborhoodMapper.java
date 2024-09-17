package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.NeighborhoodDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;


@Mapper
public interface NeighborhoodMapper extends NeighborhoodDynamicMapper {

    default Mono<Integer> insert(Neighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neigh, c ->
                c
                        .map(neighborhoodName).toProperty("neighborhoodName")


        );
    }

    default Mono<Integer> insertMultiple(Collection<Neighborhood> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, neigh, c ->
                c
                        .map(neighborhoodName).toProperty("neighborhoodName")
        );
    }

    default Mono<Integer> insertSelective(Neighborhood record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, neigh, c ->
                c
                        .map(neighborhoodName).toPropertyWhenPresent("neighborhoodName", record::getNeighborhoodName)


        );
    }

    default Mono<Integer> deleteNeighborhood(String id){
        return this.delete(
                d -> d.where(NeighborhoodDynamicSqlSupport.neighborhoodId, isEqualTo(id))
        );
    }

    default Flux<Neighborhood> selectNeighborhood(Neighborhood neighborhood) {
        BindableColumn<Neighborhood> neighborhoodNeighborhoodId = DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");
        BindableColumn<Neighborhood> neighStreetNeighborhoodId = DerivedColumn.of("neighborhood_id", "NEIGH_STREET");
        BindableColumn<Neighborhood> streetStreetId = DerivedColumn.of("street_id", "STREET");
        BindableColumn<Neighborhood> neighStreetStreetId= DerivedColumn.of("street_id", "NEIGH_STREET");
        return select(str ->{
            str
                    .join(NeighborhoodStreetDynamicSqlSupport.neighStreetTable)
                    .on(neighborhoodNeighborhoodId,equalTo(neighStreetNeighborhoodId))
                    .join(StreetDynamicSqlSupport.str)
                    .on(streetStreetId, equalTo(neighStreetStreetId)).build();
            if(neighborhood.getNeighborhoodId() != null ||
                    neighborhood.getNeighborhoodName() != null){
                if(neighborhood.getNeighborhoodId()!=null && !neighborhood.getNeighborhoodId().isEmpty()){
                    str
                            .where(neighborhoodId,isEqualToWhenPresent(neighborhood.getNeighborhoodId()));
                }else{
                    str
                            .where(neighborhoodName,isLikeWhenPresent(neighborhood::getNeighborhoodName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(neighborhoodId);
            }
            return str;
        });
    }

    default Flux<Neighborhood> selectAllNeighborhood(){
        return selectAllNeighborhood( sel ->{
           sel.build();
           return sel;
        });
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Neighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .where(neighborhoodId, isEqualTo(record::getNeighborhoodId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Neighborhood record) {
        return update(c ->
                c
                        .set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .where(neighborhoodId, isEqualTo(record::getNeighborhoodName))
        );
    }

    default Mono<Integer> updateAll(Neighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Neighborhood record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(neighborhoodName).equalToWhenPresent(record::getNeighborhoodName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
