package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SbMsProj5ConsumerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj5ConsumerMsApplication.class, args);
	}

}
