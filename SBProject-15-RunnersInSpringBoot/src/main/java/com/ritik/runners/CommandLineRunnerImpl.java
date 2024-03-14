package com.ritik.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.ritik.bean.Employee;
import com.ritik.controller.EmployeeManagerController;
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	@Autowired
	ApplicationContext ctx;

	public void run(String... args) throws Exception {
		System.out.println("Testing emp empController with hardcoded entries");
		EmployeeManagerController bean = ctx.getBean("empController" , EmployeeManagerController.class);
		List<Employee> details = bean.getDetails("CLERK", "Manager", "Analyst");
		details.forEach(emp ->System.out.println(emp));
		
		System.out.println("=========================================================================================================================="); 
		
		System.out.println("Testing emp empController with Command Line Arguments Entries");
		EmployeeManagerController bean2 = ctx.getBean("empController" , EmployeeManagerController.class);
		List<Employee> details2 = bean2.getDetails(args[0],args[1],args[2]);
		details2.forEach(emp ->System.out.println(emp));
		System.out.println("=========================================================================================================================="); 
		
	
	}

}
