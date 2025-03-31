package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic;

import com.democracy.hhrr.domain.models.Document;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.DocumentDynamicSqlSupport.*;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

public interface DocumentDynamicMapper extends CommonSelectMapper{

    BasicColumn[] documentColumnList = BasicColumn.columnList(documentId, documentName, documentVerified, documentApproved, documentObservation, documentAttachment);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.documentId",keyColumn = "document_id")
    Mono<Integer> insert(InsertStatementProvider<Document> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.documentId",keyColumn = "document_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<Document> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DocumentResult")
    Mono<Document> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="DocumentResult")
    Flux<Document> selectMany(SelectStatementProvider selectStatement);

    default Flux<Document> selectAllDocuments(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, documentColumnList, DOCUMENT, completer);
    }

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::count, DOCUMENT, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, DOCUMENT, completer);
    }

    default Mono<Integer> insert(Document record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DOCUMENT, c ->
                c
                        .map(documentId).toPropertyWhenPresent("documentId", record::getDocumentId)
                        .map(documentName).toProperty("documentName")
                        .map(documentVerified).toProperty("documentVerified")
                        .map(documentApproved).toProperty("documentApproved")
                        .map(documentObservation).toProperty("documentObservation")
                        .map(documentAttachment).toProperty("documentAttachment")
        );
    }

    default Mono<Integer> insertMultiple(Collection<Document> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, DOCUMENT, c ->
                c
                        .map(documentId).toProperty("documentId")
                        .map(documentName).toProperty("documentName")
                        .map(documentVerified).toProperty("documentVerified")
                        .map(documentApproved).toProperty("documentApproved")
                        .map(documentObservation).toProperty("documentObservation")
                        .map(documentAttachment).toProperty("documentAttachment")
        );
    }

    default Mono<Integer> insertSelective(Document record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, DOCUMENT, c ->
                c
                        .map(documentName).toPropertyWhenPresent("documentName", record::getDocumentName)
                        .map(documentVerified).toPropertyWhenPresent("verified", record::isDocumentVerified)
                        .map(documentApproved).toPropertyWhenPresent("approved", record::isDocumentApproved)
                        .map(documentObservation).toPropertyWhenPresent("observation", record::getDocumentObservation)
                        .map(documentAttachment).toPropertyWhenPresent("attachment", record::getDocumentAttachment)
        );
    }

    default Mono<Integer> deleteDocument(String id){
        return this.delete(
                d -> d.where(documentId, isEqualTo(id))
        );
    }

    default Mono<Document> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, documentColumnList, DOCUMENT, completer);
    }

    default Flux<Document> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, documentColumnList, DOCUMENT, completer);
    }
    default Flux<Document> selectDocument(Document document) {
        return select(str ->{

            if(document.getDocumentId() != null || document.getDocumentName() != null){
                if(document.getDocumentId()!=null && !document.getDocumentId().isEmpty()){
                    str.where(documentId,isEqualToWhenPresent(document.getDocumentId()));
                }else{
                    str
                            .where(documentName,isLikeWhenPresent(document::getDocumentName).map(s -> "%" + s + "%"))
                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(documentName);
            }
            return str;
        });
    }

    default Flux<Document> selectAllDocuments(){
        return selectAllDocuments( sel ->{
            sel.build();
            return sel;
        });
    }

    default Flux<Document> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, documentColumnList, DOCUMENT, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, DOCUMENT, completer);
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(Document record) {
        return update(c ->
                c
                        .set(documentName).equalToWhenPresent(record::getDocumentName)
                        .where(documentName, isEqualTo(record::getDocumentName))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(Document record) {
        return update(c ->
                c
                        .set(documentName).equalToWhenPresent(record::getDocumentName)
                        .where(documentId, isEqualTo(record::getDocumentId))
        );
    }

    default Mono<Integer> updateAll(Document record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(documentName).equalToWhenPresent(record::getDocumentName)
                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(Document record, WhereApplier whereApplier) {
        return update(c ->
                c.
                        set(documentName).equalToWhenPresent(record::getDocumentName)
                        .applyWhere(whereApplier)
        );
    }
}
