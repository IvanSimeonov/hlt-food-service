package com.ivnsim.hltfoodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HltFoodServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HltFoodServiceApplication.class, args);
	}

}
