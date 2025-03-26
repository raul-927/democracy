package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.CriminalRecord;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.BindableColumn;
import org.mybatis.dynamic.sql.DerivedColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.where.WhereApplier;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;


import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CriminalRecordDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.penalName;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

public interface CriminalRecordDynamicMapper {

    BasicColumn[] criminalRecordColumnList = BasicColumn.columnList(
            criminalRecordId, criminalRecordName, criminalRecordDescription, penalId);

    BasicColumn[] criminalRecordColumns = BasicColumn.columnList(
            criminalRecordId, criminalRecordName, criminalRecordDescription, penalId,
            penalName
    );

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.criminalRecordId",keyColumn = "criminal_record_id")
    Mono<Integer> insert(InsertStatementProvider<CriminalRecord> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.criminalRecordId",keyColumn = "criminal_record_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<CriminalRecord> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CriminalRecordResult")
    Mono<CriminalRecord> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CriminalRecordResult")
    Flux<CriminalRecord> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, CRIMINAL_RECORD, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, CRIMINAL_RECORD, completer);
    }

    default Mono<Integer> insert(CriminalRecord record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, CRIMINAL_RECORD, c ->
                c
                        .map(criminalRecordId).toPropertyWhenPresent("criminalRecordIdd", record::getCriminalRecordId)
                        .map(criminalRecordName).toProperty("criminalRecordName")
                        .map(criminalRecordDescription).toProperty("criminalRecordDescription")
                        .map(penalId).toProperty("penalId")
        );
    }

    default Mono<Integer> insertMultiple(Collection<CriminalRecord> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, CRIMINAL_RECORD, c ->
                c
                        .map(criminalRecordName).toProperty("criminalRecordName")
                        .map(criminalRecordDescription).toProperty("criminalRecordDescription")
                        .map(penalId).toProperty("penalId")
        );
    }

    default Mono<Integer> insertSelective(CriminalRecord record) {
        return ReactiveMyBatis3Utils.insert(
                this::insert, record, CRIMINAL_RECORD, c ->
                        c
                                .map(criminalRecordName).toPropertyWhenPresent("criminalRecordName", record::getCriminalRecordName)
                                .map(criminalRecordDescription).toPropertyWhenPresent("criminalRecordDescription", record::getCriminalRecordDescription)
                                .map(penalId).toPropertyWhenPresent("penalId", record.getPenal()::getPenalId)
        );
    }

    default Mono<Integer> deleteCriminalRecord(String id){
        return this.delete(
                d -> d.where(criminalRecordId, isEqualTo(id))
        );
    }

    default Flux<CriminalRecord> selectFullCriminalRecord(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, criminalRecordColumns, CRIMINAL_RECORD, completer);
    }

    default Mono<CriminalRecord> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, criminalRecordColumnList, CRIMINAL_RECORD, completer);
    }

    default Flux<CriminalRecord> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, criminalRecordColumnList, CRIMINAL_RECORD, completer);
    }
    default Flux<CriminalRecord> selectFullCriminalRecord(CriminalRecord criminalRecord) {
        BindableColumn<CriminalRecord> CRIMINAL_RECORD_penal_id= DerivedColumn.of("penal_id", "CRIMINAL_RECORD");
        BindableColumn<CriminalRecord> PENAL_penal_id= DerivedColumn.of("penal_id", "PENAL");

        return selectFullCriminalRecord(crm ->{
                crm.join(PenalDynamicSqlSupport.PENAL)
                    .on(CRIMINAL_RECORD_penal_id, equalTo(PENAL_penal_id));

            if(criminalRecord.getCriminalRecordId() != null ||
                    criminalRecord.getCriminalRecordDescription() != null ||
                    criminalRecord.getCriminalRecordName() !=null){
                if(criminalRecord.getCriminalRecordId()!=null && !criminalRecord.getCriminalRecordId().isEmpty()){
                    crm.where(criminalRecordId,isEqualToWhenPresent(criminalRecord.getCriminalRecordId()));
                }else{
                    crm
                            .where(criminalRecordName,isLikeWhenPresent(criminalRecord::getCriminalRecordName).map(s -> "%" + s + "%"))
                            .and(criminalRecordDescription,isLikeWhenPresent(criminalRecord::getCriminalRecordDescription))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                crm.orderBy(criminalRecordId);
            }
            return crm;
        });
    }

    default Flux<CriminalRecord> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, criminalRecordColumnList, CRIMINAL_RECORD, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, CRIMINAL_RECORD, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(CriminalRecord record) {
        return update(c ->
                c
                        .set(criminalRecordName).equalToWhenPresent(record::getCriminalRecordName)
                        .set(criminalRecordDescription).equalToWhenPresent(record::getCriminalRecordDescription)
                        .set(penalId).equalToWhenPresent(record.getPenal()::getPenalId)
                        .where(criminalRecordId, isEqualTo(record::getCriminalRecordId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(CriminalRecord record) {
        return update(c ->
                c
                        .set(criminalRecordName).equalToWhenPresent(record::getCriminalRecordName)
                        .set(criminalRecordDescription).equalTo(record::getCriminalRecordDescription)
                        .set(penalId).equalTo(record.getPenal()::getPenalId)
                        .where(criminalRecordId, isEqualTo(record::getCriminalRecordId))
        );
    }

    default Mono<Integer> updateAll(CriminalRecord record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(criminalRecordName).equalToWhenPresent(record::getCriminalRecordName)
                        .set(criminalRecordDescription).equalTo(record::getCriminalRecordDescription)
                        .set(penalId).equalTo(record.getPenal()::getPenalId)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(CriminalRecord record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(criminalRecordName).equalToWhenPresent(record::getCriminalRecordName)
                        .set(criminalRecordDescription).equalToWhenPresent(record::getCriminalRecordDescription)
                        .set(penalId).equalToWhenPresent(record.getPenal()::getPenalId)
                        .applyWhere(whereApplier)
        );
    }

}
