package com.democracy.electoral_court.infrastructure.repository.mybatis.r2dbc.support;


import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class PostulantDynamicSqlSupport {

    public static final Postulant POSTULANT = new Postulant();

    public static final SqlColumn<Integer> cedula        = POSTULANT.cedula;
    public static final SqlColumn<String> firstName      = POSTULANT.firstName;
    public static final SqlColumn<String> secondName     = POSTULANT.secondName;
    public static final SqlColumn<String> firstLastName  = POSTULANT.firstLastName;
    public static final SqlColumn<String> secondLastName = POSTULANT.secondLastName;


    public static final class Postulant extends SqlTable {
        public final SqlColumn<Integer> cedula        = column("cedula", JDBCType.INTEGER);
        public final SqlColumn<String> firstName      = column("first_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> secondName     = column("second_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> firstLastName  = column("first_last_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> secondLastName = column("second_last_name", JDBCType.LONGNVARCHAR);
        public Postulant(){
            super("POSTULANT");
        }
    }
}
