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
public class Person {

    private int 	   			id;
    private String 	   			personId;
    private int 	   			cedula;
    private String				civicCredential;
    private String 	   			firstName;
    private String 	   			secondName;
    private String 	   			firstLastName;
    private String 	   			secondLastName;
    private Address    			address;
    private Profession 			profession;
}
