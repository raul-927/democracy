package com.democracy.accounting.domain.records;

import java.math.BigDecimal;

public record PayrollResponse(
        BigDecimal salarioBruto,
        BigDecimal salud,
        BigDecimal pension,
        BigDecimal fondoSolidaridad,
        BigDecimal retencionFuente,
        BigDecimal salarioNeto
) {}
