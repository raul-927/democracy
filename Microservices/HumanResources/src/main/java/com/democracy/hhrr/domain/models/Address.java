package com.democracy.hhrr.domain.models;


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
    private int 			id;
    private String 			addressId;
    private Neighborhood 	neighborhood;
    private String 			geoLocation;
    private String 		addressNumber;
    private List<Street>    streets;
}
