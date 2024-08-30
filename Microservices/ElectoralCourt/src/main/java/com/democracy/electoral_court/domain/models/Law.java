package com.democracy.electoral_court.domain.models;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Law {
    private int 	id;
    private String 	lawId;
    private int		lawNumber;
    private String  lawText;
    private Date promulgation;
    private String 	lawDescription;

}
