package com.democracy.electoral_court.domain.models;



import com.democracy.electoral_court.domain.enums.StreetType;
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

    private String 		streetId;
    private String 		streetName;
    private StreetType streetType;
}
