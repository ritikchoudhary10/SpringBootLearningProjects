package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.repository.ICustomerRepository;

@Component
public class StaticScalarOperationTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("=====================================================================================");
		repo.findBybillAmtBetween(70000.0, 85000.0).forEach((cust)->{
			System.out.println(cust.getcId()+"......."+cust.getbillAmt());
		});
		System.out.println("=====================================================================================");
	}

}
