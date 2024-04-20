package com.ritik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class SbMsProject12FallBackMethodWithCircuitBreakerHystrixDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMsProject12FallBackMethodWithCircuitBreakerHystrixDashBoardApplication.class, args);
	}

}
