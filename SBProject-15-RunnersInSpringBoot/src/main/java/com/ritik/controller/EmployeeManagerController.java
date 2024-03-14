package com.ritik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ritik.bean.Employee;
import com.ritik.service.EmployeeManagerServiceImpl;

@Controller("empController")
public class EmployeeManagerController {
	

	public EmployeeManagerController() {
		System.out.println("bean created");
	}

	@Autowired
	private EmployeeManagerServiceImpl service;
	
	public List<Employee> getDetails(String desgn1, String desgn2, String desgn3) throws Exception{
		 List<Employee> list=service.fetchEmployeesByDesgn(desgn1, desgn2, desgn3);
		 return list;
	}

}
