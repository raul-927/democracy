package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.CityService;

import com.democracy.hhrr.domain.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/city")
@RefreshScope
public class CityController {

    @Autowired
    private CityService cityService;


    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<City> selectCity(@RequestBody City city){
        return this.cityService.selectCity(city);
    }

    @GetMapping(
            value = "/select-all",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<City> selectAllCity(){
        return this.cityService.selectAllCity();
    }


    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createCity(@RequestBody City city){
        return this.cityService.createCity(city);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<City> cityList){
        return this.cityService.createMultipleCity(cityList);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateCity(@RequestBody City city){
        return this.cityService.updateCity(city);
    }

    @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCountCity(){
        return cityService.selectCount();
    }

    @DeleteMapping(value="/delete/{cityId}")
    public Mono<Integer> deleteAddress(@PathVariable String cityId){
        return this.cityService.deleteCity(cityId);
    }


}
