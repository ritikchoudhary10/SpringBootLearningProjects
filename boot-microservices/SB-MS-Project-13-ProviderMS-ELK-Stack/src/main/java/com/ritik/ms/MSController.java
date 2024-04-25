package com.ritik.ms;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ms-project")
@Slf4j
public class MSController {
	
	@Value("${server.port}")
	private String portNo;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	@GetMapping("/wishme")
	public ResponseEntity<String> getWish(){
		log.debug("start of getWish() method ");
		int hour = LocalDateTime.now().getHour();
		log.info("getting current day hour from java.Time api "+hour);
		log.info("getting current day hour from java.Time api "+hour);
		if(hour>=6 && hour<12)
			return new ResponseEntity<String>("port No -"+portNo+" :: instance-id -"+instanceId+"Good Morning ", HttpStatus.OK);
		if(hour>=12 && hour<18)
			return new ResponseEntity<String>("port No -"+portNo+" :: instance-id -"+instanceId+"Good Afternoon ",HttpStatus.OK);
		log.debug("start of result is prepared and returned");
		return new  ResponseEntity<String>("port No -"+portNo+" :: instance-id -"+instanceId+"Good Evening ", HttpStatus.OK);
	}
}
