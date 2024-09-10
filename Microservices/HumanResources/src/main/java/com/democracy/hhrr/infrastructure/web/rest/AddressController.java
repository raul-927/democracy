package com.democracy.hhrr.infrastructure.web.rest;

import com.democracy.hhrr.application.services.AddressService;
import com.democracy.hhrr.domain.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/humanresources/address")
@RefreshScope
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping(
            value = "/select",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Flux<Address> selectAddress(@RequestBody Address address){
        return this.addressService.selectAddress(address);
    }

    @PostMapping(
            value="/save",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> createAddress(@RequestBody Address address){
        return this.addressService.createAddress(address);
    }

    @PostMapping(
            value="/insert",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> insertMultiple(@RequestBody List<Address> addressList){
        return addressService.createMultipleAddress(addressList);
    }

    @PutMapping(
            value="/update",
            consumes ={MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Integer> updateAddress(@RequestBody Address address){
        return this.addressService.updateAddress(address);
    }

    @GetMapping(value="/select-count", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<Long> selectCount(){
        return this.addressService.selectCount();
    }

    @DeleteMapping(value="/delete/{addressId}")
    public Mono<Integer> deleteAddress(@PathVariable String addressId){
        return this.addressService.deleteAddress(addressId);
    }
}
