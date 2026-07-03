package com.democracy.feingclient.applications.usecases;

import com.democracy.feingclient.domain.ports.in.CalculateIrpfIn;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CalculateIrpfUseCase implements CalculateIrpfIn {

    // Constantes basadas en la BPC vigente ($6.864)
    private static final BigDecimal VALOR_BPC = new BigDecimal("6864");
    private static final BigDecimal LIMITE_TASA_DEDUCCION = VALOR_BPC.multiply(new BigDecimal("15")); // 15 BPC mensuales = 180 BPC anuales ($102.960)

    @Override
    public BigDecimal calcularIrpfNeto(BigDecimal sueldoBruto, BigDecimal totalDeduccionesAdmitidas) {
        // --- PASO 1: Calcular Impuesto Nominal por Franjas Progresivas ---
        BigDecimal impuestoNominal = BigDecimal.ZERO;

        // Límites superiores de cada franja en pesos uruguayos
        BigDecimal[] limites = {
                VALOR_BPC.multiply(new BigDecimal("7")),   // Franja 1: $48.048 (0%)
                VALOR_BPC.multiply(new BigDecimal("10")),  // Franja 2: $68.640 (10%)
                VALOR_BPC.multiply(new BigDecimal("15")),  // Franja 3: $102.960 (15%)
                VALOR_BPC.multiply(new BigDecimal("30")),  // Franja 4: $205.920 (24%)
                VALOR_BPC.multiply(new BigDecimal("50")),  // Franja 5: $343.200 (25%)
                VALOR_BPC.multiply(new BigDecimal("75")),  // Franja 6: $514.800 (27%)
                VALOR_BPC.multiply(new BigDecimal("115"))  // Franja 7: $789.360 (31%)
                // Todo lo que exceda las 115 BPC va al 36%
        };

        double[] tasas = {0.00, 0.10, 0.15, 0.24, 0.25, 0.27, 0.31, 0.36};

        BigDecimal limiteAnterior = BigDecimal.ZERO;

        for (int i = 0; i < limites.length; i++) {
            BigDecimal limiteActual = limites[i];
            BigDecimal tasa = BigDecimal.valueOf(tasas[i]);

            if (sueldoBruto.compareTo(limiteActual) > 0) {
                // El sueldo supera la franja actual: se calcula el impuesto sobre el tramo completo
                BigDecimal tramo = limiteActual.subtract(limiteAnterior);
                impuestoNominal = impuestoNominal.add(tramo.multiply(tasa));
                limiteAnterior = limiteActual;
            } else {
                // El sueldo termina dentro de esta franja
                BigDecimal tramo = sueldoBruto.subtract(limiteAnterior);
                impuestoNominal = impuestoNominal.add(tramo.multiply(tasa));
                limiteAnterior = sueldoBruto;
                break;
            }
        }

        // Si el sueldo excede la última franja listada (Franja 8)
        if (sueldoBruto.compareTo(limiteAnterior) > 0) {
            BigDecimal tramoExcedente = sueldoBruto.subtract(limiteAnterior);
            BigDecimal tasaMaxima = BigDecimal.valueOf(tasas[tasas.length - 1]);
            impuestoNominal = impuestoNominal.add(tramoExcedente.multiply(tasaMaxima));
        }

        // --- PASO 2: Calcular el Crédito por Deducciones ---
        // Determinar si aplica la tasa del 14% u 8% según el nivel de ingresos
        BigDecimal tasaDeduccion = (sueldoBruto.compareTo(LIMITE_TASA_DEDUCCION) <= 0)
                ? new BigDecimal("0.14")
                : new BigDecimal("0.08");

        BigDecimal descuentoDeducciones = totalDeduccionesAdmitidas.multiply(tasaDeduccion);

        // --- PASO 3: Restar Deducciones al Impuesto Nominal ---
        BigDecimal impuestoNeto = impuestoNominal.subtract(descuentoDeducciones);

        // El impuesto no puede ser negativo (si da negativo, el resultado es $0)
        if (impuestoNeto.compareTo(BigDecimal.ZERO) < 0) {
            impuestoNeto = BigDecimal.ZERO;
        }

        return impuestoNeto.setScale(2, RoundingMode.HALF_UP);
    }
}
