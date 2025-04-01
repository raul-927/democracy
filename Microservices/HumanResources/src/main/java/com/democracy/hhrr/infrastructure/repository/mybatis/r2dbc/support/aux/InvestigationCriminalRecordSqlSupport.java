package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class InvestigationCriminalRecordSqlSupport {

    public static final InvestigationCriminalRecordTable INVESTIGATION_CRIMINAL_RECORD_TABLE = new InvestigationCriminalRecordTable();

    public static final SqlColumn<String> investigationCriminalRecordId = INVESTIGATION_CRIMINAL_RECORD_TABLE.investigationCriminalRecordId;
    public static final SqlColumn<String> investigationId = INVESTIGATION_CRIMINAL_RECORD_TABLE.investigationId;
    public static final SqlColumn<String> criminalRecordId = INVESTIGATION_CRIMINAL_RECORD_TABLE.criminalRecordId;


    public static final class InvestigationCriminalRecordTable extends SqlTable{
        public final SqlColumn<String> investigationCriminalRecordId = column("investigation_criminal_record_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> investigationId   = column("investigation_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> criminalRecordId = column("criminal_record_id",JDBCType.LONGNVARCHAR);

        public InvestigationCriminalRecordTable(){super("INVESTIGATION_CRIMINAL_RECORD");}

    }
}
