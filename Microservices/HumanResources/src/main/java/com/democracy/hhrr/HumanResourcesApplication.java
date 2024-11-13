package com.democracy.hhrr;

import com.democracy.hhrr.application.services.StreetService;
import com.democracy.hhrr.domain.models.Street;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@EnableEurekaClient
public class HumanResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcesApplication.class, args);
	}
}
