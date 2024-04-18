package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SbMsProject10FallBackMethodApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject10FallBackMethodApplication.class, args);
	}

}
