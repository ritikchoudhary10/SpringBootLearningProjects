package com.ritik;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ritik.bean.Employee;
import com.ritik.controller.EmployeeManagerController;

@SpringBootApplication
public class SbProj4LayeredApplicationDevelopment {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SbProj4LayeredApplicationDevelopment.class, args);
		EmployeeManagerController ctr= ctx.getBean("empController",EmployeeManagerController.class);
		try {
			List<Employee> list=ctr.getDetails("CLEK", "ANALST", "SALSMAN");
			if(!list.isEmpty()) {
				
			list.forEach((emp)->{
				System.out.println(emp);
			});
			}
			else {System.out.println("Designation not entered properly check spelling");}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String[] sa =  ctx.getBeanDefinitionNames();
		
		/*
		 * for (int i = 0; i < sa.length; i++) {
		 * 
		 * System.out.println(sa[i]); }
		 */
		System.out.println(sa.length);
	}

}
