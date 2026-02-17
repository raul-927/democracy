package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.QualificationService;
import com.democracy.hhrr.application.services.QualificationService;
import com.democracy.hhrr.domain.models.Qualification;
import com.democracy.hhrr.domain.models.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/qualification")
@RefreshScope
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;


    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Qualification> selectQualification(@RequestBody Qualification qualification){
        return this.qualificationService.selectQualification(qualification);
    }

    @GetMapping(
            value = "/select-all",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Qualification> selectAllQualification(){
        return this.qualificationService.selectAllQualifications();
    }


    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createQualification(@RequestBody Qualification qualification){
        return this.qualificationService.createQualification(qualification);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<Qualification> qualificationList){
        return this.qualificationService.createMultipleQualifications(qualificationList);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateQualification(@RequestBody Qualification qualification){
        return this.qualificationService.updateQualification(qualification);
    }

    @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCountQualification(){
        return qualificationService.selectCount();
    }

    @DeleteMapping(value="/delete/{QualificationId}")
    public Mono<Integer> deleteAddress(@PathVariable String qualificationId){
        return this.qualificationService.deleteQualification(qualificationId);
    }


}
