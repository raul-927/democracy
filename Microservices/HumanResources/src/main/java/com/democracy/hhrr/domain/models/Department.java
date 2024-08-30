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
public class Department {

    private int 	id;
    private int 	departmentId;
    private String 	departmentName;
}
