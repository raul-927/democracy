package com.democracy.infrastructure.web.rest;


import com.democracy.application.services.StreetService;
import com.democracy.domain.models.OrderInvoice;
import com.democracy.domain.models.Street;
import com.democracy.infrastructure.events.OrderEvents;
import com.democracy.infrastructure.satates.OrderStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/statemachine/calculate-invoices")

public class IndexRestController {

    //@Autowired
    private StateMachineFactory<OrderStates, OrderEvents> stateMachineFactory;

    @Autowired
    private StreetService service;

    @GetMapping(
            value = "/select",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public void callStreets() throws Exception {
        System.out.println("LLEGO!!");
        service.callStreet(new Street());
    }

    @PutMapping("/change")
    public String changeState(@RequestBody OrderInvoice order){
        System.out.println("LLEGA");
        //making the machine in current state of the order
        StateMachine<OrderStates, OrderEvents> sm =    build(order);
        sm.getExtendedState().getVariables().put("paymentType",order.getPaymentType());
        sm.sendEvent(
                MessageBuilder.withPayload(OrderEvents.valueOf(order.getEvent()))
                        .setHeader("orderId",order.getId())
                        .setHeader("state",order.getState())
                        .build()
        );
        return "state changed";
    }
    public StateMachine<OrderStates,OrderEvents> build2(final OrderInvoice orderDto){
        OrderInvoice orderInvoice = OrderInvoice.builder()
                .event(orderDto.getEvent())
                .id(orderDto.getId())
                .state(orderDto.getState())
                .paymentType(orderDto.getPaymentType()).build();
        var orderDb =  orderInvoice;
        var stateMachine =  this.stateMachineFactory.getStateMachine(orderDto.getId().toString());
        stateMachine.stop();
        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(sma -> {
                    sma.resetStateMachine(new DefaultStateMachineContext<>(OrderStates.valueOf(orderDb.getState()), null, null, null));
                });
        stateMachine.start();
        return stateMachine;
    }


    public StateMachine<OrderStates,OrderEvents> build(final OrderInvoice orderDto){
        OrderInvoice orderInvoice = OrderInvoice.builder()
                .event(OrderEvents.PAY.name())
                .id(orderDto.getId())
                .state(orderDto.getState())
                .paymentType(orderDto.getPaymentType()).build();
        var order2 = Optional.of(orderInvoice);
        var orderDb =  order2;
        var stateMachine =  this.stateMachineFactory.getStateMachine(orderDto.getId().toString());
        stateMachine.stop();
        stateMachine.getStateMachineAccessor()
                .doWithAllRegions(sma -> {
                    sma.addStateMachineInterceptor(new StateMachineInterceptorAdapter<>() {
                        @Override
                        public void preStateChange(State<OrderStates, OrderEvents> state, Message<OrderEvents> message, Transition<OrderStates, OrderEvents> transition, StateMachine<OrderStates, OrderEvents> stateMachine, StateMachine<OrderStates, OrderEvents> rootStateMachine) {
                            var orderId = Long.class.cast(message.getHeaders().get("orderId"));
                            var order =  order2;
                            if(order.isPresent()){
                                order.get().setState(state.getId().name());
                            }
                        }
                    });
                    sma.resetStateMachine(new DefaultStateMachineContext<>(OrderStates.valueOf(orderDb.get().getState()), null, null, null));
                });

        stateMachine.start();
        return stateMachine;

    }




}
