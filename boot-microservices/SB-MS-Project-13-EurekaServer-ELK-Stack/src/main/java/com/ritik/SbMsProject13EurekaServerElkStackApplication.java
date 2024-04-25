package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class SbMsProject13EurekaServerElkStackApplication {

	public static void main(String[] args) {
		log.debug("start of main method of Eureka server");
		SpringApplication.run(SbMsProject13EurekaServerElkStackApplication.class, args);
		log.debug("end of main method of Eureka server");
	}

}
