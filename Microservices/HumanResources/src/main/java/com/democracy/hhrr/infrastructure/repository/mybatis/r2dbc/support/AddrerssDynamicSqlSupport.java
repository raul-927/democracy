package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import liquibase.pro.packaged.S;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;


public final class AddrerssDynamicSqlSupport {

    public static final Addr ADDRESS = new Addr();

    public static final SqlColumn<String> addressId = ADDRESS.addressId;
    public static final SqlColumn<String> geoLocation = ADDRESS.geoLocation;
    public static final SqlColumn<String> addressNumber = ADDRESS.addressNumber;
    public static final SqlColumn<String> departmentId = ADDRESS.departmentId;
    public static final SqlColumn<String> cityId = ADDRESS.cityId;
    public static final SqlColumn<String> neighborhoodId = ADDRESS.neighborhoodId;
    public static final SqlColumn<String> street1 = ADDRESS.street1;
    public static final SqlColumn<String> street2 = ADDRESS.street2;




    public static final class Addr extends SqlTable{
        public final SqlColumn<String> addressId = column("address_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> geoLocation = column("geo_location",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> addressNumber = column("address_number",JDBCType.INTEGER);
        public final SqlColumn<String> departmentId = column("department_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> cityId = column("city_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodId = column("neighborhood_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> street1 = column("street1_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> street2 = column("street2_id", JDBCType.LONGNVARCHAR);

        public Addr(){
            super("ADDRESS");
        }
    }


}
