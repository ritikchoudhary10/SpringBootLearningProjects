package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsProj2RegisterDiscoveryEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj2RegisterDiscoveryEurekaServerApplication.class, args);
	}

}
