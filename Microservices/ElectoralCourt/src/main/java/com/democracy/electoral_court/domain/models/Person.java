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
public class Person {

    private int 	   			id;
    private String 	   			personId;
    private int 	   			cedula;
    private int					civicCredential;
    private String 	   			firstName;
    private String 	   			secondName;
    private String 	   			firstLastName;
    private String 	   			secondLastName;
}
