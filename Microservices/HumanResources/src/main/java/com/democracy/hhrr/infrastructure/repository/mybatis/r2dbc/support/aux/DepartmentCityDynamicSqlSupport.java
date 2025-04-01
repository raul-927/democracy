package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class DepartmentCityDynamicSqlSupport {

    public static final DepartmentCityTable DEPARTMENT_CITY = new DepartmentCityTable();

    public static final SqlColumn<String> departmentCityId = DEPARTMENT_CITY.departmentCityId;
    public static final SqlColumn<String> departmentId = DEPARTMENT_CITY.departmentId;
    public static final SqlColumn<String> cityId = DEPARTMENT_CITY.cityId;


    public static final class DepartmentCityTable extends SqlTable{
        public final SqlColumn<String> departmentCityId = column("department_city_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> departmentId = column("department_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> cityId   = column("city_id",JDBCType.LONGNVARCHAR);

        public DepartmentCityTable(){super("DEPARTMENT_CITY");}

    }



}
