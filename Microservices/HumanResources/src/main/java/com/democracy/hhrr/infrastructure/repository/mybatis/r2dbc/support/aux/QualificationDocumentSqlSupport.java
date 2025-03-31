package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class QualificationDocumentSqlSupport {

    public static final QualificationDocumentTable QUALIFICATION_DOCUMENT_TABLE = new QualificationDocumentTable();

    public static final SqlColumn<String> qualificationDocumentId = QUALIFICATION_DOCUMENT_TABLE.qualificationDocumentId;
    public static final SqlColumn<String> qualificationId = QUALIFICATION_DOCUMENT_TABLE.qualificationId;
    public static final SqlColumn<String> documentId = QUALIFICATION_DOCUMENT_TABLE.documentId;


    public static final class QualificationDocumentTable extends SqlTable{
        public final SqlColumn<String> qualificationDocumentId = column("qualificationDocumentId", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> qualificationId   = column("qualification_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> documentId = column("document_id",JDBCType.LONGNVARCHAR);

        public QualificationDocumentTable(){super("QUALIFICATION_DOCUMENT");}

    }
}
