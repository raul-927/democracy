package com.democracy.domain.models;

import com.democracy.domain.enums.OrderType;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;

@ToString
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Order {
    private Integer orderId;
    private Product product;
    private OrderType orderType;
}
