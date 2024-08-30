package com.democracy.electoral_court.domain.models;


import com.democracy.electoral_court.domain.enums.ChargeType;
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
public class Charge {

    private int 		chargeId;
    private String 		chargeName;
    private ChargeType chargeType;

}
