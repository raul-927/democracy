package com.democracy.hhrr.domain.models;


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
public class Qualification {
    private int 			id;
    private String 			qualificationId;
    private Institute 		institute;
    private List<Document> documents;
    private boolean 		verified;
    private boolean			approved;
}
