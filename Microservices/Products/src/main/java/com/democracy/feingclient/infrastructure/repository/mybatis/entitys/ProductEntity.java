package com.democracy.feingclient.infrastructure.repository.mybatis.entitys;

import com.democracy.feingclient.domain.enums.ProductType;
import lombok.Data;

@Data
public class ProductEntity {

    private String productId;
    private String productCode;
    private String productName;
    private String productLastName;
    private ProductType productType;
}
