package com.ritik.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.entity.Customer;
import com.ritik.service.ICustomerService;

@Component
public class CustomerServiceTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerService ser;
	
	@Override
	public void run(String... args) throws Exception {

		/*System.out.println("====================================================================================================");
		
		//saving the data in database
		Customer cust = new Customer("Ritik", "Indore", 0.0);
		System.out.println(ser.saveCustomer(cust));
		*/
		
		/*System.out.println("====================================================================================================");
		//Customer data to be fetched with example object
		Customer cust = new Customer();
		cust.setCCity("Indore");
		ser.showCustomersByExampleData(cust, false, "cName").forEach(System.out::println);
		*/
		
		System.out.println("====================================================================================================");
		int id=2;
		Optional<Customer> opt = ser.fetchCustomerById(id);
		if (opt.isEmpty()) {
			throw new IllegalArgumentException("Customer with id "+id+" doesn't exists..!");
		}
		System.out.println(opt.get());
		
		
		System.out.println("====================================================================================================");
		System.out.println("====================================================================================================");
		System.out.println("====================================================================================================");
		
	}

}
