package com.democracy.hhrr.domain.aux;

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
public class NeighborhoodStreet {

    private String neighStreetId;
    private String neighborhoodId;
    private String streetId;
}
