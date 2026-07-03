package com.democracy.accounting.domain.models;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SalaryTaxes {
    private BigDecimal  grossSalary;
    private BigDecimal  mandatoryContributions;
    private int         numberOfChildren;
}
