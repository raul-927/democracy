package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Profession;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.ProfessionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface ProfessionDynamicMapper extends CommonSelectMapper {
    BasicColumn[] professionColumnList = BasicColumn.columnList(professionId, professionName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.professionId",keyColumn = "profession_id")
    Mono<Integer> insert(InsertStatementProvider<Profession> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.professionId",keyColumn = "profession_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Profession> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="ProfessionResult")
    Mono<Profession> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="ProfessionResult")
    Flux<Profession> selectMany(SelectStatementProvider selectStatement);

    default Flux<Profession> selectAllProfessions(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, professionColumnList, PROFESSION, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, PROFESSION, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, PROFESSION, completer);
    }

    default Mono<Integer> insert(Profession record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, PROFESSION, c ->
                c
                        .map(professionId).toPropertyWhenPresent("professionId", record::getProfessionId)
                        .map(professionName).toProperty("professionName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Profession> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, PROFESSION, c ->
                c
                        .map(professionName).toProperty("professionName")
        );
    }

    default Mono<Integer> insertSelective(Profession record) {
        return ReactiveMyBatis3Utils.insert(
                this::insert, record, PROFESSION, c ->
                        c
                                .map(professionName).toPropertyWhenPresent("professionName", record::getProfessionName)
        );
    }

    default Mono<Integer> deleteProfession(String id){
        return this.delete(
                d -> d.where(professionId, isEqualTo(id))
        );
    }

    default Mono<Profession> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, professionColumnList, PROFESSION, completer);
    }

    default Flux<Profession> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, professionColumnList, PROFESSION, completer);
    }
    default Flux<Profession> selectProfession(Profession profession) {
        return select(str ->{

            if(profession.getProfessionId() != null ||
                    profession.getProfessionName() != null){
                if(profession.getProfessionId()!=null && !profession.getProfessionId().isEmpty()){
                    str.where(professionId,isEqualToWhenPresent(profession.getProfessionId()));
                }else{
                    str
                            .where(professionName,isLikeWhenPresent(profession::getProfessionName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(professionId);
            }
            return str;
        });
    }

    default Flux<Profession> selectAllProfessions(){
        return selectAllProfessions( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Profession> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, professionColumnList, PROFESSION, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, PROFESSION, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Profession record) {
        return update(c ->
                c
                        .set(professionName).equalToWhenPresent(record::getProfessionName)
                        .where(professionId, isEqualTo(record::getProfessionId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Profession record) {
        return update(c ->
                c
                        .set(professionName).equalToWhenPresent(record::getProfessionName)

                        .where(professionId, isEqualTo(record::getProfessionId))
        );
    }

    default Mono<Integer> updateAll(Profession record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(professionName).equalToWhenPresent(record::getProfessionName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Profession record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(professionName).equalToWhenPresent(record::getProfessionName)
                        .applyWhere(whereApplier)
        );
    }
}
