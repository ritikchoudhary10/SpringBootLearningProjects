package com.ritik.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ProviderMS")
public interface ConsumerClient {
	
	@GetMapping("/ms-project/wishme")
	public ResponseEntity<String> getWish();

}
