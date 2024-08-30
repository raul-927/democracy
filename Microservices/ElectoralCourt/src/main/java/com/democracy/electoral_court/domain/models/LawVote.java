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
public class LawVote {
    private int 	 id;
    private int 	 voteId;
    private Law 	 law;
    private Envelope envelope;
    private boolean  isApproved;

}
