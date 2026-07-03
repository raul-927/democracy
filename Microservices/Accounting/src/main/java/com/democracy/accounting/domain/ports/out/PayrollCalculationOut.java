package com.democracy.accounting.domain.ports.out;

import com.democracy.accounting.domain.records.PayrollRequest;
import com.democracy.accounting.domain.records.PayrollResponse;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface PayrollCalculationOut {
    Mono<PayrollResponse> calcularNominaReactiva(Mono<PayrollResponse> response);
}
