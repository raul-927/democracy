package com.democracy.electoral_court.domain.models;


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
public class Qualification {
    private int 			id;
    private String 			qualificationId;
    private Person          person;
    private boolean 		verified;
    private boolean			approved;
}
