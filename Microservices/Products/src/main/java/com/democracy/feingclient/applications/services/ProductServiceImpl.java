package com.democracy.feingclient.applications.services;

import com.democracy.feingclient.domain.models.Product;
import com.democracy.feingclient.domain.ports.in.CalculateIrpfIn;
import com.democracy.feingclient.domain.ports.in.CreateProductIn;
import com.democracy.feingclient.domain.ports.in.SelectCountIn;
import com.democracy.feingclient.domain.ports.in.SelectProductIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.math.RoundingMode;




import java.util.List;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CreateProductIn createProductIn;

    @Autowired
    private SelectProductIn selectProductIn;

    @Autowired
    private SelectCountIn selectCountIn;

    @Autowired
    private CalculateIrpfIn calculateIrpfIn;
    @Override
    public Mono<Integer> createProduct(Product product) {
        return createProductIn.createProduct(product);
    }

    @Override
    public Mono<Integer> createMultipleProduct(List<Product> products) {
        return createProductIn.createMultipleProduct(products);
    }

    @Override
    public Flux<Product> selectProduct(Product product) {
        return selectProductIn.selectProduct(product);
    }

    @Override
    public Mono<Long> selectCount() {
        return this.selectCountIn.selectCount();
    }

    /**
     * Calcula el IRPF neto mensual acumulando franjas y restando deducciones aplicables.
     *
     * @param sueldoBruto Monto nominal mensual del trabajador.
     * @param totalDeduccionesAdmitidas Suma nominal de aportes (BPS + Fonasa + FRL) + fictos por hijos.
     * @return Impuesto neto final a retener.
     */

    @Override
    public BigDecimal calcularIrpfNeto(BigDecimal sueldoBruto, BigDecimal totalDeduccionesAdmitidas) {

        return this.calculateIrpfIn.calcularIrpfNeto(sueldoBruto, totalDeduccionesAdmitidas);
    }
}
