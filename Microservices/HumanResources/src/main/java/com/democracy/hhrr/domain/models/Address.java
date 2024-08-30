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
    private int 			addressId;
    private Neighborhood 	neighborhood;
    private String 			geoLocation;
    private int 			addressNumber;
    private List<Street>    streets;
}
