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
public class InvestigationResult {
    private String investigationResultId;
    private String investigationObservation;
    private Integer score;
    private Boolean isApprove;
}
