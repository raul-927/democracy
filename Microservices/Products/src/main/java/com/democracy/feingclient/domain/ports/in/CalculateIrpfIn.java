package com.democracy.feingclient.domain.ports.in;

import java.math.BigDecimal;

public interface CalculateIrpfIn {
    BigDecimal calcularIrpfNeto(BigDecimal sueldoBruto, BigDecimal totalDeduccionesAdmitidas);
}
