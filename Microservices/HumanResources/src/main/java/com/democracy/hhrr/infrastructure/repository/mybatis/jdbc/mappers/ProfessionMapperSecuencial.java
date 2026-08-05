package com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.mappers;


import com.democracy.hhrr.domain.models.Profession;
import com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.sql.ProfessionSqlProvider;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ProfessionMapperSecuencial {

    @SelectProvider(type = ProfessionSqlProvider.class, method ="selectProfession")
    @ResultMap("com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.mappers.ProfessionMapperSecuencial.ProfessionResult")
    List<Profession> selectProfession(Profession profession);


}
