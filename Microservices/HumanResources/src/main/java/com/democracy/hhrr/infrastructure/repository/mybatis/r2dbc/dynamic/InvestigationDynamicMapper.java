package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;


import com.democracy.hhrr.domain.models.Investigation;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport.street2;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.InvestigationDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.penalId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.penalName;


public interface InvestigationDynamicMapper extends CommonSelectMapper {

    BasicColumn[] investigationColumnList = BasicColumn.columnList(investigationId, personId, observation);
    BasicColumn[] investigationColumns = BasicColumn.columnList(
            investigationId, personId, observation ,/*
            criminalRecordId, criminalRecordName, criminalRecordDescription,*/
            penalId, penalName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.investigationId",keyColumn = "investigation_id")
    Mono<Integer> insert(InsertStatementProvider<Investigation> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.investigationId",keyColumn = "investigation_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Investigation> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InvestigationResult")
    Mono<Investigation> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InvestigationResult")
    Flux<Investigation> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, INVESTIGATION, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, INVESTIGATION, completer);
    }

    default Mono<Integer> insert(Investigation record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, INVESTIGATION, c ->
                c
                        .map(investigationId).toPropertyWhenPresent("investigationId", record::getInvestigationId)
                        .map(personId).toProperty("personId")
                        .map(observation).toProperty("observation")
        );
    }
}
