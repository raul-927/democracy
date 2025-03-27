package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;


import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.Blob;
import java.sql.JDBCType;

public final class DocumentDynamicSqlSupport {
    public static final DocumentTable DOCUMENT = new DocumentTable();

    public static final SqlColumn<String> documentId    = DOCUMENT.documentId;
    public static final SqlColumn<String> documentName  = DOCUMENT.documentName;
    public static final SqlColumn<Boolean> verified      = DOCUMENT.verified;
    public static final SqlColumn<Boolean> approved      = DOCUMENT.approved;
    public static final SqlColumn<String> observation   = DOCUMENT.observation;
    public static final SqlColumn<Blob> attachment    = DOCUMENT.attachment;

    public static final class DocumentTable extends SqlTable {
        public final SqlColumn<String> documentId   = column("document_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> documentName = column("document_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Boolean> verified     = column("verified", JDBCType.BINARY);
        public final SqlColumn<Boolean> approved     = column("approved", JDBCType.BINARY);
        public final SqlColumn<String> observation  = column("observation", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Blob> attachment   = column("attachment", JDBCType.BLOB);

        public DocumentTable(){
            super("DOCUMENT");
        }

    }
}
