package com.ritik.ms;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/demo-api")
public class DemoController {
	
	private int count=1;

	@GetMapping("/call")
	@HystrixCommand(fallbackMethod = "fallbackMethodCall")
	public String exceptionMethod() { 
		if(new Random().nextInt(10) <5)
			throw new RuntimeException("Eception raise in the method calling fallback method");
		return "method executed successfully";
	}
	
	public String fallbackMethodCall() {
		System.out.println("Fallback method executed for "+(count++) + " time");
		return "Fallback method executed ";
	}
}
