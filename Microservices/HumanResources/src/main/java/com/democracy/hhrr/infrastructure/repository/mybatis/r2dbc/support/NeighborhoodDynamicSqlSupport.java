package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import liquibase.pro.packaged.S;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class NeighborhoodDynamicSqlSupport {

    public static final Neigh neigh = new Neigh();

    public static final SqlColumn<String> neighborhoodId = neigh.neighborhoodId;
    public static final SqlColumn<String> neighborhoodName = neigh.neighborhoodName;
    public static final SqlColumn<String> departmentId = neigh.departmentId;
    public static final SqlColumn<String> departmentName = neigh.departmentName;
    public static final class Neigh extends SqlTable {
        public final SqlColumn<String> neighborhoodId = column("neighborhood_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> neighborhoodName = column("neighborhood_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> departmentId = column("department_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> departmentName = column("department.department_name", JDBCType.LONGNVARCHAR);
        public Neigh(){
            super("NEIGHBORHOOD");
        }
    }
}
