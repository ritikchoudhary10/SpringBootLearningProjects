package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsProj3EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj3EurekaClientApplication.class, args);
	}

}
