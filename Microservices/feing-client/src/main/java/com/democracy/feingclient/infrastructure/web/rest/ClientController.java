package com.democracy.feingclient.infrastructure.web.rest;


import com.democracy.feingclient.applications.services.ProductService;
import com.democracy.feingclient.domain.models.Product;
import com.democracy.feingclient.infrastructure.client.TargetFeingClient;
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
@RequestMapping("/client")
@RefreshScope
public class ClientController {

   // @Autowired
    private TargetFeingClient feingClient;
  
    @GetMapping(
            value = "/call-text",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> callText(){
        return new ResponseEntity<>(feingClient.getText(), null, HttpStatus.OK);
    }
}
