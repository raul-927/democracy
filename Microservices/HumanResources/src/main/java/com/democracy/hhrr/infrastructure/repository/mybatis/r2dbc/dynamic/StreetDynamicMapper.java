package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Street;

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


import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isLikeWhenPresent;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Collection;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport.*;

public interface StreetDynamicMapper extends CommonSelectMapper{

    BasicColumn[] streetColumnList = BasicColumn.columnList(streetId, streetName,streetType);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.streetId",keyColumn = "street_id")
    Mono<Integer> insert(InsertStatementProvider<Street> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.streetId",keyColumn = "street_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Street> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="StreetResult")
    Mono<Street> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="StreetResult")
    Flux<Street> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, STREET, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, STREET, completer);
    }

    default Mono<?> insert(Street record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, STREET, c ->
                c
                        .map(streetId).toPropertyWhenPresent("streetId", record::getStreetId)
                        .map(streetName).toProperty("streetName")
                        .map(streetType).toProperty("streetType")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Street> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, STREET, c ->
                c
                        .map(streetName).toProperty("streetName")
                        .map(streetType).toProperty("streetType")
        );
    }

    default Mono<Integer> insertSelective(Street record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, STREET, c ->
                c
                        .map(streetName).toPropertyWhenPresent("streetName", record::getStreetName)
                        .map(streetType).toPropertyWhenPresent("streetType", record::getStreetType)
        );
    }

    default Mono<Integer> deleteStreet(String id){
        return this.delete(
                d -> d.where(StreetDynamicSqlSupport.streetId, isEqualTo(id))
        );
    }

    default Mono<Street> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, streetColumnList, STREET, completer);
    }

    default Flux<Street> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, streetColumnList, STREET, completer);
    }
    default Flux<Street> selectStreet(Street street) {
        return select(str ->{
            if(street.getStreetId() != null ||
                    street.getStreetName() != null ||
                    street.getStreetType() !=null){
                if(street.getStreetId()!=null && !street.getStreetId().isEmpty()){
                    str.where(streetId,isEqualToWhenPresent(street.getStreetId()));
                }else{
                    str
                            .where(streetName,isLikeWhenPresent(street::getStreetName).map(s -> "%" + s + "%"))
                            .and(streetType,isLikeWhenPresent(street::getStreetType))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(streetId);
            }
            return str;
        });
    }

    default Flux<Street> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, streetColumnList, STREET, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, STREET, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Street record) {
        return update(c ->
                c
                        .set(streetName).equalToWhenPresent(record::getStreetName)
                        .set(streetType).equalToWhenPresent(record::getStreetType)
                        .where(streetId, isEqualTo(record::getStreetId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Street record) {
        return update(c ->
                c
                        .set(streetName).equalToWhenPresent(record::getStreetName)
                        .set(streetType).equalTo(record::getStreetType)
                        .where(streetId, isEqualTo(record::getStreetId))
        );
    }

    default Mono<Integer> updateAll(Street record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(streetName).equalToWhenPresent(record::getStreetName)
                        .set(streetType).equalTo(record::getStreetType)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Street record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(streetName).equalToWhenPresent(record::getStreetName)
                        .set(streetType).equalToWhenPresent(record::getStreetType)
                        .applyWhere(whereApplier)
        );
    }
}
