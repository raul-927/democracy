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
public class DepartmentCity {

    private String departmentCityId;
    private String departmentId;
    private String cityId;

}
