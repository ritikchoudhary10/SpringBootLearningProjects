package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient 
public class SbMsProj6EmployeeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj6EmployeeMsApplication.class, args);
	}

}
