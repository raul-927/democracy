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
public class Postulant {
    private InvestigationResult investigationResult;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;

}
