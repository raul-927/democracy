package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport;
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
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.CommonSelectMapper;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface CityDynamicMapper extends CommonSelectMapper{

    BasicColumn[] cityAndNeighborhoodColumnList = BasicColumn.columnList(cityId, cityName,neighborhoodId, neighborhoodName, streetId, streetName, streetType);
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
        return ReactiveMyBatis3Utils.selectList(this::selectMany, cityColumnList, CITY, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, CITY, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, CITY, completer);
    }

    default Mono<Integer> insert(City record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, CITY, c ->
                c
                        .map(cityId).toPropertyWhenPresent("cityId", record::getCityId)
                        .map(cityName).toProperty("cityName")
        );
    }

    default Mono<Integer> insertMultiple(Collection<City> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, CITY, c ->
                c
                        .map(cityId).toProperty("cityId")
                        .map(cityName).toProperty("cityName")
        );
    }

    default Mono<Integer> insertSelective(City record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, CITY, c ->
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
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, cityAndNeighborhoodColumnList, CITY, completer);
    }

    default Flux<City> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, cityAndNeighborhoodColumnList, CITY, completer);
    }
    default Flux<City> selectCity(City city) {
        return select(str ->{
            BindableColumn<City> cityCityId= DerivedColumn.of("city_id", "CITY");
            BindableColumn<City> cityNeighCityId = DerivedColumn.of("city_id", "CITY_NEIGH");

            BindableColumn<City> neighborhoodNeighborhoodId = DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");
            BindableColumn<City> cityNeighNeighborhoodId = DerivedColumn.of("neighborhood_id", "CITY_NEIGH");
            BindableColumn<City> neighStreetNeighborhoodId = DerivedColumn.of("neighborhood_id", "NEIGH_STREET");

            BindableColumn<City> streetStreetId = DerivedColumn.of("street_id", "STREET");
            BindableColumn<City> neighStreetStreetId= DerivedColumn.of("street_id", "NEIGH_STREET");
            str
                    .join(CityNeighDynamicSqlSupport.CITY_NEIGH)
                    .on(cityNeighCityId, equalTo(cityCityId))

                    .join(NEIGHBORHOOD)
                    .on(cityNeighNeighborhoodId,equalTo(neighborhoodNeighborhoodId))

                    .join(NeighborhoodStreetDynamicSqlSupport.NEIGH_STREET)
                    .on(neighborhoodNeighborhoodId,equalTo(neighStreetNeighborhoodId))

                    .join(StreetDynamicSqlSupport.str)
                    .on(streetStreetId, equalTo(neighStreetStreetId)).build();

            if(city.getCityId() != null || city.getCityName() != null){
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
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, cityAndNeighborhoodColumnList, CITY, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, CITY, completer);
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
