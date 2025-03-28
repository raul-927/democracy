package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Penal;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
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
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PenalDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

public interface PenalDynamicMapper extends CommonSelectMapper {
    BasicColumn[] penalColumnList = BasicColumn.columnList(penalId, penalName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.penalId",keyColumn = "penal_id")
    Mono<Integer> insert(InsertStatementProvider<Penal> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.penalId",keyColumn = "penal_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Penal> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PenalResult")
    Mono<Penal> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PenalResult")
    Flux<Penal> selectMany(SelectStatementProvider selectStatement);

    default Flux<Penal> selectAllPenal(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, penalColumnList, PENAL, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, PENAL, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, PENAL, completer);
    }

    default Mono<Integer> insert(Penal record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, PENAL, c ->
                c
                        .map(penalId).toPropertyWhenPresent("penalId", record::getPenalId)
                        .map(penalName).toProperty("penalName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Penal> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, PENAL, c ->
                c
                        .map(penalName).toProperty("penalName")
        );
    }

    default Mono<Integer> insertSelective(Penal record) {
        return ReactiveMyBatis3Utils.insert(
                this::insert, record, PENAL, c ->
                        c
                                .map(penalName).toPropertyWhenPresent("penalName", record::getPenalName)
        );
    }

    default Mono<Integer> deletePenal(String id){
        return this.delete(
                d -> d.where(penalId, isEqualTo(id))
        );
    }

    default Mono<Penal> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, penalColumnList, PENAL, completer);
    }

    default Flux<Penal> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, penalColumnList, PENAL, completer);
    }
    default Flux<Penal> selectPenal(Penal penal) {
        return select(str ->{

            if(penal.getPenalId() != null ||
                    penal.getPenalName() != null){
                if(penal.getPenalId()!=null && !penal.getPenalId().isEmpty()){
                    str.where(penalId,isEqualToWhenPresent(penal.getPenalId()));
                }else{
                    str
                            .where(penalName,isLikeWhenPresent(penal::getPenalName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(penalId);
            }
            return str;
        });
    }

    default Flux<Penal> selectAllPenals(){
        return selectAllPenal( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Penal> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, penalColumnList, PENAL, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, PENAL, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Penal record) {
        return update(c ->
                c
                        .set(penalName).equalToWhenPresent(record::getPenalName)
                        .where(penalId, isEqualTo(record::getPenalId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Penal record) {
        return update(c ->
                c
                        .set(penalName).equalToWhenPresent(record::getPenalName)

                        .where(penalId, isEqualTo(record::getPenalId))
        );
    }

    default Mono<Integer> updateAll(Penal record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(penalName).equalToWhenPresent(record::getPenalName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Penal record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(penalName).equalToWhenPresent(record::getPenalName)
                        .applyWhere(whereApplier)
        );
    }
}
