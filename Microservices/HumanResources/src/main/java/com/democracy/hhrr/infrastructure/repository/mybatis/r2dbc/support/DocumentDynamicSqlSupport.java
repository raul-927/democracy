package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;


import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.Blob;
import java.sql.JDBCType;

public final class DocumentDynamicSqlSupport {
    public static final DocumentTable DOCUMENT = new DocumentTable();

    public static final SqlColumn<String> documentId    = DOCUMENT.documentId;
    public static final SqlColumn<String> documentName  = DOCUMENT.documentName;
    public static final SqlColumn<Boolean> documentVerified      = DOCUMENT.documentVerified;
    public static final SqlColumn<Boolean> documentApproved      = DOCUMENT.documentApproved;
    public static final SqlColumn<String> documentObservation   = DOCUMENT.documentObservation;
    public static final SqlColumn<Blob> documentAttachment    = DOCUMENT.documentAttachment;

    public static final class DocumentTable extends SqlTable {
        public final SqlColumn<String> documentId   = column("document_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> documentName = column("document_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Boolean> documentVerified     = column("verified", JDBCType.BINARY);
        public final SqlColumn<Boolean> documentApproved     = column("approved", JDBCType.BINARY);
        public final SqlColumn<String> documentObservation  = column("observation", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Blob> documentAttachment   = column("attachment", JDBCType.BLOB);

        public DocumentTable(){
            super("DOCUMENT");
        }

    }
}
