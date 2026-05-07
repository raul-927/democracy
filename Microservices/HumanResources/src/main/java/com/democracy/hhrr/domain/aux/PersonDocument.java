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
public class PersonDocument {
    private String personDocumentId;
    private String personId;
    private String documentId;
}
