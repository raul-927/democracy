package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.Neighborhood;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface CityDynamicMapper extends CommonSelectMapper{

    BasicColumn[] cityAndNeighborhoodColumnList = BasicColumn.columnList(cityId, cityName,neighborhoodId, neighborhoodName);
    BasicColumn[] cityColumnList = BasicColumn.columnList(cityId, cityName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.cityId",keyColumn = "city_id")
    Mono<Integer> insert(InsertStatementProvider<City> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.cityId",keyColumn = "city_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<City> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CityResult")
    Mono<City> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="CityResult")
    Flux<City> selectMany(SelectStatementProvider selectStatement);

    default Flux<City> selectAllCity(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, cityColumnList, neigh, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, cityTable, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, cityTable, completer);
    }

    default Mono<Integer> insert(City record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, cityTable, c ->
                c
                        .map(cityId).toPropertyWhenPresent("cityId", record::getCityId)
                        .map(cityName).toProperty("cityName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<City> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, cityTable, c ->
                c
                        .map(cityId).toProperty("cityId")
                        .map(cityName).toProperty("cityName")
        );
    }

    default Mono<Integer> insertSelective(City record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, cityTable, c ->
                c
                        .map(cityName).toPropertyWhenPresent("cityName", record::getCityName)
        );
    }

    default Mono<Integer> deleteCity(String id){
        return this.delete(
                d -> d.where(cityId, isEqualTo(id))
        );
    }

    default Mono<City> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, cityAndNeighborhoodColumnList, cityTable, completer);
    }

    default Flux<City> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, cityAndNeighborhoodColumnList, cityTable, completer);
    }
    default Flux<City> selectCity(City city) {
        return select(str ->{

            if(city.getCityId() != null ||
                    city.getCityName() != null){
                if(city.getCityId()!=null && !city.getCityId().isEmpty()){
                    str.where(cityId,isEqualToWhenPresent(city.getCityId()));
                }else{
                    str
                            .where(cityName,isLikeWhenPresent(city::getCityName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(cityName);
            }
            return str;
        });
    }

    default Flux<City> selectAllCity(){
        return selectAllCity( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<City> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, cityAndNeighborhoodColumnList, cityTable, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, cityTable, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(City record) {
        return update(c ->
                c
                        .set(cityName).equalToWhenPresent(record::getCityName)
                        .where(cityId, isEqualTo(record::getCityName))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(City record) {
        return update(c ->
                c
                        .set(cityName).equalToWhenPresent(record::getCityName)
                        .where(cityId, isEqualTo(record::getCityId))
        );
    }

    default Mono<Integer> updateAll(City record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(cityName).equalToWhenPresent(record::getCityName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(City record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(cityName).equalToWhenPresent(record::getCityName)
                        .applyWhere(whereApplier)
        );
    }
}
