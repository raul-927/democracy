package com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.sql;

import com.democracy.hhrr.domain.models.Profession;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

public class ProfessionSqlProvider {

    public String selectProfession(Profession profession){
        return new SQL(){{
            SELECT("profession_id, profession_name");
            FROM("PROFESSION");
            if(profession.getProfessionName()!=null && !profession.getProfessionName().isEmpty()){
                WHERE("profession_name = "+profession.getProfessionName());
            }
        }}.toString();
    }

    public String updateProfession(Profession profession){
        return new SQL(){{
            UPDATE("PROFESSION");
            if(profession.getProfessionName()!=null){
                SET("profession_name = "+profession.getProfessionName());
            }
            WHERE("profession_id = "+profession.getProfessionId());

        }}.toString();
    }

    private String deleteProfession(String professionId){
        return new SQL(){{
            DELETE_FROM("PROFESSION");
            WHERE("profession_id = "+professionId);
        }}.toString();
    }

    private String insertProfession(List<Profession> professionList){
        return new SQL(){{
            INSERT_INTO("PROFESSION");
            INTO_COLUMNS("profession_id", "profession_name");
            for(Profession profession: professionList){
                if((profession.getProfessionId()!=null && !profession.getProfessionId().isEmpty()) &&
                (profession.getProfessionName()!=null && !profession.getProfessionName().isEmpty())){
                    INTO_VALUES(profession.getProfessionId(), profession.getProfessionName());
                    ADD_ROW();
                }
            }
        }}.toString();
    }
}
