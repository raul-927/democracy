package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import com.democracy.hhrr.domain.aux.PersonDocument;
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

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.PersonDocumentDynamicSqlSupport.*;

public interface PersonDocumentDynamicMapper {

    BasicColumn[] personDocumentColumns = BasicColumn.columnList(personDocumentId, personId, documentId);

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    Mono<Long> counter(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    Mono<Integer> delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(keyProperty = "record.personDocumentId",keyColumn = "person_document_id")
    Mono<Integer> insert(InsertStatementProvider<PersonDocument> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    @Options(keyProperty = "record.personDocumentId",keyColumn = "person_document_id")
    Mono<Integer>  insertMultiple(MultiRowInsertStatementProvider<PersonDocument> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PersonDocumentResult")
    Mono<PersonDocument> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap(value="PersonDocumentResult")
    Flux<PersonDocument> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    Mono<Integer> update(UpdateStatementProvider updateStatement);

    default Mono<Long> count(CountDSLCompleter completer) {
        return ReactiveMyBatis3Utils.countFrom(this::counter, PERSON_DOCUMENT, completer);
    }

    default Mono<Integer> delete(DeleteDSLCompleter completer) {
        return ReactiveMyBatis3Utils.deleteFrom(this::delete, PERSON_DOCUMENT, completer);
    }

    default Mono<PersonDocument> selectOne(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectOne(this::selectOne, personDocumentColumns, PERSON_DOCUMENT, completer);
    }

    default Flux<PersonDocument> select(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectList(this::selectMany, personDocumentColumns, PERSON_DOCUMENT, completer);
    }


    default Flux<PersonDocument> selectDistinct(SelectDSLCompleter completer) {
        return ReactiveMyBatis3Utils.selectDistinct(this::selectMany, personDocumentColumns, PERSON_DOCUMENT, completer);
    }

    default Mono<Integer> update(UpdateDSLCompleter completer) {
        return ReactiveMyBatis3Utils.update(this::update, PERSON_DOCUMENT, completer);
    }
}
