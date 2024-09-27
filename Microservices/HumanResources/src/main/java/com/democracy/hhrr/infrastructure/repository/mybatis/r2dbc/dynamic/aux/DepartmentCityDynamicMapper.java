package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import com.democracy.hhrr.domain.aux.CityNeighborhood;
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
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport.departmentCityId;

public interface DepartmentCityDynamicMapper {

    BasicColumn[] departmentCity = BasicColumn.columnList(departmentCityId, departmentId, cityId);


    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> counter(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.cityNeighId",keyColumn = "city_neigh_id")
    Mono<Integer> insert(InsertStatementProvider<CityNeighborhood> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.cityNeighId",keyColumn = "city_neigh_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<CityNeighborhood> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CityNeighborhoodResult")
    Mono<CityNeighborhood> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CityNeighborhoodResult")
    Flux<CityNeighborhood> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::counter, CITY_NEIGH, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, CITY_NEIGH, completer);
    }

    default Mono<CityNeighborhood> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, departmentCity, CITY_NEIGH, completer);
    }

    default Flux<CityNeighborhood> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, departmentCity, CITY_NEIGH, completer);
    }


    default Flux<CityNeighborhood> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, departmentCity, CITY_NEIGH, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, CITY_NEIGH, completer);
    }

}
