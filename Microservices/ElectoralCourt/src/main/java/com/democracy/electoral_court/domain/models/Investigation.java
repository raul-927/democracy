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
public class Investigation {
    private int 				  id;
    private String 				  investigationId;
    private Person                person;
    private List<CriminalRecord>  criminalRecords;
    private List<Qualification>   qualifications;
    private String 				  observation;
}
