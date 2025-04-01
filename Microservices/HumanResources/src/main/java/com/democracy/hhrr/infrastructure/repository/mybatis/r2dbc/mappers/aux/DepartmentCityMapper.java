package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux;

import com.democracy.hhrr.domain.aux.DepartmentCity;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux.DepartmentCityDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.where.WhereApplier;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport.DEPARTMENT_CITY;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Mapper
public interface DepartmentCityMapper extends DepartmentCityDynamicMapper {

    default Mono<Integer> insert(DepartmentCity record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DEPARTMENT_CITY, c ->
                c
                        .map(departmentCityId).toProperty("departmentCityId")
                        .map(departmentId).toProperty("departmentId")
                        .map(cityId).toProperty("cityId")

        );
    }

    default Mono<Integer> insertMultiple(Collection<DepartmentCity> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, DEPARTMENT_CITY, c ->
                c

                        .map(departmentCityId).toProperty("departmentCityId")
                        .map(departmentId).toProperty("departmentId")
                        .map(cityId).toProperty("cityId")
        );
    }

    default Mono<Integer> insertSelective(DepartmentCity record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DEPARTMENT_CITY, c ->
                c
                        .map(departmentCityId).toPropertyWhenPresent("cityNeighId", record::getDepartmentCityId)
                        .map(departmentId).toPropertyWhenPresent("neighborhoodId", record::getDepartmentId)
                        .map(cityId).toPropertyWhenPresent("cityId", record::getCityId)


        );
    }

    default Mono<Integer> deleteDepartmentCity(String id){
        return this.delete(
                d -> d.where(CityNeighDynamicSqlSupport.cityNeighId, isEqualTo(id))
        );
    }

    default Flux<DepartmentCity> selectDepartmentCity(DepartmentCity departmentCity) {
        return select(str ->{
            if(departmentCity.getDepartmentCityId() != null ||
                    departmentCity.getDepartmentId() != null ||
                    departmentCity.getCityId()!=null){
                if(departmentCity.getDepartmentCityId()!=null && !departmentCity.getDepartmentCityId().isEmpty()){
                    str.where(departmentCityId,isEqualToWhenPresent(departmentCity.getDepartmentCityId()));
                }else{
                    str
                            .where(departmentCityId,isLikeWhenPresent(departmentCity::getDepartmentCityId).map(s -> "%" + s + "%"))

                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(departmentCityId);
            }
            return str;
        });
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(DepartmentCity record) {
        return update(c ->
                c
                        .set(departmentId).equalToWhenPresent(record::getDepartmentId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .where(departmentCityId, isEqualTo(record::getDepartmentCityId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(DepartmentCity record) {
        return update(c ->
                c
                        .set(departmentId).equalToWhenPresent(record::getDepartmentId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .where(departmentCityId, isEqualTo(record::getDepartmentCityId))
        );
    }

    default Mono<Integer> updateAll(DepartmentCity record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(departmentId).equalToWhenPresent(record::getDepartmentId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(DepartmentCity record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(departmentId).equalToWhenPresent(record::getDepartmentId)
                        .set(cityId).equalToWhenPresent(record::getCityId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
