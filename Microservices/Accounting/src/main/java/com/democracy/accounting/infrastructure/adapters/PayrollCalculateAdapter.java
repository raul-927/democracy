package com.democracy.accounting.infrastructure.adapters;

import com.democracy.accounting.domain.ports.out.PayrollCalculationOut;
import com.democracy.accounting.domain.records.PayrollResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PayrollCalculateAdapter implements PayrollCalculationOut {
    @Override
    public Mono<PayrollResponse> calcularNominaReactiva(Mono<PayrollResponse> response) {
        return response;
    }
}
