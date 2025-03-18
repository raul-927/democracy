package com.democracy.hhrr.infrastructure.web.rest;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/humanresources/prueba")
@RefreshScope
public class PruebaController {


    @GetMapping("/text")
    public ResponseEntity<?>getPrueba(){


        return new ResponseEntity("ESTO ES UNA PRUEBA DESDE HUMAN RESOURCES", null, HttpStatus.OK);
    }
}
