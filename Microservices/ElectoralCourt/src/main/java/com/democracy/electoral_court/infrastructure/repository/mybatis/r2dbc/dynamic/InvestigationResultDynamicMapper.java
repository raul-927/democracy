package com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.dynamic;


import com.democracy.electoral_court.domain.models.Investigation;
import com.democracy.electoral_court.domain.models.InvestigationResult;
import io.r2dbc.spi.R2dbcBadGrammarException;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.InvestigationResultDynamicSqlSupport.*;
import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.InvestigationResultDynamicSqlSupport.investigationId;
import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.InvestigationResultDynamicSqlSupport.observation;
import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.InvestigationResultDynamicSqlSupport.personId;
import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.penalId;
import static com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.penalName;


public interface InvestigationResultDynamicMapper extends CommonSelectMapper {

    BasicColumn[] investigationResultColumnList = BasicColumn.columnList(investigationId, personId, observation);
    BasicColumn[] investigationResultColumns = BasicColumn.columnList(
            investigationId, personId, observation ,/*
            criminalRecordId, criminalRecordName, criminalRecordDescription,*/
            penalId, penalName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.investigationResultId",keyColumn = "investigation_result_id")
    Mono<Integer> insert(InsertStatementProvider<InvestigationResult> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.investigationResultId",keyColumn = "investigation_result_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Investigation> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InvestigationResultResult")
    Mono<Investigation> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InvestigationResultResult")
    Flux<Investigation> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, INVESTIGATION_RESULT, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, INVESTIGATION_RESULT, completer);
    }

    default Mono<Integer> insertInvestigationResult(InvestigationResult record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, INVESTIGATION_RESULT, c ->
                c
                        .map(investigationResultId).toPropertyWhenPresent("investigationResultId", record::getInvestigationResultId)
                        .map(investigationId).toProperty("investigationId")
                        .map(cedula).toProperty("cedula")
                        .map(personId).toProperty("personId")
                        .map(observation).toProperty("observation")
                        .map(score).toProperty("score")
                        .map(isApprove).toProperty("isApprove")

        ).doOnError( err ->{
            try{
                System.out.println("LLEGO AQUI: ");
                throw new RuntimeException("SE ENVIA ERROR RuntimeException");
            }catch (R2dbcBadGrammarException s){
                throw new R2dbcBadGrammarException("SE ENVIA ERROR R2dbcBadGrammarException");
            }
        });
    }
}
