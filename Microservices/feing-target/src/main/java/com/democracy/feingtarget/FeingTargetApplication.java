package com.democracy.feingtarget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FeingTargetApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeingTargetApplication.class, args);
	}

}
