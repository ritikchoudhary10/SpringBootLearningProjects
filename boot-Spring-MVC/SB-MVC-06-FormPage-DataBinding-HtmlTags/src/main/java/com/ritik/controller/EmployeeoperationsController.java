package com.ritik.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ritik.model.Employee;

@Controller
public class EmployeeoperationsController {

	@GetMapping("/")
	public String getHome() {
		//return LVN
		return "home";
	}
	
	@GetMapping("/addEmp")
	public String empForm() {
		//return LVN
		return "emp_form";
	}
	
	@PostMapping("/showEmp")
	public String showEmployeeData(@ModelAttribute("emp") Employee employee ,Map<String ,Object> sharedMemory) {
		sharedMemory.put("emp" ,employee);
		return "show_details";
	}
}
