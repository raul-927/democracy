package com.democracy.feingtarget.infrastructure.web.rest;


import com.democracy.feingtarget.applications.services.ProductService;
import com.democracy.feingtarget.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/target")
@RefreshScope
public class TargetController {


    @GetMapping(
            value = "/text",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getText(){

        return new ResponseEntity<>("LLEGA A CONECTAR", null, HttpStatus.OK);
    }
}
