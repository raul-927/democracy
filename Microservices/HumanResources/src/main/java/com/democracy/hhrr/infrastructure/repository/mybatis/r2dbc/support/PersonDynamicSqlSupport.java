package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public final class PersonDynamicSqlSupport {

    public static final Person PERSON = new Person();
    public static final SqlColumn<String> personId = PERSON.personId;
    public static final SqlColumn<Integer> cedula = PERSON.cedula;
    public static final SqlColumn<String> civicCredential =PERSON.civicCredential;
    public static final SqlColumn<String> firstName = PERSON.firstName;
    public static final SqlColumn<String> secondName =PERSON.secondName;
    public static final SqlColumn<String> firstLastName = PERSON.firstLastName;
    public static final SqlColumn<String> secondLastName =PERSON.secondLastName;
    public static final SqlColumn<String> addressId =PERSON.addressId;
    public static final SqlColumn<String> professionId =PERSON.professionId;


    public static final class Person extends SqlTable {
        public final SqlColumn<String> personId = column("person_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<Integer> cedula = column("cedula", JDBCType.INTEGER);
        public final SqlColumn<String> civicCredential = column("civic_credential", JDBCType.INTEGER);
        public final SqlColumn<String> firstName = column("first_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> secondName = column("second_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> firstLastName = column("first_last_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> secondLastName = column("second_last_name", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> addressId = column("address_id", JDBCType.LONGNVARCHAR);
        public final SqlColumn<String> professionId = column("profession_id", JDBCType.LONGNVARCHAR);

        public Person(){
            super("PERSON");
        }

    }
}
