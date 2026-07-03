package com.democracy.accounting.domain.ports.in.payrollcalculation;

import com.democracy.accounting.domain.records.PayrollRequest;
import com.democracy.accounting.domain.records.PayrollResponse;
import reactor.core.publisher.Mono;

public interface PayrollCalculationIn {
    Mono<PayrollResponse> calcularNominaReactiva(PayrollRequest request);
}
