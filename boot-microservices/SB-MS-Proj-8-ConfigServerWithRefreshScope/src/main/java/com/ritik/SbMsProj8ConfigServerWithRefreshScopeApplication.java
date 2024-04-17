package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SbMsProj8ConfigServerWithRefreshScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProj8ConfigServerWithRefreshScopeApplication.class, args);
	}

}
