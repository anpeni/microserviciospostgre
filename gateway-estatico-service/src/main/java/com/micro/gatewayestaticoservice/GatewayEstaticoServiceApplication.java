package com.micro.gatewayestaticoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayEstaticoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayEstaticoServiceApplication.class, args);
	}



}
