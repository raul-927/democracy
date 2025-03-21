package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Address;

import com.democracy.hhrr.domain.models.Department;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.*;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.DepartmentCityDynamicSqlSupport;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodName;


import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface AddressDynamicMapper extends CommonSelectMapper{

    BasicColumn[] addressColumnList = BasicColumn.columnList(addressId, addressNumber, geoLocation);
    BasicColumn[] addressFullColumnList = BasicColumn.columnList(addressId, addressNumber, geoLocation,departmentId, departmentName,
            cityId, cityName,
            neighborhoodId, neighborhoodName,
            streetId, streetName, streetType,
            streetId2, streetName2, streetType2);
    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.addressId",keyColumn = "address_id")
    Mono<Integer> insert(InsertStatementProvider<Address> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.addressId",keyColumn = "address_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Address> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="AddressResult")
    Mono<Address> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="AddressResult")
    Flux<Address> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, ADDRESS, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, ADDRESS, completer);
    }

    default Mono<Integer> insert(Address record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, ADDRESS, c ->
                c
                        .map(addressId).toPropertyWhenPresent("addressId", record::getAddressId)
                        .map(geoLocation).toProperty("geoLocation")
                        .map(addressNumber).toProperty("addressNumber")
                        .map(departmentId).toProperty("department.departmentId")
                        //.map(cityId).toProperty("city.cityId")
                        //.map(neighborhoodId).toProperty("neighborhood.neighborhoodId")
                        .map(street1).toProperty("street1.streetId")
                        .map(street2).toProperty("street2.streetId")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Address> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, ADDRESS, c ->
                c

                        .map(geoLocation).toProperty("geoLocation")
                        .map(addressNumber).toProperty("addressNumber")
                        .map(departmentId).toProperty("department.departmentId")
                        //.map(cityId).toProperty("city.cityId")
                        //.map(neighborhoodId).toProperty("neighborhood.neighborhoodId")
                        .map(street1).toProperty("street1.streetId")
                        .map(street2).toProperty("street2.streetId")
        );
    }

    default Mono<Integer> insertSelective(Address record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, ADDRESS, c ->
                c
                        .map(addressId).toPropertyWhenPresent("addressId", record::getAddressId)
                        .map(addressNumber).toPropertyWhenPresent("addressNumber", record::getAddressNumber)
                        .map(geoLocation).toPropertyWhenPresent("geoLocation", record::getGeoLocation)
                        .map(departmentId).toPropertyWhenPresent("department.departmentId", record.getDepartment()::getDepartmentId)
                        //.map(cityId).toPropertyWhenPresent("city.cityId", record.getCity()::getCityId)
                        //.map(neighborhoodId).toPropertyWhenPresent("neighborhood.neighborhoodId", record.getNeighborhood()::getNeighborhoodId)
                        .map(street1).toPropertyWhenPresent("street1.streetId", record.getStreet1()::getStreetId)
                        .map(street2).toPropertyWhenPresent("street2.streetId", record.getStreet2()::getStreetId)

        );
    }

    default Mono<Integer> deleteAddress(String id){
        return this.delete(
                d -> d.where(AddrerssDynamicSqlSupport.addressId, isEqualTo(id))
        );
    }

    default Mono<Address> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, addressColumnList, ADDRESS, completer);
    }

    default Flux<Address> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, addressColumnList, ADDRESS, completer);
    }

    default Flux<Address> selectFull(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, addressFullColumnList, ADDRESS, completer);
    }

    default Flux<Address> selectAddress(Address address) {
        BindableColumn<Address>ADDRESS_DEPARTMENT_department_id = DerivedColumn.of("department_id", "ADDRESS");
        //BindableColumn<Address>ADDRESS_CITY_city_id = DerivedColumn.of("city_id", "ADDRESS");
        //BindableColumn<Address>ADDRESS_NEIGHBORHOOD_neighborhood_id = DerivedColumn.of("neighborhood_id", "ADDRESS");
        BindableColumn<Address>ADDRESS_STREET_street1_id = DerivedColumn.of("street1_id", "ADDRESS");
        BindableColumn<Address>ADDRESS_STREET_street2_id = DerivedColumn.of("street2_id", "ADDRESS");

        BindableColumn<Address> DEPARTMENT_department_id= DerivedColumn.of("department_id", "DEPARTMENT");
        BindableColumn<Address> CITY_city_id= DerivedColumn.of("city_id", "CITY");
        BindableColumn<Address> NEIGHBORHOOD_neighborhood_id = DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");
        BindableColumn<Address> STREET_street1_id = DerivedColumn.of("street_id", "S1");
        BindableColumn<Address> STREET_street2_id = DerivedColumn.of("street_id", "S2");
        return selectFull(str ->{
                str
                        .join(DepartmentDynamicSqlSupport.DEPARTMENT)
                        .on(DEPARTMENT_department_id, equalTo(ADDRESS_DEPARTMENT_department_id))

                        //.join(CityDynamicSqlSupport.CITY)
                        //.on(CITY_city_id,equalTo(ADDRESS_CITY_city_id))

                        //.join(NeighborhoodDynamicSqlSupport.NEIGHBORHOOD)
                        //.on(ADDRESS_NEIGHBORHOOD_neighborhood_id,equalTo(NEIGHBORHOOD_neighborhood_id))

                        .join(StreetDynamicSqlSupport.STREET, "S1")
                        .on(ADDRESS_STREET_street1_id,equalTo(STREET_street1_id))

                        .join(StreetDynamicSqlSupport.STREET2, "S2")
                        .on(ADDRESS_STREET_street2_id,equalTo(STREET_street2_id))
                        .build();

            if(address.getAddressId() != null ||
                    address.getAddressNumber() != null){
                if(address.getAddressId()!=null && !address.getAddressId().isEmpty()){
                    str.where(addressId,isEqualToWhenPresent(address.getAddressId()));
                }else{
                    str
                            .where(addressNumber,isLikeWhenPresent(address::getAddressNumber).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(addressId);
            }
            return str;
        });
    }

    default Flux<Address> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, addressColumnList, ADDRESS, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, ADDRESS, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Address record) {
        return update(c ->
                c
                        .set(addressNumber).equalToWhenPresent(record::getAddressNumber)

                        .where(addressId, isEqualTo(record::getAddressId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Address record) {
        return update(c ->
                c
                        .set(addressNumber).equalToWhenPresent(record::getAddressNumber)
                        .where(addressId, isEqualTo(record::getAddressId))
        );
    }

    default Mono<Integer> updateAll(Address record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(addressNumber).equalToWhenPresent(record::getAddressNumber)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Address record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(addressNumber).equalToWhenPresent(record::getAddressNumber)
                        .applyWhere(whereApplier)
        );
    }
}
