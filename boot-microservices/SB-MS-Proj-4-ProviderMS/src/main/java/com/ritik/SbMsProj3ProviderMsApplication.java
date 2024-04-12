package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SbMsProj3ProviderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj3ProviderMsApplication.class, args);
	}

}
