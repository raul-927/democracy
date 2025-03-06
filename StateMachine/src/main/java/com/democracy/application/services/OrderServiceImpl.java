package com.democracy.application.services;

import com.democracy.infrastructure.satates.Order;
import com.democracy.infrastructure.satates.OrderStatusChangeEventEnum;
import com.democracy.infrastructure.satates.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: order service
 */
@Service
public class OrderServiceImpl implements OrderService {
    //@Resource
    @Autowired
    private StateMachine<OrderStatusEnum, OrderStatusChangeEventEnum> orderStateMachine;

    private Map<Integer, Order> orders = new ConcurrentHashMap<>();
    private Mono<Message<OrderStatusChangeEventEnum>> message;

    @Override
    public Order create(Order order) {
        orders.put(order.getOrderId(), order);
        System.out.println("order create success:" + order.toString());
        pay(order);
        return order;
    }

    @Override
    public Order pay(Order order) {
        System.out.println("try to pay，order no：" +  order.getOrderId());
        Mono<Message<OrderStatusChangeEventEnum>> message = Mono.just(
                MessageBuilder.withPayload(OrderStatusChangeEventEnum.PAYED).
                        setHeader("order", order).build()
        );
        if (eventSend(message)) {
            System.out.println(" pay fail, error，order no：" + order.getOrderId());
        }else{
            deliver(order);
        }

        return orders.get(order.getOrderId());
    }

    @Override
    public Order deliver(Order order) {
        System.out.println(" try to deliver，order no：" + order.getOrderId());
        if (eventSend(Mono.just(MessageBuilder.withPayload(OrderStatusChangeEventEnum.DELIVERY)
                .setHeader("order", order).build()))) {
            System.out.println(" deliver fail，error，order no：" + order.getOrderId());
        }
        else{
            receive(order);
        }
        return orders.get(order.getOrderId());
    }

    @Override
    public Order receive(Order order) {
        System.out.println(" try to receiver，order no：" + order.getOrderId());
        if (eventSend(Mono.just(MessageBuilder.withPayload(OrderStatusChangeEventEnum.RECEIVED)
                .setHeader("order", order).build()))) {
            System.out.println(" deliver fail，error，order no：" + order.getOrderId());
        }
        return orders.get(order.getOrderId());
    }


    @Override
    public Map<Integer, Order> getOrders() {
        return orders;
    }

    /**
     * send transient  event
     * @param message
     * @return
     */
    private synchronized boolean eventSend(Mono<Message<OrderStatusChangeEventEnum>> message) {
        this.message = message;
        boolean result = false;
        try {
            orderStateMachine.startReactively();
            result = orderStateMachine.sendEvent(message);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(this.message)) {
                Order order = (Order) this.message.block().getHeaders().get("order");
                if (Objects.nonNull(order) && Objects.equals(order.getOrderStatus(), OrderStatusEnum.FINISH)) {
                    orderStateMachine.stopReactively();
                }
            }
        }
        return !result;
    }
}