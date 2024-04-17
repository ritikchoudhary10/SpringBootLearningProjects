package com.ritik.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ritik.model.Tourist;

@FeignClient("PRODUCERMS")
public interface IClientProducerMS {
	
	@PostMapping("/tourist-api/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist);

	@GetMapping("/tourist-api/report/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id);
	
	@GetMapping("/tourist-api/report/allTourist")
	public ResponseEntity<List<Tourist>> getAllTouristData();
}
