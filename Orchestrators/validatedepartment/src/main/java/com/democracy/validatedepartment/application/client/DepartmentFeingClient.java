package com.democracy.validatedepartment.application.client;



import com.democracy.validatedepartment.domain.models.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("HumanResources")
public interface DepartmentFeingClient {

    //@PostMapping("/new")
    @RequestMapping(value = "/humanresources/prueba/text", method = GET)
    String getPrueba();
}
