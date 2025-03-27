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
public class InvestigationCriminalRecord {
    private String investigationCriminalRecordId;
    private String investigationId;
    private String criminalRecordId;
}
