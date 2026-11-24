package com.democracy.electoral_court.domain.models;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Postulant {
    private String postulantId;
    private InvestigationResult investigationResult;
    private int cedula;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;

}
