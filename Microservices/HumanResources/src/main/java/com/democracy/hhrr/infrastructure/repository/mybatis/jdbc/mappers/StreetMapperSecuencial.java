package com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.mappers;


import com.democracy.hhrr.domain.models.Street;
import com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.sql.StreetSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

//@Mapper
public interface StreetMapperSecuencial {

    @SelectProvider(type = StreetSqlProvider.class, method ="selectStreet")
    @ResultMap("com.democracy.hhrr.infrastructure.repository.mybatis.jdbc.mappers.StreetMapper.StreetResult")
    List<Street> selectStreet(Street street);


}
