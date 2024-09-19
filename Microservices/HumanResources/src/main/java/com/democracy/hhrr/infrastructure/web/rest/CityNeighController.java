package com.democracy.hhrr.infrastructure.web.rest;



import com.democracy.hhrr.application.services.aux.CityNeighborhoodService;
import com.democracy.hhrr.domain.aux.CityNeighborhood;
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
@RequestMapping("/humanresources/cityneigh")
@RefreshScope
public class CityNeighController {

    @Autowired
    private CityNeighborhoodService cityNeighborhoodService;

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultipleCityNeigh(@RequestBody List<CityNeighborhood> cityNeighborhoodList){
        return cityNeighborhoodService.createMultipleCityNeigh(cityNeighborhoodList);
    }



}
