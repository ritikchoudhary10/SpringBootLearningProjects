package com.ritik.ms;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-project")
public class MSController {
	
	@Value("${server.port}")
	private String portNo;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@GetMapping("/wishme")
	public ResponseEntity<String> getWish(){
		int hour = LocalDateTime.now().getHour();
		if(hour>=6 && hour<12)
			return new ResponseEntity<String>("Good Morning "+" :: port No -"+portNo+" :: instance-id -"+instanceId, HttpStatus.OK);
		if(hour>=12 && hour<18)
			return new ResponseEntity<String>("Good Afternoon "+" :: port No -"+portNo+" :: instance-id -"+instanceId,HttpStatus.OK);
		return new  ResponseEntity<String>("Good Evening "+" :: port No -"+portNo+" :: instance-id -"+instanceId, HttpStatus.OK);
	}
}
