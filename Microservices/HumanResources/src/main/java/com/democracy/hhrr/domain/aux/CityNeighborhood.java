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
public class CityNeighborhood {
    private String cityNeighId;
    private String cityId;
    private String neighborhoodId;
}
