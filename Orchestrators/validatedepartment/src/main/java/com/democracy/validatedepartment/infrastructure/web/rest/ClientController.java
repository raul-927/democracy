package com.democracy.validatedepartment.infrastructure.web.rest;


import com.democracy.validatedepartment.application.client.HelloClient;
import com.democracy.validatedepartment.application.services.OrderService;
import com.democracy.validatedepartment.domain.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/validatedepartment")
public class ClientController {

    @Autowired
    private HelloClient client;

    @Autowired
    private OrderService orderService;

    @PostMapping("/goal")
    public String hello(@RequestHeader(value="Authorization") String userAgent) {
        System.out.println("AUTHORIZATION: "+userAgent);
        Order returnOrder = orderService.newOrder(new Order());
        return "OK";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Order> newOrder(@RequestBody Order order, @RequestHeader(value="Authorization") String userAgent){
        System.out.println("AUTHORIZATION: "+userAgent);
        return Mono.just(orderService.newOrder(order));
    }


}
