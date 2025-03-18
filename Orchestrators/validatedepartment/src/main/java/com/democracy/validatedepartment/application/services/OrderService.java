package com.democracy.validatedepartment.application.services;


import com.democracy.validatedepartment.domain.models.Order;

public interface OrderService {
    Order newOrder(Order order, String token);
    void initOrderSaga();
    void validateOrder(Order order, String token);
    void payOrder();
    void shipOrder();
    void completeOrder();
    void stopOrderSaga();
}
