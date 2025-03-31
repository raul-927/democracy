package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;


public final class QualificationDynamicSqlSupport {

    public static final QualificationTable QUALIFICATION_TABLE = new QualificationTable();

    public static final SqlColumn<String> qualificationId = QUALIFICATION_TABLE.qualificationId;
    public static final SqlColumn<String> qualificationInstituteId = QUALIFICATION_TABLE.qualificationInstituteId;
    public static final SqlColumn<Boolean> verified = QUALIFICATION_TABLE.verified;
    public static final SqlColumn<Boolean> approved = QUALIFICATION_TABLE.approved;





    public static final class QualificationTable extends SqlTable{
        public final SqlColumn<String> qualificationId = column("qualification_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> qualificationInstituteId = column("institute_id",JDBCType.LONGNVARCHAR);
        public final SqlColumn<Boolean> verified = column("verified",JDBCType.BOOLEAN);
        public final SqlColumn<Boolean> approved = column("approved", JDBCType.BOOLEAN);


        public QualificationTable(){
                super("QUALIFICATION");
        }
    }


}
