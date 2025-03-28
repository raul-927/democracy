package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class PenalDynamicSqlSupport {

    public static final Penal PENAL = new Penal();
    public static final SqlColumn<String> penalId = PENAL.penalId;
    public static final SqlColumn<String> penalName = PENAL.penalName;

    public static final class Penal extends SqlTable {
        public final SqlColumn<String> penalId = column("penal_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> penalName = column("penal_name", JDBCType.LONGNVARCHAR);


        public Penal(){
            super("PENAL");
        }

    }
}
