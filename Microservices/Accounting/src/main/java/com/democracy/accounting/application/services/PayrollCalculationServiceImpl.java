package com.democracy.accounting.application.services;

import com.democracy.accounting.domain.ports.in.payrollcalculation.PayrollCalculationIn;
import com.democracy.accounting.domain.records.PayrollRequest;
import com.democracy.accounting.domain.records.PayrollResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PayrollCalculationServiceImpl implements PayrollCalculationService{
    private final PayrollCalculationIn payrollCalculationIn;

    public PayrollCalculationServiceImpl(PayrollCalculationIn payrollCalculationIn) {
        this.payrollCalculationIn = payrollCalculationIn;
    }

    @Override
    public Mono<PayrollResponse> calculatePayroll(PayrollRequest request) {
        return this.payrollCalculationIn.calculatePayroll(request);
    }

}
