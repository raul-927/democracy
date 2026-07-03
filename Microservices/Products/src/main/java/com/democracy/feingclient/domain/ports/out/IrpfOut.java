package com.democracy.feingclient.domain.ports.out;

import java.math.BigDecimal;

public interface IrpfOut {
    BigDecimal calcularIrpfNeto(BigDecimal sueldoBruto, BigDecimal totalDeduccionesAdmitidas);
}
