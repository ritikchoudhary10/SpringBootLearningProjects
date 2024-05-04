package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsProject17EurekaSpringCloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject17EurekaSpringCloudApiGatewayApplication.class, args);
	}

}
