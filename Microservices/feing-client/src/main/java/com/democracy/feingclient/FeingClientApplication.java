package com.democracy.feingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
//@EnableFeignClients
public class FeingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeingClientApplication.class, args);
	}

}
