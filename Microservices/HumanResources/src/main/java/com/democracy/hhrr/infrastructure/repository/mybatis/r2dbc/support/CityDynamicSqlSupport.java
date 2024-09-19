package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;


import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CityDynamicSqlSupport {
    public static final CityTable cityTable = new CityTable();

    public static final SqlColumn<String> cityId = cityTable.cityId;
    public static final SqlColumn<String> cityName = cityTable.cityName;

    public static final class CityTable extends SqlTable {
        public final SqlColumn<String> cityId = column("city_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> cityName = column("city_name", JDBCType.LONGNVARCHAR);

        public CityTable(){
            super("CITY");
        }

    }
}
