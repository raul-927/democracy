package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;


import com.democracy.hhrr.domain.enums.StreetType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class StreetDynamicSqlSupport {
    public static final Str STREET = new Str();
    public static final SqlColumn<String> streetId = STREET.streetId;
    public static final SqlColumn<String> streetName = STREET.streetName;
    public static final SqlColumn<StreetType> streetType = STREET.streetType;

    public static final Str2 STREET2 = new Str2();
    public static final SqlColumn<String> streetId2 = STREET2.street2Id;
    public static final SqlColumn<String> streetName2 = STREET2.streetName2;
    public static final SqlColumn<StreetType> streetType2 = STREET2.streetType2;

    public static final class Str extends SqlTable {
        public final SqlColumn<String> streetId = column("street_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> streetName = column("street_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<StreetType> streetType = column("street_type", JDBCType.LONGNVARCHAR);

        public Str(){
            super("STREET");
        }

    }

    public static final class Str2 extends SqlTable {
        public final SqlColumn<String> street2Id = column("street_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> streetName2 = column("street_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<StreetType> streetType2 = column("street_type", JDBCType.LONGNVARCHAR);

        public Str2(){
            super("STREET");
        }

    }
}
