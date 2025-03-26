package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class InvestigationDynamicSqlSupport {

    public static final InvestigationDynamicSqlSupport.Investigation INVESTIGATION = new InvestigationDynamicSqlSupport.Investigation();

    public static final SqlColumn<String> investigationId = INVESTIGATION.investigationId;
    public static final SqlColumn<String> personId        = INVESTIGATION.personId;
    public static final SqlColumn<String> observation     = INVESTIGATION.observation;

    public static final class Investigation extends SqlTable {
        public final SqlColumn<String> investigationId = column("investigation_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> personId        = column("person_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> observation     = column("observation", JDBCType.LONGNVARCHAR);

        public Investigation(){
            super("INVESTIGATION");
        }
    }
}
