package com.democracy.validatedepartment.infrastructure.web.rest;


import com.democracy.validatedepartment.application.client.HelloClient;
import com.democracy.validatedepartment.application.services.OrderService;
import com.democracy.validatedepartment.domain.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/validatedepartment")
public class ClientController {

    @Autowired
    private HelloClient client;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/goal")
    public String hello() {
        Order returnOrder = orderService.newOrder(new Order());
        return "OK";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Order> newOrder(@RequestBody Order order){
        return Mono.just(orderService.newOrder(order));
    }


}
