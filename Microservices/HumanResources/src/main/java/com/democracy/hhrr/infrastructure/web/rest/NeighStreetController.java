package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.aux.NeighborhoodStreetService;
import com.democracy.hhrr.domain.aux.NeighborhoodStreet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/neighstreet")
@RefreshScope
public class NeighStreetController {

    @Autowired
    private NeighborhoodStreetService neighborhoodStreetService;

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultipleNeighStreet(@RequestBody List<NeighborhoodStreet> neighborhoodStreetList){
        return neighborhoodStreetService.createMultipleNeighStreet(neighborhoodStreetList);
    }



}
