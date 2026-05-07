package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;


public final class PersonDocumentDynamicSqlSupport {

    public static final PersonDocumentTable PERSON_DOCUMENT = new PersonDocumentTable();
    public static final SqlColumn<String> personDocumentId = PERSON_DOCUMENT.personDocumentId;
    public static final SqlColumn<String> personId = PERSON_DOCUMENT.personId;
    public static final SqlColumn<String> documentId = PERSON_DOCUMENT.documentId;

    public static final class PersonDocumentTable extends SqlTable{

        public final SqlColumn<String> personDocumentId = column("person_document_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> personId = column("person_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> documentId = column("document_id", JDBCType.LONGNVARCHAR);

        public PersonDocumentTable() {
            super("PERSON_DOCUMENT");
        }
    }
}
