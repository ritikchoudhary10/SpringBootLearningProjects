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

		// save operation
		/*
		 * try { Student std = new Student(null, "Rahul", 9913455556L, "kgn");
		 * System.out.println(ser.addStudent(std)); }catch(Exception e) {
		 * e.printStackTrace(); }
		 */

		// SaveAll operation

		/*
		 * try { ser.addStudents(null); }catch(Exception e) {e.printStackTrace();}
		 */

		// get All records
		/*
		 * try { ser.getAllStudentsDetails().forEach(System.out::println);
		 * }catch(Exception e) {e.printStackTrace();}
		 */

		// Find total Students
		/*
		 * try { System.out.println("Total no. of Students are "+ser.studentCount());
		 * }catch(Exception e) {e.printStackTrace();}
		 */

		// checking the record exists or not

		try {
			System.out.println(ser.isStudentAvailable(101L));
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
