package com.democracy.hhrr.infrastructure.web.rest;



import com.democracy.hhrr.application.services.NeighborhoodService;

import com.democracy.hhrr.domain.models.Neighborhood;
import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.NeighborhoodDynamicSqlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/neighborhood")
@RefreshScope
public class NeighborhoodController {

    @Autowired
    private NeighborhoodService neighborhoodService;

    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Neighborhood> selectNeighborhood(@RequestBody Neighborhood neighborhood){
        return this.neighborhoodService.selectNeighborhood(neighborhood);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createNeighborhood(@RequestBody Neighborhood neighborhood){
        return this.neighborhoodService.createNeighborhood(neighborhood);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<Neighborhood> neighborhoodList){
        return this.neighborhoodService.createMultipleNeighborhood(neighborhoodList);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateNeighborhood(@RequestBody Neighborhood neighborhood){
        return this.neighborhoodService.updateNeighborhood(neighborhood);
    }

    @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCount(){
        return this.neighborhoodService.selectCount();
    }

    @DeleteMapping(value="/delete/{neighborhoodId}")
    public Mono<Integer> deleteNeighborhood(@PathVariable String neighborhoodId){
        return this.neighborhoodService.deleteNeighborhood(neighborhoodId);
    }
}
