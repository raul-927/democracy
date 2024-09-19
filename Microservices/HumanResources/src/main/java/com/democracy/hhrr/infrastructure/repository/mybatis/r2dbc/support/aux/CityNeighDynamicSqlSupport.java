package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CityNeighDynamicSqlSupport {

    public static final CityNeighTable cityNeighTable = new CityNeighTable();

    public static final SqlColumn<String> cityNeighId = cityNeighTable.cityNeighId;
    public static final SqlColumn<String> cityId = cityNeighTable.cityId;
    public static final SqlColumn<String> neighborhoodId = cityNeighTable.neighborhoodId;


    public static final class CityNeighTable extends SqlTable{
        public final SqlColumn<String> cityNeighId = column("city_neigh_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> cityId   = column("city_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodId = column("neighborhood_id",JDBCType.LONGNVARCHAR);

        public CityNeighTable(){super("CITY_NEIGH");}

    }



}
