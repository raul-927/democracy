package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class InstituteDynamicSqlSupport {
    public static final InstituteTable INSTITUTE_TABLE = new InstituteTable();
    public static final SqlColumn<String> instituteId = INSTITUTE_TABLE.instituteId;
    public static final SqlColumn<String> instituteName = INSTITUTE_TABLE.instituteName;
    public static final SqlColumn<String> addressId = INSTITUTE_TABLE.addressId;


    public static final class InstituteTable extends SqlTable{

        public final SqlColumn<String> instituteId   = column("institute_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> instituteName = column("institute_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> addressId    = column("address_id", JDBCType.LONGNVARCHAR);
        public InstituteTable(){super("INSTITUTE");}
    }



}
