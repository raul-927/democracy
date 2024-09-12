package com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.dynamic.aux;

import org.mybatis.dynamic.sql.BasicColumn;

import static com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.aux.NeighborhoodStreetDynamicSqlSupport.*;

public interface NeighBorhoodStreetDynamicMapper {

    BasicColumn[] neighStreetCol = BasicColumn.columnList(neighStreetId, neighborhoodId, streetId);



}
