package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsProj2EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj2EurekaServerApplication.class, args);
	}

}
