package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import liquibase.sql.Sql;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.management.monitor.StringMonitor;
import java.sql.JDBCType;
import java.util.List;


public final class AddrerssDynamicSqlSupport {

    public static final Addr addr = new Addr();

    public static final SqlColumn<String> addressId = addr.addressId;
    public static final SqlColumn<String> geoLocation = addr.geoLocation;
    public static final SqlColumn<String> addressNumber = addr.addressNumber;



    public static final class Addr extends SqlTable{
        public final SqlColumn<String> addressId = column("address_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> geoLocation = column("geo_location",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> addressNumber = column("address_number",JDBCType.INTEGER);
        public Addr(){
            super("ADDRESS");
        }
    }


}
