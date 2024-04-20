package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.repository.ICustomerRepository;
import com.ritik.views.CustomerView1;
import com.ritik.views.CustomerView2;
import com.ritik.views.CustomerView3;
import com.ritik.views.CustomerView4;

@Component
public class DynamicScalarOperationTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("=====================================================================================");
		repo.findBycName("Ritik", CustomerView1.class).forEach((cust)->{
			System.out.println(cust.getcId()+"........."+cust.getbillAmt());
		});
		System.out.println("=====================================================================================");
		
		System.out.println("=====================================================================================");
		repo.findBybillAmtGreaterThan(80000.0, CustomerView2.class).forEach((cust)->{
			System.out.println(cust.getcId()+"........."+cust.getcName());
		});
		System.out.println("=====================================================================================");
		
		System.out.println("=====================================================================================");
		repo.findBycNameContaining("i", CustomerView3.class).forEach((cust)->{
			System.out.println(cust.getcName()+"........."+cust.getbillAmt());
		});
		System.out.println("=====================================================================================");
		
		System.out.println("=====================================================================================");
		repo.findBycName("Himanshu", CustomerView4.class).forEach((cust)->{
			System.out.println(cust.getcId()+"........."+cust.getcName()+"........."+cust.getbillAmt());
		});
		System.out.println("=====================================================================================");

	}

}
