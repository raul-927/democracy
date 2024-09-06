package com.democracy.hhrr.domain.models;


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
public class Neighborhood {

    private int 		id;
    private String 		neighborhoodId;
    private String 		neighborhoodName;
    private Department 	department;

}
