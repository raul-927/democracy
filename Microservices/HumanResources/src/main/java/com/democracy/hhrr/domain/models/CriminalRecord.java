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
public class CriminalRecord {
    private int 	id;
    private String 	criminalRecordId;
    private String 	criminalRecordName;
    private String 	criminalRecordDescription;
    private Penal 	penal;
}
