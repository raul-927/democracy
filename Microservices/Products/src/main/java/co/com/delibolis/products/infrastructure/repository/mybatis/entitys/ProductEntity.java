package co.com.delibolis.products.infrastructure.repository.mybatis.entitys;

import co.com.delibolis.products.domain.enums.ProductType;
import lombok.Data;

@Data
public class ProductEntity {

    private String productId;
    private String productCode;
    private String productName;
    private String productLastName;
    private ProductType productType;
}
