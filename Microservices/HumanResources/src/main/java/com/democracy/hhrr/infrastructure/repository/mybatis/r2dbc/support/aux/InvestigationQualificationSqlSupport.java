package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class InvestigationQualificationSqlSupport {

    public static final InvestigationQualificationTable INVESTIGATION_QUALIFICATION_TABLE = new InvestigationQualificationTable();

    public static final SqlColumn<String> investigationQualificationId = INVESTIGATION_QUALIFICATION_TABLE.investigationQualificationId;
    public static final SqlColumn<String> investigationId = INVESTIGATION_QUALIFICATION_TABLE.investigationId;
    public static final SqlColumn<String> qualificationId = INVESTIGATION_QUALIFICATION_TABLE.qualificationId;


    public static final class InvestigationQualificationTable extends SqlTable{
        public final SqlColumn<String> investigationQualificationId = column("investigation_qualification_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> investigationId   = column("investigation_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> qualificationId = column("qualification_id",JDBCType.LONGNVARCHAR);

        public InvestigationQualificationTable(){super("INVESTIGATION_QUALIFICATION");}

    }
}
