package com.democracy.infrastructure.web.rest;


import com.democracy.application.services.OrderService;
import com.democracy.domain.models.Order;
import com.democracy.infrastructure.client.DepartmentFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/statemachine/order")
@RefreshScope
public class OrderRestController {

    @Autowired
    private OrderService orderService;

@Autowired
private DepartmentFeingClient feingClient;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Order> newOrder(@RequestBody Order order){
        return Mono.just(orderService.newOrder(order));
    }

    @GetMapping("/test")
    public Mono<Long> test(){
        feingClient.selectCount().subscribe(r->{
            final var r1 = r;
            System.out.println("RESULT: "+r1);
        });;

        return null;
    }

}

