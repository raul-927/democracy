package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.CityService;
import com.democracy.hhrr.application.services.CriminalRecordService;
import com.democracy.hhrr.domain.models.City;
import com.democracy.hhrr.domain.models.CriminalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/criminalrecord")
@RefreshScope
public class CriminalRecordController {

    @Autowired
    private CriminalRecordService criminalRecordService;


    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<CriminalRecord> selectCity(@RequestBody CriminalRecord criminalRecord){
        return this.criminalRecordService.selectCriminalRecord(criminalRecord);
    }

    @GetMapping(
            value = "/select-all",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<CriminalRecord> selectAllCity(){
        return this.criminalRecordService.selectAllDCriminalRecords();
    }


    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createCity(@RequestBody CriminalRecord criminalRecord){
        return this.criminalRecordService.createCriminalRecord(criminalRecord);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateCity(@RequestBody CriminalRecord criminalRecord){
        return this.criminalRecordService.updateCriminalRecord(criminalRecord);
    }

    @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCountCity(){
        return criminalRecordService.selectCount();
    }

    @DeleteMapping(value="/delete/{cityId}")
    public Mono<Integer> deleteAddress(@PathVariable String criminalRecordId){
        return this.criminalRecordService.deleteCriminalRecord(criminalRecordId);
    }


}
