package com.ritik.ms;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/demo-api")
public class DemoController {
	
	private int count=1;

	@GetMapping("/call")
	@HystrixCommand(fallbackMethod = "fallbackMethodCall",
					commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled" ,value="true"),
										 @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"),	
										 @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="40000")	
					})
	public String exceptionMethod() { 
		if(new Random().nextInt(10) <8) {
			System.out.println("b.logic method executed");
			throw new RuntimeException("Eception raise in the method calling fallback method");}
		System.out.println("b.logic method executed successfully");
		return "method executed successfully";
	}
	
	public String fallbackMethodCall() {
		System.out.println("Fallback method executed for "+(count++) + " time");
		return "Fallback method executed ";
	}
}
