package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import com.democracy.hhrr.domain.aux.QualificationDocument;
import org.apache.ibatis.annotations.*;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.QualificationDocumentSqlSupport.*;

public interface QualificationDocumentDynamicMapper {

    BasicColumn[] qualificationDocumentColumns = BasicColumn.columnList(qualificationDocumentId, qualificationId, documentId);


    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> counter(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.qualification_document_id",keyColumn = "qualification_document_id")
    Mono<Integer> insert(InsertStatementProvider<QualificationDocument> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.qualification_document_id",keyColumn = "qualification_document_id")
    Mono<Integer> insertMultiple(MultiRowInsertStatementProvider<QualificationDocument> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="QualificationDocumentResult")
    Mono<QualificationDocument> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="QualificationDocumentResult")
    Flux<QualificationDocument> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::counter, QUALIFICATION_DOCUMENT_TABLE, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, QUALIFICATION_DOCUMENT_TABLE, completer);
    }

    default Mono<QualificationDocument> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, qualificationDocumentColumns, QUALIFICATION_DOCUMENT_TABLE, completer);
    }

    default Flux<QualificationDocument> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, qualificationDocumentColumns, QUALIFICATION_DOCUMENT_TABLE, completer);
    }


    default Flux<QualificationDocument> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, qualificationDocumentColumns, QUALIFICATION_DOCUMENT_TABLE, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, QUALIFICATION_DOCUMENT_TABLE, completer);
    }

}
