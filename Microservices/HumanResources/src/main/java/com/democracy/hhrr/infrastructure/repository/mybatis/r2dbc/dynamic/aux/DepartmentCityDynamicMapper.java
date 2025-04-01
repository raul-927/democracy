package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.aux.DepartmentCity;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport.DEPARTMENT_CITY;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport.departmentCityId;

public interface DepartmentCityDynamicMapper {

    BasicColumn[] departmentCity = BasicColumn.columnList(departmentCityId, departmentId, cityId);


    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> counter(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.departmentCityId",keyColumn = "department_city_id")
    Mono<Integer> insert(InsertStatementProvider<DepartmentCity> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.departmentCityId",keyColumn = "department_city_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<DepartmentCity> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DepartmentCityResult")
    Mono<DepartmentCity> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DepartmentCityResult")
    Flux<DepartmentCity> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::counter, DEPARTMENT_CITY, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, DEPARTMENT_CITY, completer);
    }

    default Mono<DepartmentCity> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, departmentCity, CITY_NEIGH, completer);
    }

    default Flux<DepartmentCity> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, departmentCity, CITY_NEIGH, completer);
    }


    default Flux<DepartmentCity> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, departmentCity, CITY_NEIGH, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, CITY_NEIGH, completer);
    }

}
