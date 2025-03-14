package com.democracy.feingclient.infrastructure.client;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name="feing-target")
public interface TargetFeingClient {


    @RequestMapping("/target/text")
    String getText();
}
