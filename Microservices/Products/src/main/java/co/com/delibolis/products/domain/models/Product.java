package co.com.delibolis.products.domain.models;

import co.com.delibolis.products.domain.enums.ProductType;
import lombok.*;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Product {

    private String productId;
    private String productCode;
    private String productName;
    private String productLastName;
    private ProductType productType;


}
