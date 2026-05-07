package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.mappers.aux;


import com.democracy.hhrr.domain.aux.CityNeighborhood;
import com.democracy.hhrr.domain.aux.PersonDocument;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux.PersonDocumentDynamicMapper;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.CityNeighDynamicSqlSupport;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.PersonDocumentDynamicSqlSupport;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.where.WhereApplier;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.dynamic.ReactiveMyBatis3Utils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.PersonDocumentDynamicSqlSupport.*;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.PersonDocumentDynamicSqlSupport.PERSON_DOCUMENT;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface PersonDocumentMapper extends PersonDocumentDynamicMapper {
    default Mono<Integer> insert(PersonDocument record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, PERSON_DOCUMENT, c ->
                c
                        .map(personDocumentId).toProperty("personDocumentId")
                        .map(personId).toProperty("personId")
                        .map(documentId).toProperty("documentId")


        );
    }

    default Mono<Integer> insertMultiple(Collection<PersonDocument> records) {
        return ReactiveMyBatis3Utils.insertMultiple(this::insertMultiple, records, PERSON_DOCUMENT, c ->
                c

                        .map(personDocumentId).toProperty("personDocumentId")
                        .map(personId).toProperty("personId")
                        .map(documentId).toProperty("documentId")
        );
    }

    default Mono<Integer> insertSelective(PersonDocument record) {
        return ReactiveMyBatis3Utils.insert(this::insert, record, PERSON_DOCUMENT, c ->
                c
                        .map(personDocumentId).toPropertyWhenPresent("personDocumentId", record::getPersonDocumentId)
                        .map(personId).toPropertyWhenPresent("personId", record::getPersonId)
                        .map(documentId).toPropertyWhenPresent("documentId", record::getDocumentId)


        );
    }

    default Mono<Integer> deletePersonDocument(String id){
        return this.delete(
                d -> d.where(personDocumentId, isEqualTo(id))
        );
    }

    default Flux<PersonDocument> selectPersonDocument(PersonDocument personDocument) {
        return select(str ->{
            if(personDocument.getPersonDocumentId() != null ||
                    personDocument.getPersonId() != null ||
                    personDocument.getDocumentId()!=null){
                if(personDocument.getPersonDocumentId()!=null && !personDocument.getPersonDocumentId().isEmpty()){
                    str
                            .where(personDocumentId,isEqualToWhenPresent(personDocument::getPersonDocumentId));
                }else{
                    str
                            .where(personDocumentId,isLikeWhenPresent(personDocument::getDocumentId).map(s -> "%" + s + "%"))

                            .build()
                            .render(RenderingStrategies.MYBATIS3);
                }
            }else{
                str.orderBy(personDocumentId);
            }
            return str;
        });
    }

    default Mono<Integer> updateSelectiveByPrimaryKey(PersonDocument record) {
        return update(c ->
                c
                        .set(personId).equalToWhenPresent(record::getPersonId)
                        .set(documentId).equalToWhenPresent(record::getDocumentId)

                        .where(personDocumentId, isEqualTo(record::getPersonDocumentId))

        );
    }

    default Mono<Integer> updateAllByPrimaryKey(PersonDocument record) {
        return update(c ->
                c
                        .set(personId).equalToWhenPresent(record::getPersonId)
                        .set(documentId).equalToWhenPresent(record::getDocumentId)

                        .where(personDocumentId, isEqualTo(record::getPersonDocumentId))
        );
    }

    default Mono<Integer> updateAll(PersonDocument record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(personId).equalToWhenPresent(record::getPersonId)
                        .set(documentId).equalToWhenPresent(record::getDocumentId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Integer> updateSelective(PersonDocument record, WhereApplier whereApplier) {
        return update(c ->
                c
                        .set(personId).equalToWhenPresent(record::getPersonId)
                        .set(documentId).equalToWhenPresent(record::getDocumentId)

                        .applyWhere(whereApplier)
        );
    }

    default Mono<Long> count(){
        return count(dsl -> dsl);
    }
}
