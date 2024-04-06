package com.ritik.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider-api")
public class PathVarDemo {
	
	@GetMapping("/update/data1/data2")
	public ResponseEntity<String>  method1(@PathVariable(name="data1",required=false) Integer no,
																						@PathVariable(name="data1",required=false) Double name) {
		return new ResponseEntity<String>("data passed " , HttpStatus.OK);
	}
	
	@GetMapping("/update/{data1}/{data2}")
	private ResponseEntity<String> method2(@PathVariable(name = "data1" ,required = false)     Integer first,
																						@PathVariable(name = "data1" , required=false)	Double second) {
		return new ResponseEntity<String>("method 2", HttpStatus.OK);
	} 
	
	@GetMapping("/update/{data1}/data2")
	private ResponseEntity<String> method3(@PathVariable(name = "data1" , required=false)     Integer first,
																						@PathVariable(name = "data1",required=false)	Double second) {
		return new ResponseEntity<String>("method3", HttpStatus.OK);
	}
	
	@GetMapping("/update/data1/{data2}")
	private ResponseEntity<String> method4(@PathVariable(name = "data1" ,required=false)     Integer first,
																						@PathVariable(name = "data1",required=false)	    Double  second) {
		return new ResponseEntity<String>("method 4", HttpStatus.OK);
	}

}
