package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SbMsProj7NativeConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj7NativeConfigServerApplication.class, args);
	}

}
