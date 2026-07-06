package com.democracy.accounting.infrastructure.web.rest;


import com.democracy.accounting.application.services.PayrollCalculationService;
import com.democracy.accounting.domain.records.PayrollRequest;
import com.democracy.accounting.domain.records.PayrollResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/accounting/nominas")
public class PayrollRestController {

    private final PayrollCalculationService payrollCalculationService;

    public PayrollRestController(PayrollCalculationService payrollCalculationService) {
        this.payrollCalculationService = payrollCalculationService;
    }


    @PostMapping("/calcular")
    public Mono<PayrollResponse> payrollCalculate(@RequestBody PayrollRequest request) {
        return payrollCalculationService.calculatePayroll(request);
    }
}
