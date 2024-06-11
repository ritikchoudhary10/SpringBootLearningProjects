package com.ritik;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//Enabling Schedulling on this application by using Enableschedulling annotation
//   on the top of main class or class having SpringBoootApplication Annotation

@SpringBootApplication
@EnableScheduling
public class SbBoot01SchedullingPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbBoot01SchedullingPocApplication.class, args);
		System.out.println("Bootstraping completed at ::"+new Date(System.currentTimeMillis()));
	}

}
