package com.democracy.feingtarget.infrastructure.repository.mybatis.entitys;

import com.democracy.feingtarget.domain.enums.ProductType;
import lombok.Data;

@Data
public class ProductEntity {

    private String productId;
    private String productCode;
    private String productName;
    private String productLastName;
    private ProductType productType;
}
