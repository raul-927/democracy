package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import com.democracy.hhrr.domain.enums.StreetType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import java.sql.JDBCType;


public final class DepartmentDynamicSqlSupport {

    public static final Dep dep = new Dep();

    public static final SqlColumn<String> departmentId = dep.departmentId;
    public static final SqlColumn<String> departmentName = dep.departmentName;

    public static final class Dep extends SqlTable{
        public final SqlColumn<String> departmentId = column("department_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> departmentName = column("department_name", JDBCType.LONGNVARCHAR);

        public Dep(){
            super("DEPARTMENT");
        }
    }


}
