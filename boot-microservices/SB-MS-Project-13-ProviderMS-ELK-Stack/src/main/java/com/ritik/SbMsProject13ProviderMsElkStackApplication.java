package com.ritik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class SbMsProject13ProviderMsElkStackApplication {
	
	@Value("${server.port}")
	private static String portNo;
	
	@Value("${eureka.instance.instance-id}")
	private static String instanceId;

	public static void main(String[] args) {
		log.info("Start of main method ProviderMS on port no "+portNo+" having instance id "+instanceId);
		SpringApplication.run(SbMsProject13ProviderMsElkStackApplication.class, args);
		log.info("End of main method  ProviderMS on port no "+portNo+" having instance id "+instanceId);
	}

}
