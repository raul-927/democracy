package com.democracy.hhrr.infrastructure.web.rest;


import com.democracy.hhrr.application.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/humanresources/city")
@RefreshScope
public class CityController {

    @Autowired
    private CityService cityService;


}
