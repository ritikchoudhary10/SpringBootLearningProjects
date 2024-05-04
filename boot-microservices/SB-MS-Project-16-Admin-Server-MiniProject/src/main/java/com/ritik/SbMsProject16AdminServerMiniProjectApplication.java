package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SbMsProject16AdminServerMiniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject16AdminServerMiniProjectApplication.class, args);
	}

}
