package com.democracy.electoral_court.domain.models;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PostulantVote {
    private String postulantVoteId;
    private Postulant postulant;
    private InvestigationResult investigationResult;
    private Envelope envelope;

}
