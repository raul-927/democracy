package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Person;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.ProfessionDynamicSqlSupport;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
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
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport.addressId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.CITY;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.CityDynamicSqlSupport.cityName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.DEPARTMENT;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DepartmentDynamicSqlSupport.departmentName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.NEIGHBORHOOD;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport.neighborhoodName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PersonDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.ProfessionDynamicSqlSupport.professionName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface PersonDynamicMapper extends CommonSelectMapper {
    BasicColumn[] personColumnList = BasicColumn.columnList(personId, cedula, civicCredential, firstName, secondName, firstLastName, secondLastName, isProcessed, addressId, professionId);
    BasicColumn[] fullPersonColumnList = BasicColumn.columnList(personId, cedula, civicCredential, firstName, secondName, firstLastName, secondLastName,isProcessed,
            addressId, geoLocation, addressNumber, street1, street2,
            departmentId, departmentName,
            cityId,cityName,
            neighborhoodId, neighborhoodName,
            streetId, streetName, streetType,
            streetId2, streetName2, streetType2,
            professionId, professionName);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.personId",keyColumn = "person_id")
    Mono<Integer> insert(InsertStatementProvider<Person> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.personId",keyColumn = "person_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Person> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PersonResult")
    Mono<Person> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PersonResult")
    Flux<Person> selectMany(SelectStatementProvider selectStatement);

    default Flux<Person> selectAllPerson(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, personColumnList, PERSON, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, PERSON, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, PERSON, completer);
    }

    default Mono<Integer> insert(Person record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, PERSON, c ->
                c
                        .map(personId).toPropertyWhenPresent("personId", record::getPersonId)
                        .map(cedula).toProperty("cedula")
                        .map(civicCredential).toProperty("civicCredential")
                        .map(firstName).toProperty("firstName")
                        .map(secondName).toProperty("secondName")
                        .map(firstLastName).toProperty("firstLastName")
                        .map(secondLastName).toProperty("secondLastName")
                        .map(isProcessed).toProperty("isProcessed")
                        .map(addressId).toPropertyWhenPresent("address.addressId", record.getAddress()::getAddressId)
                        .map(professionId).toPropertyWhenPresent("profession.professionId", record.getProfession()::getProfessionId)
        );
    }

    default Mono<Integer> insertMultiple(Collection<Person> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, PERSON, c ->
                c
                        .map(cedula).toProperty("cedula")
                        .map(civicCredential).toProperty("civicCredential")
                        .map(firstName).toProperty("firstName")
                        .map(secondName).toProperty("secondName")
                        .map(firstLastName).toProperty("firstLastName")
                        .map(secondLastName).toProperty("secondLastName")
                        .map(isProcessed).toProperty("isProcessed")
                        .map(addressId).toProperty("addressId")
                        .map(professionId).toProperty("professionId")
        );
    }

    default Mono<Integer> insertSelective(Person record) {
        return ReactiveMyBatis3Utils.insert(
                this::insert, record, PERSON, c ->
                        c
                                .map(cedula).toPropertyWhenPresent("cedula", record::getCedula)
                                .map(civicCredential).toPropertyWhenPresent("civicCredential", record::getCivicCredential)
                                .map(firstName).toPropertyWhenPresent("firstName", record::getFirstName)
                                .map(secondName).toPropertyWhenPresent("secondName", record::getSecondName)
                                .map(firstLastName).toPropertyWhenPresent("firstLastName", record::getFirstLastName)
                                .map(secondLastName).toPropertyWhenPresent("secondLastName", record::getSecondLastName)
                                .map(isProcessed).toPropertyWhenPresent("isProcessed", record::getIsProcessed)
                                .map(addressId).toPropertyWhenPresent("addressId", record.getAddress()::getAddressId)
                                .map(professionId).toPropertyWhenPresent("professionId", record.getProfession()::getProfessionId)
        );
    }

    default Mono<Integer> deletePerson(String id){
        return this.delete(
                d -> d.where(personId, isEqualTo(id))
        );
    }

    default Mono<Person> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, personColumnList, PERSON, completer);
    }

    default Flux<Person> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, fullPersonColumnList, PERSON, completer);
    }
    default Flux<Person> selectPerson(Person person) {
        BindableColumn<Person> personAddressId= DerivedColumn.of("address_id", "PERSON");
        BindableColumn<Person> personProfessionId= DerivedColumn.of("profession_id", "PERSON");

        BindableColumn<Person> addressAddressId= DerivedColumn.of("address_id", "ADDRESS");
        BindableColumn<Person> addressDepartmentId= DerivedColumn.of("department_id", "ADDRESS");
        BindableColumn<Person> addressCityId= DerivedColumn.of("city_id", "ADDRESS");
        BindableColumn<Person> addressNeighborhoodId= DerivedColumn.of("neighborhood_id", "ADDRESS");
        BindableColumn<Person> addressStreet1Id= DerivedColumn.of("street1_id", "ADDRESS");
        BindableColumn<Person> addressStreet2Id= DerivedColumn.of("street2_id", "ADDRESS");

        BindableColumn<Person> professionProfessionId= DerivedColumn.of("profession_id", "PROFESSION");
        BindableColumn<Person> departmentDepartmentId= DerivedColumn.of("department_id", "DEPARTMENT");
        BindableColumn<Person> cityCityId= DerivedColumn.of("city_id", "CITY");
        BindableColumn<Person> neighborhoodNeighborhoodId= DerivedColumn.of("neighborhood_id", "NEIGHBORHOOD");
        BindableColumn<Person> streetStreet1Id= DerivedColumn.of("street_id", "STREET");
        BindableColumn<Person> streetStreet2Id= DerivedColumn.of("street_id", "STREET");


        return select(str ->{

            str
                    .join(ADDRESS)
                    .on(personAddressId, equalTo(addressAddressId))

                    .join(DEPARTMENT)
                    .on(addressDepartmentId, equalTo(departmentDepartmentId))

                    .join(CITY)
                    .on(addressCityId, equalTo(cityCityId))

                    .join(NEIGHBORHOOD)
                    .on(addressNeighborhoodId, equalTo(neighborhoodNeighborhoodId))

                    .join(STREET)
                    .on(addressStreet1Id, equalTo(streetStreet1Id))

                    .join(ProfessionDynamicSqlSupport.PROFESSION)
                    .on(personProfessionId, equalTo(professionProfessionId)).build().render(RenderingStrategies.MYBATIS3);

            if (person.getPersonId() == null             && person.getIsProcessed()==null
                    && person.getAddress() ==null        && person.getProfession() ==null
                    && person.getCedula() ==0            && person.getFirstName() ==null
                    && person.getFirstLastName() == null && person.getSecondName() == null
                    && person.getSecondLastName() ==null) {
                str.orderBy(firstLastName);
            }else if(person.getPersonId() != null ||
                    person.getFirstName() != null || person.getCedula()!= 0){
                        if(person.getPersonId()!=null && !person.getPersonId().isEmpty()){
                            str.where(personId,isEqualToWhenPresent(person::getPersonId))
                                    .build()
                                    .render(RenderingStrategies.MYBATIS3);
                        } else {
                                    str
                                            .where(cedula,isEqualToWhenPresent(person::getCedula))
                                            .build()
                                            .render(RenderingStrategies.MYBATIS3);
                        }
                    }else{
                            str
                                    .where(isProcessed,isEqualToWhenPresent(person::getIsProcessed))
                                    .and(firstName,isLikeWhenPresent(person::getFirstName).map(s -> "%" + s + "%"))
                                    .and(secondName,isLikeWhenPresent(person::getSecondName).map(s ->"%"+s+"%"))
                                    .and(firstLastName,isLikeWhenPresent(person::getFirstLastName).map(s ->"%"+s+"%"))
                                    .build()
                                    .render(RenderingStrategies.MYBATIS3);
            }
            return str;
        });
    }

    default Flux<Person> selectAllPersons(){
        return selectAllPerson( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Person> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, personColumnList, PERSON, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, PERSON, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Person record) {
        return update(c ->
                c
                        .set(cedula).equalToWhenPresent(record::getCedula)
                        .set(civicCredential).equalToWhenPresent(record::getCivicCredential)
                        .set(firstName).equalToWhenPresent(record::getFirstName)
                        .set(secondName).equalToWhenPresent(record::getSecondName)
                        .set(firstLastName).equalToWhenPresent(record::getFirstLastName)
                        .set(secondLastName).equalToWhenPresent(record::getSecondLastName)
                        .set(isProcessed).equalToWhenPresent(record::getIsProcessed)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)

                        .where(personId, isEqualTo(record::getPersonId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Person record) {
        String stringAddressId = record.getAddress()!=null? record.getAddress().getAddressId():null;
        String stringProfessionId = record.getProfession()!=null? record.getProfession().getProfessionId():null;
        return update(c ->
                c
                        .set(civicCredential).equalToWhenPresent(record::getCivicCredential)
                        .set(firstName).equalToWhenPresent(record::getFirstName)
                        .set(secondName).equalToWhenPresent(record::getSecondName)
                        .set(firstLastName).equalToWhenPresent(record::getFirstLastName)
                        .set(secondLastName).equalToWhenPresent(record::getSecondLastName)
                        .set(isProcessed).equalToWhenPresent(record::getIsProcessed)
                        .set(addressId).equalToWhenPresent(stringAddressId)
                        .set(professionId).equalToWhenPresent(stringProfessionId)

                        .where(personId, isEqualToWhenPresent(record::getPersonId))
                        .and(cedula, isEqualToWhenPresent(record::getCedula))
        );
    }

    default Mono<Integer> updateAll(Person record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(cedula).equalToWhenPresent(record::getCedula)
                        .set(civicCredential).equalToWhenPresent(record::getCivicCredential)
                        .set(firstName).equalToWhenPresent(record::getFirstName)
                        .set(secondName).equalToWhenPresent(record::getSecondName)
                        .set(firstLastName).equalToWhenPresent(record::getFirstLastName)
                        .set(secondLastName).equalToWhenPresent(record::getSecondLastName)
                        .set(isProcessed).equalToWhenPresent(record::getIsProcessed)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Person record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(cedula).equalToWhenPresent(record::getCedula)
                        .set(civicCredential).equalToWhenPresent(record::getCivicCredential)
                        .set(firstName).equalToWhenPresent(record::getFirstName)
                        .set(secondName).equalToWhenPresent(record::getSecondName)
                        .set(firstLastName).equalToWhenPresent(record::getFirstLastName)
                        .set(secondLastName).equalToWhenPresent(record::getSecondLastName)
                        .set(isProcessed).equalToWhenPresent(record::getIsProcessed)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)
                        .applyWhere(whereApplier)
        );
    }
}
