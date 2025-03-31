package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.*;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.QualificationDocumentSqlSupport;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DocumentDynamicSqlSupport.*;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.InstituteDynamicSqlSupport.instituteId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.InstituteDynamicSqlSupport.instituteName;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.InstituteDynamicSqlSupport.addressId;
import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.QualificationDynamicSqlSupport.*;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface QualificationDynamicMapper extends CommonSelectMapper{

    BasicColumn[] qualificationInstituteDocumentColumnList = BasicColumn.columnList(
            qualificationId, verified, approved,qualificationInstituteId,
            instituteId,instituteName, addressId,
            documentId, documentName, documentVerified, documentApproved,documentObservation
            );

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.qualificationId",keyColumn = "qualification_id")
    Mono<Integer> insert(InsertStatementProvider<Qualification> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.qualificationId",keyColumn = "qualification_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Qualification> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="QualificationResult")
    Mono<Qualification> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="QualificationResult")
    Flux<Qualification> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, QUALIFICATION_TABLE, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, QUALIFICATION_TABLE, completer);
    }

    default Mono<Integer> insert(Qualification record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, QUALIFICATION_TABLE, c ->
                c
                        .map(qualificationId).toPropertyWhenPresent("qualificationId", record::getQualificationId)
                        .map(verified).toProperty("verified")
                        .map(approved).toProperty("approved")
                        .map(instituteId).toProperty("institute.instituteId")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Qualification> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, QUALIFICATION_TABLE, c ->
                c
                        .map(verified).toProperty("verified")
                        .map(approved).toProperty("approved")
                        .map(instituteId).toProperty("institute.instituteId")
        );
    }

    default Mono<Integer> insertSelective(Qualification record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, QUALIFICATION_TABLE, c ->
                c
                        .map(verified).toPropertyWhenPresent("verified", record::isVerified)
                        .map(approved).toPropertyWhenPresent("verified", record::isApproved)
                        .map(instituteId).toPropertyWhenPresent("verified", record.getInstitute()::getInstituteId)

        );
    }

    default Mono<Integer> deleteQualification(String id){
        return this.delete(
                d -> d.where(qualificationId, isEqualTo(id))
        );
    }

    default Mono<Qualification> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, qualificationInstituteDocumentColumnList, QUALIFICATION_TABLE, completer);
    }

    default Flux<Qualification> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, qualificationInstituteDocumentColumnList, QUALIFICATION_TABLE, completer);
    }

    default Flux<Qualification> selectFullColumnQualification(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, qualificationInstituteDocumentColumnList, QUALIFICATION_TABLE, completer);
    }
    default Flux<Qualification> selectAllQualifications(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, qualificationInstituteDocumentColumnList, QUALIFICATION_TABLE, completer);
    }
    default Flux<Qualification> selectDepartment(Qualification record) {
        return select(str ->{
            if(record.getQualificationId() != null){
                if(!record.getQualificationId().isEmpty()){
                    str.where(qualificationId,isEqualToWhenPresent(record.getQualificationId()));
                }else{
                    str
                            .where(verified,isEqualToWhenPresent(record::isVerified))
                            .and(approved, isEqualToWhenPresent(record::isApproved))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(qualificationId);
            }
            return str;
        });
    }
    default Flux<Qualification> selectFullQualification(Qualification record) {
        BindableColumn<Qualification> QUALIFICATION_qualification_id= DerivedColumn.of("qualification_id", "QUALIFICATION");
        BindableColumn<Qualification> QUALIFICATION_institute_id= DerivedColumn.of("institute_id", "QUALIFICATION");

        BindableColumn<Qualification> QUALIFICATION_DOCUMENT_qualification_id = DerivedColumn.of("qualification_id", "QUALIFICATION_DOCUMENT");
        BindableColumn<Qualification> QUALIFICATION_DOCUMENT_document_id = DerivedColumn.of("document_id", "QUALIFICATION_DOCUMENT");

        BindableColumn<Qualification> INSTITUTE_institute_id= DerivedColumn.of("institute_id", "INSTITUTE");
        BindableColumn<Qualification> DOCUMENT_document_id= DerivedColumn.of("document_id", "DOCUMENT");

        return selectFullColumnQualification(str ->{
           str
                    .join(QualificationDocumentSqlSupport.QUALIFICATION_DOCUMENT_TABLE)
                    .on(QUALIFICATION_qualification_id, equalTo(QUALIFICATION_DOCUMENT_qualification_id))

                    .join(DOCUMENT)
                    .on(QUALIFICATION_DOCUMENT_document_id,equalTo(DOCUMENT_document_id))

                    .join(InstituteDynamicSqlSupport.INSTITUTE_TABLE)
                    .on(QUALIFICATION_institute_id,equalTo(INSTITUTE_institute_id))
                    .build();


            if(record.getQualificationId() != null){
                if(!record.getQualificationId().isEmpty()){
                    str.where(qualificationId,isEqualToWhenPresent(record.getQualificationId()));
                }/*else{
                    str
                            .where(departmentName,isLikeWhenPresent(record::getDepartmentName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }*/
            }else{
                str.orderBy(qualificationId);
            }
            return str;
        });
    }

    default Flux<Qualification> selectAllQualifications(){
        return selectAllQualifications( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Qualification> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, qualificationInstituteDocumentColumnList, QUALIFICATION_TABLE, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, QUALIFICATION_TABLE, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Qualification record) {
        return update(c ->
                c
                        .set(verified).equalToWhenPresent(record::isVerified)
                        .set(approved).equalToWhenPresent(record::isApproved)
                        .set(qualificationInstituteId).equalToWhenPresent(record.getInstitute()::getInstituteId)
                        .where(qualificationId, isEqualTo(record::getQualificationId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Qualification record) {
        return update(c ->
                c
                        .set(approved).equalToWhenPresent(record::isApproved)
                        .set(verified).equalToWhenPresent(record::isVerified)
                        .set(qualificationInstituteId).equalToWhenPresent(record.getInstitute()::getInstituteId)
                        .where(qualificationId, isEqualTo(record::getQualificationId))
        );
    }

    default Mono<Integer> updateAll(Qualification record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(approved).equalToWhenPresent(record::isApproved)
                        .set(verified).equalToWhenPresent(record::isVerified)
                        .set(qualificationInstituteId).equalToWhenPresent(record.getInstitute()::getInstituteId)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Qualification record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(verified).equalToWhenPresent(record::isVerified)
                        .set(approved).equalToWhenPresent(record::isApproved)
                        .set(qualificationInstituteId).equalToWhenPresent(record.getInstitute()::getInstituteId)
                        .applyWhere(whereApplier)
        );
    }
}
