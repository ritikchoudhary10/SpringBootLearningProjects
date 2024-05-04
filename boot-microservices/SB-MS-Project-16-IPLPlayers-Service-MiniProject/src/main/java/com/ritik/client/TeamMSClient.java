package com.ritik.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ritik.entity.IPLTeam;

@FeignClient("IPLTEAMS-SERVICE")
public interface TeamMSClient {

	@GetMapping("/team-api/get/{id}")
	public ResponseEntity<IPLTeam> getTeamById(@PathVariable Integer id);
}
