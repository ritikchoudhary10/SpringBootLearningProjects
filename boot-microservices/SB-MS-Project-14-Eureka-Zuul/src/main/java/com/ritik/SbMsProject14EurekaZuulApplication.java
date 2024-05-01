package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SbMsProject14EurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject14EurekaZuulApplication.class, args);
	}

}
