package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import com.democracy.hhrr.domain.aux.NeighborhoodStreet;

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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport.*;

public interface NeighBorhoodStreetDynamicMapper {

    BasicColumn[] neighStreetCol = BasicColumn.columnList(neighStreetId, neighborhoodId, streetId);


    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.neighStreetId",keyColumn = "neigh_street_id")
    Mono<Integer> insert(InsertStatementProvider<NeighborhoodStreet> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.neighStreetId",keyColumn = "neigh_street_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<NeighborhoodStreet> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="NeighStreetResult")
    Mono<NeighborhoodStreet> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="NeighStreetResult")
    Flux<NeighborhoodStreet> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, NEIGH_STREET, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, NEIGH_STREET, completer);
    }

    default Mono<NeighborhoodStreet> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, neighStreetCol, NEIGH_STREET, completer);
    }

    default Flux<NeighborhoodStreet> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, neighStreetCol, NEIGH_STREET, completer);
    }


    default Flux<NeighborhoodStreet> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, neighStreetCol, NEIGH_STREET, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, NEIGH_STREET, completer);
    }

}
