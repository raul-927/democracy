package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Address;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
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
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodName;



import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface AddressDynamicMapper extends CommonSelectMapper{

    BasicColumn[] addressColumnList = BasicColumn.columnList(addressId, addressNumber, geoLocation);

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
    @ResultMap(value="com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.AddressMapper.AddressResult")
    Mono<Address> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.AddressMapper.AddressResult")
    Flux<Address> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, addr, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, addr, completer);
    }

    default Mono<Integer> insert(Address record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, addr, c ->
                c
                        .map(addressId).toPropertyWhenPresent("addressId", record::getAddressId)
                        .map(addressNumber).toProperty("addressNumber")
                        .map(geoLocation).toProperty("geoLocation")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Address> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, addr, c ->
                c

                        .map(addressNumber).toProperty("addressNumber")
                        .map(geoLocation).toProperty("geoLocation")
        );
    }

    default Mono<Integer> insertSelective(Address record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, addr, c ->
                c
                        .map(addressId).toPropertyWhenPresent("addressId", record::getAddressId)
                        .map(addressNumber).toPropertyWhenPresent("addressNumber", record::getAddressNumber)
                        .map(geoLocation).toPropertyWhenPresent("geoLocation", record::getGeoLocation)

        );
    }

    default Mono<Integer> deleteAddress(String id){
        return this.delete(
                d -> d.where(AddrerssDynamicSqlSupport.addressId, isEqualTo(id))
        );
    }

    default Mono<Address> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, addressColumnList, addr, completer);
    }

    default Flux<Address> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, addressColumnList, addr, completer);
    }
    default Flux<Address> selectAddress(Address address) {
        BindableColumn<Address> joinAddressNeighborhoodColumn = DerivedColumn.of("neighborhood_id", "ADDRESS");
        BindableColumn<Address> joinNeighborhoodColumn = DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");
        return select(str ->{
                str.join(NeighborhoodDynamicSqlSupport.NEIGHBORHOOD)
                    .on(joinAddressNeighborhoodColumn,equalTo(joinNeighborhoodColumn)).build();
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
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, addressColumnList, addr, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, addr, completer);
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
