package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.repository.ICustomerRepository;

@Component 
public class CustomFinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*		System.out.println("==========================================================================");
				repo.findBycName("Ritik").forEach(System.out::println);
				System.out.println("==========================================================================");
		*/		
		/*		System.out.println("==========================================================================");
				repo.findBycCity("Indore").forEach(System.out::println);;
				System.out.println("==========================================================================");
		*/		
		/*		System.out.println("==========================================================================");
				repo.findBybillAmt(65488.0).forEach(System.out::println);;
				System.out.println("==========================================================================");
		*/		
		/*		System.out.println("==========================================================================");
				repo.findBycNameLike("%t%").forEach(System.out::println);
				System.out.println("==========================================================================");
		*/
		/*		System.out.println("==========================================================================");
				repo.findBycNameStartingWith('R').forEach(System.out::println);
				System.out.println("==========================================================================");
		 */		
		/*		System.out.println("==========================================================================");
				repo.findBycNameEndingWith('u').forEach(System.out::println);
				System.out.println("==========================================================================");
		 */	
		/*		System.out.println("==========================================================================");
				repo.findBybillAmtBetween(60000.0, 70000.0).forEach(System.out::println);
				System.out.println("==========================================================================");
		*/	
		/*		System.out.println("==========================================================================");
				repo.findBybillAmtLessThanEqual(80000.0).forEach(System.out::println);
				System.out.println("==========================================================================");
		*/		
		/*		System.out.println("==========================================================================");
				repo.findBybillAmtGreaterThanEqual(80000.0).forEach(System.out::println);
				System.out.println("==========================================================================");
		*/ 		
		
	
	}

}
