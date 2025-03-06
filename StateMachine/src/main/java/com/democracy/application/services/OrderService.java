package com.democracy.application.services;



import java.util.Map;
import com.democracy.infrastructure.satates.Order;
/**
 * @author liuhaihua
 * @version 1.0
 * @ClassName OrderService
 * @Description todo
 * @date 2024年05月27日 15:15
 */

public interface OrderService {

    Order create(Order order);

    Order pay(Order order);

    Order deliver(Order order);

    Order receive(Order order);

    Map<Integer, Order> getOrders();
}
