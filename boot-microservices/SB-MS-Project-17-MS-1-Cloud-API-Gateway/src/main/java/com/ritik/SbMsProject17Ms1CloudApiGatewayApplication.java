package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SbMsProject17Ms1CloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject17Ms1CloudApiGatewayApplication.class, args);
	}

}
