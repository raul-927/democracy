package com.democracy.application.services;

import com.democracy.domain.models.Order;

public interface OrderService {
    Order newOrder(Order order);
    void initOrderSaga();
    void validateOrder(Order order);
    void payOrder();
    void shipOrder();
    void completeOrder();
    void stopOrderSaga();
}
