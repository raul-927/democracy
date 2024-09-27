package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class CityNeighDynamicSqlSupport {

    public static final CityNeighTable CITY_NEIGH = new CityNeighTable();

    public static final SqlColumn<String> cityNeighId = CITY_NEIGH.cityNeighId;
    public static final SqlColumn<String> cityId = CITY_NEIGH.cityId;
    public static final SqlColumn<String> neighborhoodId = CITY_NEIGH.neighborhoodId;


    public static final class CityNeighTable extends SqlTable{
        public final SqlColumn<String> cityNeighId = column("city_neigh_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> cityId   = column("city_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodId = column("neighborhood_id",JDBCType.LONGNVARCHAR);

        public CityNeighTable(){super("CITY_NEIGH");}

    }



}
