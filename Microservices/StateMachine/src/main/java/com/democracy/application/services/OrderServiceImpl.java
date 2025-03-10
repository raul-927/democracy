package com.democracy.application.services;

import com.democracy.domain.models.Order;
import com.democracy.infrastructure.events.OrderEvents;
import com.democracy.infrastructure.satates.OrderStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private StateMachineFactory<OrderStates, OrderEvents> machineFactory;
    private StateMachine<OrderStates, OrderEvents> stateMachine;


    @Override
    public Order newOrder(Order order) {
        initOrderSaga();
        validateOrder(order);
        payOrder();
        shipOrder();
        completeOrder();
        return order;
    }
    @Override
    public void initOrderSaga(){
        System.out.println("Initializing order saga");
        stateMachine = machineFactory.getStateMachine();
        stateMachine.startReactively().subscribe();
        System.out.println("Final state initOrderSaga: "+stateMachine.getState().getId());
    }
    @Override
    public void validateOrder(Order order) {
        System.out.println("Validating order");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.VALIDATE)
                                .setHeader("order",order).build()))
                .subscribe(result -> System.out.println("RESULT validateOrder: "+result.getResultType()));
        System.out.println("Final state validateOrder: "+stateMachine.getState().getId());
    }
    @Override
    public void payOrder() {
        System.out.println("Paying order...");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.PAY).build()))
                .subscribe(result -> System.out.println("RESULT payOrder: "+result.getResultType()));
        System.out.println("Final state payOrder: "+stateMachine.getState().getId());
    }
    @Override
    public void shipOrder() {
        System.out.println("Shipping order...");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.SHIP).build()))
                .subscribe(result -> System.out.println("RESULT shipOrder: "+result.getResultType()));
        System.out.println("Final state: shipOrder "+stateMachine.getState().getId());
    }
    @Override
    public void completeOrder() {
        System.out.println("Completing order.");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.COMPLETE).build()))
                .subscribe(result -> System.out.println("RESULT completeOrder: "+result.getResultType()));
        System.out.println("Final state completeOrder: "+stateMachine.getState().getId());
        stopOrderSaga();
    }
    @Override
    public void stopOrderSaga(){
        System.out.println("Stopping saga...");
        System.out.println("------------------------");
        stateMachine.stopReactively().subscribe();
    }
}
