package com.ritik.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritik.entity.Student;
import com.ritik.service.IStudentService;

@Component
public class RunnerTest implements CommandLineRunner {

	@Autowired
	private IStudentService ser;

	@Override
	public void run(String... args) throws Exception {

		// getting all records sort by Asc order  
		/*try {
			Iterable<Student> sortedRecords = ser.getSortedRecords(true, "stdAdrr");
			System.out.println("=============================================================================");
			sortedRecords.forEach(System.out::println);
			System.out.println("=============================================================================");
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// getting all records sort by Desc order  
		/*try {
			Iterable<Student> sortedRecords = ser.getSortedRecords(false, "stdAdrr");
			System.out.println("=============================================================================");
			sortedRecords.forEach(System.out::println);
			System.out.println("=============================================================================");
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		// if two address are same then sort on the basis of name
		try {
			Iterable<Student> sortedRecords = ser.getSortedRecords(true, "stdAdrr" , "stdname");
			System.out.println("=============================================================================");
			sortedRecords.forEach(System.out::println);
			System.out.println("=============================================================================");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
