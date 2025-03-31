package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class ProfessionDynamicSqlSupport {

    public static final Profession PROFESSION = new Profession();
    public static final SqlColumn<String> professionId = PROFESSION.professionId;
    public static final SqlColumn<String> professionName = PROFESSION.professionName;

    public static final class Profession extends SqlTable {
        public final SqlColumn<String> professionId = column("profession_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> professionName = column("profession_name", JDBCType.LONGNVARCHAR);


        public Profession(){
            super("PROFESSION");
        }

    }
}
