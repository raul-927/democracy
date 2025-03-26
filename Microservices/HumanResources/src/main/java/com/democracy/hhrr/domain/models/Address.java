package com.democracy.hhrr.domain.models;


import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Address {
    private int 		 id;
    private String 		 addressId;
    private String 		 geoLocation;
    private String 		 addressNumber;
    private Department   department;
    private City         city;
    private Neighborhood neighborhood;
    private Street       street1;
    private Street       street2;

}
