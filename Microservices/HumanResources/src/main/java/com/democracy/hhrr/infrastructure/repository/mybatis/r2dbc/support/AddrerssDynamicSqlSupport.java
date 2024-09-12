package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;


public final class AddrerssDynamicSqlSupport {

    public static final Addr addr = new Addr();

    public static final SqlColumn<String> addressId = addr.addressId;
    public static final SqlColumn<String> geoLocation = addr.geoLocation;
    public static final SqlColumn<String> addressNumber = addr.addressNumber;
    public static final SqlColumn<String> departmentId = addr.departmentId;




    public static final class Addr extends SqlTable{
        public final SqlColumn<String> addressId = column("address_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> geoLocation = column("geo_location",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> addressNumber = column("address_number",JDBCType.INTEGER);
        public final SqlColumn<String> departmentId = column("department_id", JDBCType.LONGNVARCHAR);

        public Addr(){
            super("ADDRESS");
        }
    }


}
