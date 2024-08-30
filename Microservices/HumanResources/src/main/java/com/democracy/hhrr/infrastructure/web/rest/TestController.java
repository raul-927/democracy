package com.democracy.hhrr.infrastructure.web.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/test")
@RefreshScope
public class TestController {

    @Value("${app.test}")
    private String testProperty;

    @GetMapping
    public String getTest(){
        return testProperty;
    }

}
