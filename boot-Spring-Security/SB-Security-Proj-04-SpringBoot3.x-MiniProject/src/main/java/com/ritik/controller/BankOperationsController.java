package com.ritik.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class BankOperationsController {

	@GetMapping({"/","/home"}) //home page url
	public String homePageView() {
		System.out.println("BankOperationsController.homePageView()");
		
		//returning Logical view name
		return "home";
	}
	
	@GetMapping("/approve_loan")
	//@PreAuthorize("hasAuthority('ROLE_MANAGER')")   //specifying the authorization
	public String approveLoan(Map<String ,Object> map) {
		map.put("loan_amount", new Random().nextInt(10000000));
		return "approve_loan";
	}
	
	@GetMapping("/show_balance")
	//@PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER' ,'ROLE_MANAGER')")	//specifying the authorization
	public String showBalance(Map<String ,Object> map) {
		map.put("balance", new Random().nextInt(1000000));
		return "show_balance";
	}
	
	@GetMapping("/offers")
	public String getOffersPage() {
		return"offers";
	}
	
	@GetMapping("/access_denied")
	public String accessdenied() {
		return "/access_denied";
	}
	
}
