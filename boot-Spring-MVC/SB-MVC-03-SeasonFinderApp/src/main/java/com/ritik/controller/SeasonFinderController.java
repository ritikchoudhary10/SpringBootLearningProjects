package com.ritik.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ritik.service.SeasonFinderService;

@Controller
public class SeasonFinderController {

	@Autowired
	private SeasonFinderService ser;
	//mapping for home page 
	
	@RequestMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String getSeasonDetails(Map<String ,Object> map) {
		String season = ser.findSeason();
		map.put("season", season);
		return "display";
	}
	
}
