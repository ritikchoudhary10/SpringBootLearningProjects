package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Slf4j
public class SbMsProject13ConsumerMsElkStackApplication {

	public static void main(String[] args) {
		log.debug("Start of ConsumerMS main method ");
		SpringApplication.run(SbMsProject13ConsumerMsElkStackApplication.class, args);
		log.debug("End of ConsumerMS main method ");
	}

}
