package com.democracy.hhrr.domain.aux;


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
public class InvestigationQualification {
    private String investigationQualificationId;
    private String investigationId;
    private String qualificationId;
}
