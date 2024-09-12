package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.AddrerssDynamicSqlSupport;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class NeighborhoodStreetDynamicSqlSupport {

    public static final NeighStreetTable neighStreetTable = new NeighStreetTable();

    public static final SqlColumn<String> neighStreetId = neighStreetTable.neighStreetId;
    public static final SqlColumn<String> neighborhoodId = neighStreetTable.neighborhoodId;
    public static final SqlColumn<String> streetId = neighStreetTable.streetId;


    public static final class NeighStreetTable extends SqlTable{
        public final SqlColumn<String> neighStreetId = column("neigh_street_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodId   = column("neighborhood_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> streetId = column("street_id",JDBCType.INTEGER);

        public NeighStreetTable(){super("NEIGH_STREET");}

    }


}
