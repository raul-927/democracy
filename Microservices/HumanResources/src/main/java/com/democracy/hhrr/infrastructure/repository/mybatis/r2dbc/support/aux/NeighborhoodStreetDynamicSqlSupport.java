package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class NeighborhoodStreetDynamicSqlSupport {

    public static final NeighStreetTable NEIGH_STREET = new NeighStreetTable();

    public static final SqlColumn<String> neighStreetId = NEIGH_STREET.neighStreetId;
    public static final SqlColumn<String> neighborhoodId = NEIGH_STREET.neighborhoodId;
    public static final SqlColumn<String> streetId = NEIGH_STREET.streetId;


    public static final class NeighStreetTable extends SqlTable{
        public final SqlColumn<String> neighStreetId = column("neigh_street_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodId   = column("neighborhood_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> streetId = column("street_id",JDBCType.LONGNVARCHAR);

        public NeighStreetTable(){super("NEIGH_STREET");}

    }


}
