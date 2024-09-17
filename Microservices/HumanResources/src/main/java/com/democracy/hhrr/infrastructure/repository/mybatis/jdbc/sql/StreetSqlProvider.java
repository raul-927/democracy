package com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.sql;

import com.democracy.hhrr.domain.models.Street;
import org.apache.ibatis.jdbc.SQL;

public class StreetSqlProvider {

    public String selectStreet(Street street){
        return new SQL(){{
            SELECT();
            FROM();
            WHERE();
        }}.toString();
    }

}
