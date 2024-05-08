package com.ritik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	/*@RequestMapping("/home")
	public String getHome() {
		//returning logical view name
		return "welcome";
	}*/

	//getting home page data
	@RequestMapping("/")
	public String getHome() {
		//returning logical view name
		return "welcome";
	}

}
