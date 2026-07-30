package com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.sql;

import com.democracy.hhrr.domain.models.Street;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class StreetSqlProvider {

    public String selectStreet(Street street){
        return new SQL(){{
            SELECT("street_id, street_name,street_type");
            FROM("STREET");
            if(street.getStreetName()!=null && !street.getStreetName().isEmpty()){
                WHERE("street_name = "+street.getStreetName());
            }
            if(street.getStreetType().getDescription()!=null && !street.getStreetType().getDescription().isEmpty()){
                WHERE("street_type = "+street.getStreetType().getDescription());
            }

        }}.toString();
    }

    public String updateStreet(Street street){
        return new SQL(){{
            UPDATE("street");
            if(street.getStreetType()!=null){
                SET("street_type = "+street.getStreetType());
            }
            if(street.getStreetName()!=null && !street.getStreetName().isEmpty()){
                SET("street_name = "+street.getStreetName());
            }
            WHERE("street_id = "+street.getStreetId());

        }}.toString();
    }

    private String deleteStreet(String streetId){
        return new SQL(){{
            DELETE_FROM(" street");
            WHERE("street_id = "+streetId);
        }}.toString();
    }

    private String insertStreet(List<Street> streetList){
        return new SQL(){{
            INSERT_INTO("street");
            INTO_COLUMNS("street_id", "street_name", "street_type");
            for(Street street: streetList){
                if((street.getStreetId()!=null && !street.getStreetId().isEmpty()) &&
                (street.getStreetName()!=null && !street.getStreetName().isEmpty()) && street.getStreetType()!=null){
                    INTO_VALUES(street.getStreetId(), street.getStreetName(), street.getStreetType().getDescription());
                    ADD_ROW();
                }
            }
        }}.toString();
    }
}
