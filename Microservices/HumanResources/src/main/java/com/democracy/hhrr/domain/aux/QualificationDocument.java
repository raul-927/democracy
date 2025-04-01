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
public class QualificationDocument {
    private String qualificationDocumentId;
    private String qualificationId;
    private String documentId;
}
