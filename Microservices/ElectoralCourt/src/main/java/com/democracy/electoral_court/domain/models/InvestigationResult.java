package com.democracy.electoral_court.domain.models;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class InvestigationResult {
    private String  investigationResultId;
    private String  investigationId;
    private int     cedula;
    private String  personId;
    private String  observation;
    private Integer score;
    private Boolean isApprove;
}
