package com.ritik;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ritik.season.SeasonGenerator;

@SpringBootApplication
public class SbDependencyInjectionApplication {

    @Bean("dt")
     LocalDate dt(){
		return LocalDate.now();
	}

	public static void main(String[] args) {
		ApplicationContext cxt=  SpringApplication.run(SbDependencyInjectionApplication.class, args);
		SeasonGenerator generator= cxt.getBean("sg" , SeasonGenerator.class);
		System.out.println(generator);
		System.out.println(cxt.getBean("dt" ,LocalDate.class ));
		System.out.println(generator.findSeason());
		
	}
}