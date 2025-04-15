package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Person;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.PersonDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface PersonDynamicMapper extends CommonSelectMapper {
    BasicColumn[] personColumnList = BasicColumn.columnList(personId, cedula, civicCredential, firstName, secondName, firstLastName, secondLastName, addressId, professionId);

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
        return ReactiveMyBatis3Utils.selectList(this::selectMany, personColumnList, PERSON, completer);
    }
    default Flux<Person> selectPerson(Person person) {
        return select(str ->{

            if(person.getPersonId() != null ||
                    person.getFirstName() != null){
                if(person.getPersonId()!=null && !person.getPersonId().isEmpty()){
                    str.where(personId,isEqualToWhenPresent(person.getPersonId()));
                }else{
                    str
                            .where(firstName,isLikeWhenPresent(person::getFirstName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(firstLastName);
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
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)

                        .where(personId, isEqualTo(record::getPersonId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Person record) {
        return update(c ->
                c
                        .set(cedula).equalToWhenPresent(record::getCedula)
                        .set(civicCredential).equalToWhenPresent(record::getCivicCredential)
                        .set(firstName).equalToWhenPresent(record::getFirstName)
                        .set(secondName).equalToWhenPresent(record::getSecondName)
                        .set(firstLastName).equalToWhenPresent(record::getFirstLastName)
                        .set(secondLastName).equalToWhenPresent(record::getSecondLastName)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)

                        .where(personId, isEqualTo(record::getPersonId))
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
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .set(professionId).equalToWhenPresent(record.getProfession()::getProfessionId)
                        .applyWhere(whereApplier)
        );
    }
}
