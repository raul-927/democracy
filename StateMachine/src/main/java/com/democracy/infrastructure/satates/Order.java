package com.democracy.infrastructure.satates;

import lombok.Data;

/**
 * @description: mock orders
 */
@Data
public class Order {
    private Integer orderId;
    private OrderStatusEnum orderStatus;
}
