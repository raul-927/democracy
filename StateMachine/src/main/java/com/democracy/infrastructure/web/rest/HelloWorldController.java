package com.democracy.infrastructure.web.rest;


import com.democracy.application.services.OrderService;
import com.democracy.infrastructure.satates.Order;
import com.democracy.infrastructure.satates.OrderStatusEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/statemachine/calculate-invoices")
public class HelloWorldController {

    @RequestMapping("/hello")
    public Map<String, Object> showHelloWorld(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }
    @Resource
    private OrderService orderService;

    @PostMapping("/testOrderStatusChange")
    public String testOrderStatusChange(@RequestBody Order order){
        orderService.create(order);
        //orderService.pay(order);
        //orderService.deliver(order);
        //orderService.receive(order);
        System.out.println("all orders：" + orderService.getOrders());
        return "success";
    }

}