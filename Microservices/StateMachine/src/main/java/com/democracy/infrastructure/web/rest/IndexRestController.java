package com.democracy.infrastructure.web.rest;


import com.democracy.application.services.OrderService;
import com.democracy.domain.models.Order;
import com.democracy.domain.models.OrderInvoice;
import com.democracy.domain.models.Street;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statemachine/calculate-invoices")
@RefreshScope
public class IndexRestController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/new")
    public ResponseEntity<Order> newOrder(@RequestBody Order order){
        Order orderReturn = orderService.newOrder(order);
        return new ResponseEntity<Order>(orderReturn, null, HttpStatus.OK);
    }

}

