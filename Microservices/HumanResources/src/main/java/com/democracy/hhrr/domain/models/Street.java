package com.democracy.hhrr.domain.models;


import com.democracy.hhrr.domain.enums.StreetType;
import lombok.*;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Street {

    private int 		streetId;
    private String 		streetName;
    private StreetType  streetType;
}
