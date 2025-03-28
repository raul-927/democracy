package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Institute;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DocumentDynamicSqlSupport.documentName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.InstituteDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;


public interface InstituteDynamicMapper extends CommonSelectMapper {


    BasicColumn[] instituteColumnList = BasicColumn.columnList(instituteId, instituteName, addressId);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.instituteId",keyColumn = "institute_id")
    Mono<Integer> insert(InsertStatementProvider<Institute> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.documentId",keyColumn = "document_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Institute> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InstituteResult")
    Mono<Institute> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="InstituteResult")
    Flux<Institute> selectMany(SelectStatementProvider selectStatement);

    default Flux<Institute> selectAllInstitutes(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, instituteColumnList, INSTITUTE_TABLE, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, INSTITUTE_TABLE, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, INSTITUTE_TABLE, completer);
    }

    default Mono<Integer> insert(Institute record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, INSTITUTE_TABLE, c ->
                c
                        .map(instituteId).toPropertyWhenPresent("instituteId", record::getInstituteId)
                        .map(instituteName).toProperty("instituteName")
                        .map(addressId).toProperty("address.addressId")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Institute> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, INSTITUTE_TABLE, c ->
                c
                        .map(instituteId).toProperty("instituteId")
                        .map(instituteName).toProperty("instituteName")
                        .map(addressId).toProperty("address.addressId")
        );
    }

    default Mono<Integer> insertSelective(Institute record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, INSTITUTE_TABLE, c ->
                c
                        .map(instituteName).toPropertyWhenPresent("instituteName", record::getInstituteName)
                        .map(addressId).toPropertyWhenPresent("addressId", record.getAddress()::getAddressId)
        );
    }

    default Mono<Integer> deleteInstitute(String id){
        return this.delete(
                d -> d.where(instituteId, isEqualTo(id))
        );
    }

    default Mono<Institute> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, instituteColumnList, INSTITUTE_TABLE, completer);
    }

    default Flux<Institute> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, instituteColumnList, INSTITUTE_TABLE, completer);
    }
    default Flux<Institute> selectInstitute(Institute institute) {
        return select(str ->{

            if(institute.getInstituteId() != null || institute.getInstituteName() != null){
                if(institute.getInstituteId()!=null && !institute.getInstituteId().isEmpty()){
                    str.where(instituteId,isEqualToWhenPresent(institute.getInstituteId()));
                }else{
                    str
                            .where(instituteName,isLikeWhenPresent(institute::getInstituteName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(documentName);
            }
            return str;
        });
    }

    default Flux<Institute> selectAllInstitutes(){
        return selectAllInstitutes( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Institute> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, instituteColumnList, INSTITUTE_TABLE, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, INSTITUTE_TABLE, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Institute record) {
        return update(c ->
                c
                        .set(instituteName).equalToWhenPresent(record::getInstituteName)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .where(instituteName, isEqualTo(record::getInstituteName))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Institute record) {
        return update(c ->
                c
                        .set(instituteName).equalToWhenPresent(record::getInstituteName)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .where(instituteId, isEqualTo(record::getInstituteId))
        );
    }

    default Mono<Integer> updateAll(Institute record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(instituteName).equalToWhenPresent(record::getInstituteName)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Institute record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(instituteName).equalToWhenPresent(record::getInstituteName)
                        .set(addressId).equalToWhenPresent(record.getAddress()::getAddressId)
                        .applyWhere(whereApplier)
        );
    }
}
