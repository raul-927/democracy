package com.democracy.infrastructure.client;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name="humanresources", url="localhost:8082")
public interface DepartmentFeingClient {

   @RequestMapping( method = RequestMethod.GET, value = "/humanresources/department/select-count")
   Mono<Long> selectCount();
}
