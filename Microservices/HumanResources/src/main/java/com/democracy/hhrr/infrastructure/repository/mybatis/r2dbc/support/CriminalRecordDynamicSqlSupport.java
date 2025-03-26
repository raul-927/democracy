package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CriminalRecordDynamicSqlSupport {

    public static final CriminalRecordDynamicSqlSupport.CriminalRecord CRIMINAL_RECORD = new CriminalRecordDynamicSqlSupport.CriminalRecord();
    public static final SqlColumn<String> criminalRecordId = CRIMINAL_RECORD.criminalRecordId;
    public static final SqlColumn<String> criminalRecordName = CRIMINAL_RECORD.criminalRecordName;
    public static final SqlColumn<String> criminalRecordDescription = CRIMINAL_RECORD.criminalRecordDescription;
    public static final SqlColumn<String> penalId = CRIMINAL_RECORD.penalId;

    public static final class CriminalRecord extends SqlTable {
        public final SqlColumn<String> criminalRecordId = column("criminal_record_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> criminalRecordName = column("criminal_record_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> criminalRecordDescription = column("criminal_record_description", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> penalId = column("penal_id", JDBCType.LONGNVARCHAR);


        public CriminalRecord(){
            super("CRIMINAL_RECORD");
        }

    }
}
