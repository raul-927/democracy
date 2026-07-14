package com.democracy.accounting.application.usecases.payrollcalculation;

import com.democracy.accounting.domain.ports.in.payrollcalculation.PayrollCalculationIn;
import com.democracy.accounting.domain.ports.out.PayrollCalculationOut;
import com.democracy.accounting.domain.records.PayrollRequest;
import com.democracy.accounting.domain.records.PayrollResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PayrollCalculationUseCase implements PayrollCalculationIn {
    // Constantes fiscales Colombia 2026
    private static final BigDecimal VALOR_UVT_2026 = new BigDecimal("52374");
    private static final BigDecimal CUATRO_SMMLV = new BigDecimal("5200000"); // Umbral aproximado Fondo Solidaridad
    private static final String SALUD = "0.04";
    private static final String PENSION = "0.04";

    private final PayrollCalculationOut payrollCalculationOut;

    public PayrollCalculationUseCase(PayrollCalculationOut payrollCalculationOut) {
        this.payrollCalculationOut = payrollCalculationOut;
    }

    @Override
    public Mono<PayrollResponse> calculatePayroll(PayrollRequest request) {
        return this.payrollCalculationOut.calculatePayroll(Mono.just(request.salarioBruto())
                .map(salarioBruto -> {
                    // 1. Cálculos de Seguridad Social usando var
                    var salud = salarioBruto.multiply(new BigDecimal(SALUD)).setScale(0, RoundingMode.HALF_UP);
                    var pension = salarioBruto.multiply(new BigDecimal(PENSION)).setScale(0, RoundingMode.HALF_UP);

                    var fondoSolidaridad = (salarioBruto.compareTo(CUATRO_SMMLV) >= 0)
                            ? salarioBruto.multiply(new BigDecimal("0.01")).setScale(0, RoundingMode.HALF_UP)
                            : BigDecimal.ZERO;

                    var totalSeguridadSocial = salud.add(pension).add(fondoSolidaridad);

                    // 2. Depuración para Retención en la Fuente
                    var ingresoNetoInicial = salarioBruto.subtract(totalSeguridadSocial);
                    var rentaExentaLaboral = ingresoNetoInicial.multiply(new BigDecimal("0.25")).setScale(0, RoundingMode.HALF_UP);
                    var baseGravablePesos = ingresoNetoInicial.subtract(rentaExentaLaboral);

                    // 3. Conversión a UVT
                    var baseUvt = baseGravablePesos.divide(VALOR_UVT_2026, 4, RoundingMode.HALF_UP);

                    // 4. Aplicación de tabla de retención usando Pattern Matching en Switch (Java 22)
                    var impuestoUvt = calculateTaxUvt(baseUvt);
                    var retencionFuentePesos = impuestoUvt.multiply(VALOR_UVT_2026).setScale(0, RoundingMode.HALF_UP);

                    // 5. Cálculo del Neto Final
                    var salarioNeto = salarioBruto.subtract(totalSeguridadSocial).subtract(retencionFuentePesos);

                    return new PayrollResponse(
                            salarioBruto,
                            salud,
                            pension,
                            fondoSolidaridad,
                            retencionFuentePesos,
                            salarioNeto
                    );
                }));
    }

    /**
     * Evalúa los límites del Artículo 383 usando Pattern Matching y cláusulas 'when' en Java 22.
     */
    private BigDecimal calculateTaxUvt(BigDecimal baseUvt) {
        return switch (baseUvt) {
            // Rango 1: 0 a 95 UVT (Tarifa 0%)
            case BigDecimal b when b.compareTo(new BigDecimal("95")) <= 0 ->
                    BigDecimal.ZERO;

            // Rango 2: Mayor a 95 y hasta 150 UVT (Tarifa 19% sobre el excedente)
            case BigDecimal b when b.compareTo(new BigDecimal("150")) <= 0 ->
                    b.subtract(new BigDecimal("95")).multiply(new BigDecimal("0.19"));

            // Rango 3: Mayor a 150 y hasta 360 UVT (Tarifa 28% sobre el excedente + 10 UVT)
            case BigDecimal b when b.compareTo(new BigDecimal("360")) <= 0 ->
                    b.subtract(new BigDecimal("150")).multiply(new BigDecimal("0.28")).add(new BigDecimal("10"));

            // Cualquier otro caso (Rangos superiores)
            default ->
                    throw new IllegalArgumentException("Rango tributario superior no configurado");
        };
    }
}
