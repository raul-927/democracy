package com.democracy.feingtarget.domain.models;

import com.democracy.feingtarget.domain.enums.ProductType;
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
