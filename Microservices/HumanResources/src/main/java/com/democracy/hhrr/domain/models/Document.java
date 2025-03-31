package com.democracy.hhrr.domain.models;


import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Blob;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Document {

    private int 		id;
    private String 		documentId;
    private String 		documentName;
    private boolean 	documentVerified;
    private boolean		documentApproved;
    private String 		documentObservation;
    private byte[]        documentAttachment;
}
