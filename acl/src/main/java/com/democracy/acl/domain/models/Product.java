package com.democracy.acl.domain.models;

import com.democracy.acl.domain.models.enums.ProductType;
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